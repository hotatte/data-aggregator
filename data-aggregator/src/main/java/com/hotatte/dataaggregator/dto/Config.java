package com.hotatte.dataaggregator.dto;

import java.util.List;
import java.util.Map;

public class Config {
	private String inputFileName;
	private List<String> dimensions;
	private Map<String, String> measures;
	private Map<String, String> filters;

	public Config() {
	}

	public void setDimensions(List<String> dimensions) {
		this.dimensions = dimensions;
	}

	public void setFilters(Map<String, String> filters) {
		this.filters = filters;
	}

	public List<String> getDimensions() {
		return dimensions;
	}

	public Map<String, String> getFilters() {
		return filters;
	}

	public Map<String, String> getMeasures() {
		return measures;
	}

	public void setMeasures(Map<String, String> measures) {
		this.measures = measures;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
	
}
