package com.hotatte.dataaggregator.service;

import java.math.BigDecimal;

interface Container {
	public Container add(String val);

	public Container merge(Container container);

	public BigDecimal getResult();
}