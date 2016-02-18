package com.hotatte.dataaggregator.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

import com.hotatte.dataaggregator.dao.RecordDao;
import com.hotatte.dataaggregator.dto.Config;
import com.hotatte.dataaggregator.dto.Dimensions;
import com.hotatte.dataaggregator.dto.Measure;
import com.hotatte.dataaggregator.dto.Record;

public class AggregationServiceImpl {
	private final RecordDao recordDao;
	private final Config config;
	private final Collector<Map<String, Measure>, Map<String, Container>, Map<String, BigDecimal>> collector;

	@Inject
	public AggregationServiceImpl(RecordDao recordDao, Config config) {
		this.recordDao = recordDao;
		this.config = config;
		this.collector = buildCollector(config);
	}

	private Collector<Map<String, Measure>, Map<String, Container>, Map<String, BigDecimal>> buildCollector(
			Config config) {
		final Supplier<Map<String, Container>> supplier = () -> new LinkedHashMap<>();

		final BiConsumer<Map<String, Container>, Map<String, Measure>> accumulator = (containerMap, map) -> {

			map.entrySet().forEach(entry -> {

				containerMap.compute(entry.getKey(), (key, old) -> {
					if (old == null) {
						old = ContainerFactory.createContainer(entry.getValue().getFunction());
					}
					return old.add(entry.getValue().getValue());
				});

			});

		};

		final BinaryOperator<Map<String, Container>> combiner = (m1, m2) -> {
			m1.keySet().forEach(key -> m2.merge(key, m1.get(key), (newVal, oldVal) -> newVal.merge(oldVal)));
			return m1;
		};

		final Function<Map<String, Container>, Map<String, BigDecimal>> finisher = (c) -> c.entrySet().stream()
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().getResult()));

		return Collector.of(supplier, accumulator, combiner, finisher, Characteristics.UNORDERED);
	}

	public void aggregate() {

		try (Stream<Record> stream = recordDao.stream()) {

			Map<Dimensions, Map<String, BigDecimal>> grouping = stream
					.collect(
							Collectors
									.groupingBy(
											record -> record
													.getDimensions(),
											Collectors.mapping(
													record -> record.getMeasures().stream()
															.collect(Collectors.toMap(m -> m.getName(), m -> m)),
													collector)));

			// grouping.values().stream().
			//
			System.out.println(grouping);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
