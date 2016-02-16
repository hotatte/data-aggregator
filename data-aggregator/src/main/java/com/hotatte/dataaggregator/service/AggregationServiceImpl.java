package com.hotatte.dataaggregator.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

import com.hotatte.dataaggregator.dao.RecordDao;
import com.hotatte.dataaggregator.dto.Config;
import com.hotatte.dataaggregator.dto.Record;
import com.hotatte.dataaggregator.dto.Record.Dimensions;
import com.hotatte.dataaggregator.dto.Record.Measures;

public class AggregationServiceImpl {
	private final RecordDao recordDao;
	private final Config config;

	@Inject
	public AggregationServiceImpl(RecordDao recordDao, Config config) {
		this.recordDao = recordDao;
		this.config = config;

		this.supplier = () -> {
			return new Measures(
					config.getMeasures().keySet().stream().sorted().map(m -> "0.00").collect(Collectors.toList()));
		};
	}

	private final Supplier<Measures> supplier;

	private final BiConsumer<Measures, Measures> accumulator = (m1, m2) -> {
	};
	private final BinaryOperator<Measures> combiner = (m1, m2) -> m1;

	public void aggregate() {

		try (Stream<Record> stream = recordDao.stream()) {

			Map<Dimensions, List<Measures>> grouping = stream
					.collect(Collectors.groupingBy(record -> record.getDimensions(),
							Collectors.mapping(record -> record.getMeasures(), Collectors.toList())));

			System.out.println(grouping);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
