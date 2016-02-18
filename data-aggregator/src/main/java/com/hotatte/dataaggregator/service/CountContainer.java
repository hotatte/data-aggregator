package com.hotatte.dataaggregator.service;

import java.math.BigDecimal;

final class CountContainer implements Container {
	private BigDecimal result;

	public CountContainer(BigDecimal initial) {
		this.result = initial;
	}

	@Override
	public Container add(String val) {
		if (val == null || val.isEmpty()) {
			return this;
		}

		result = result.add(BigDecimal.ONE);
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