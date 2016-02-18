package com.hotatte.dataaggregator.service;

import java.math.BigDecimal;

import com.hotatte.dataaggregator.dto.Function;

class ContainerFactory {
	
	public static <T> Container createContainer(Function function) {
		if (function == Function.SUM) {
			return new SumContainer(BigDecimal.ZERO);
		}

		if (function == Function.COUNT) {
			return new CountContainer(BigDecimal.ZERO);
		}
		
		throw new RuntimeException("Unsupported function : " + function);
	}

}
