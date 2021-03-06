package com.hotatte.dataaggregator.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.inject.Inject;

import org.apache.commons.csv.CSVFormat;

import com.hotatte.dataaggregator.dto.Config;
import com.hotatte.dataaggregator.dto.Record;
import com.hotatte.dataaggregator.dto.Record.Dimensions;
import com.hotatte.dataaggregator.dto.Record.Measures;

public class CSVRecordDaoImpl implements RecordDao {
	private final Config config;
	private final BufferedReader reader;

	@SuppressWarnings("unused")
	@Inject
	public CSVRecordDaoImpl(Config config) {
		this.config = config;
		FileReader fr = null;
		try {
			fr = new FileReader(new File(config.getInputFileName()));
		} catch (IOException e) {
			try {
				if(fr != null) fr.close();
			} catch (IOException e1) {
				throw new RuntimeException(e1);
			}
		}

		reader = new BufferedReader(fr);
	}

	@Override
	public Stream<Record> stream() throws IOException {
		return StreamSupport.stream(CSVFormat.DEFAULT.withHeader().parse(reader).spliterator(), false)
				.map(csvRecord -> {
					List<String> dimensions = config.getDimensions().stream().map(dim -> csvRecord.get(dim))
							.collect(Collectors.toList());
					List<String> measures = config.getMeasures().keySet().stream().sorted().map(mes -> csvRecord.get(mes))
							.collect(Collectors.toList());

					return new Record(new Dimensions(dimensions), new Measures(measures));
				}).onClose(() -> {
					if(reader != null) {
						try {
							reader.close();
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
					});
	}


}
