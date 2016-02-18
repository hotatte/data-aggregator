package com.hotatte.dataaggregator.dto;

import java.util.List;
import java.util.Map;

public class Config {
	private String inputFileName;
	private List<String> dimensions;
	private List<MeasureConfig> measures;
	private Map<String, String> filters;
	
	public static class MeasureConfig {
		private String label;
		private String field;
		private String aggregation;
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getField() {
			return field;
		}
		public void setField(String field) {
			this.field = field;
		}
		public String getAggregation() {
			return aggregation;
		}
		public void setAggregation(String aggregation) {
			this.aggregation = aggregation;
		}
	}
	
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

	public List<MeasureConfig> getMeasures() {
		return measures;
	}

	public void setMeasures(List<MeasureConfig> measures) {
		this.measures = measures;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
	
}
