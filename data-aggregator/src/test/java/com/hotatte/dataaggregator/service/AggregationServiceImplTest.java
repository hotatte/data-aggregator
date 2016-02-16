package com.hotatte.dataaggregator.service;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hotatte.dataaggregator.DIModule;

public class AggregationServiceImplTest {

	@Test
	public void test() {
		Injector injector = Guice.createInjector(new DIModule("src/test/resources/test-config.yaml"));

		AggregationServiceImpl service = injector.getInstance(AggregationServiceImpl.class);

		service.aggregate();
	}

}
