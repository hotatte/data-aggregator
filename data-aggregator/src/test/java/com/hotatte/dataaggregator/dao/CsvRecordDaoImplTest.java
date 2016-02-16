package com.hotatte.dataaggregator.dao;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.Test;

import com.hotatte.dataaggregator.dto.Record;

public class CsvRecordDaoImplTest {

	@Test
	public void test() throws IOException {
		ConfigDao configDao = new YamlConfigDaoImpl("src/test/resources/test-config.yaml");
		RecordDao recordDao = new CSVRecordDaoImpl(configDao.loadConfig());

		try (Stream<Record> st = recordDao.stream()) {
			st.forEach(r -> System.out.println(r));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
