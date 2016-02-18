package com.hotatte.dataaggregator.dto;

import java.math.BigDecimal;
import java.util.List;

public class Summaries {
	private final List<BigDecimal> summaries;

	public Summaries(List<BigDecimal> summaries) {
		this.summaries = summaries;
	}

	public List<BigDecimal> getSummaries() {
		return summaries;
	}

}
