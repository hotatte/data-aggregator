package com.hotatte.dataaggregator.dto;

import java.util.List;

public class Record {
	private final Dimensions dimensions;
	private final List<Measure> measures;

	public Record(Dimensions dimensions, List<Measure> measures) {
		super();
		this.dimensions = dimensions;
		this.measures = measures;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public List<Measure> getMeasures() {
		return measures;
	}
	
}
