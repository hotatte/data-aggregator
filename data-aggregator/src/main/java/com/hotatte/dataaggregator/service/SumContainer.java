package com.hotatte.dataaggregator.service;

import java.math.BigDecimal;

final class SumContainer implements Container {
	private BigDecimal result;

	public SumContainer(BigDecimal initial) {
		this.result = initial;
	}

	@Override
	public Container add(String val) {
		try {
			result = result.add(new BigDecimal(val));
		} catch (NumberFormatException e) {
			// Do nothing
		}
		return this;
	}

	@Override
	public BigDecimal getResult() {
		return result;
	}

	@Override
	public Container merge(Container container) {
		result = result.add(container.getResult());
		return this;
	}
}