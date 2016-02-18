package com.hotatte.dataaggregator.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.hotatte.dataaggregator.dto.Config;

public class YamlConfigDaoImplTest {
	
	@Test
	public void test() {
		ConfigDao dao = new YamlConfigDaoImpl("src/test/resources/test-config.yaml");
		Config config = dao.loadConfig();
		
		assertThat(config.getDimensions().get(0), is("Target"));
		assertThat(config.getDimensions().get(1), is("Region"));
		assertThat(config.getDimensions().get(2), is("Category"));
	}

	@Test
	public void testNullable() {
		ConfigDao dao = new YamlConfigDaoImpl("src/test/resources/test-nullable-config.yaml");
		Config config = dao.loadConfig();
		
		assertThat(config.getDimensions().get(0), is("Target"));
		assertThat(config.getDimensions().get(1), is("Region"));
		assertThat(config.getDimensions().get(2), is("Category"));
	}

}
