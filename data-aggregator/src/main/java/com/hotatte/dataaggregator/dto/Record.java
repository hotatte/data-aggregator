package com.hotatte.dataaggregator.dto;

import java.util.List;

public class Record {
	public static class Dimensions {
		private final List<String> dimensions;

		public Dimensions(List<String> dimensions) {
			this.dimensions = dimensions;
		}

		public List<String> getDimensions() {
			return dimensions;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dimensions == null) ? 0 : dimensions.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Dimensions other = (Dimensions) obj;
			if (dimensions == null) {
				if (other.dimensions != null)
					return false;
			} else if (!dimensions.equals(other.dimensions))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Dimensions [dimensions=" + dimensions + "]";
		}
		
	}

	public static class Measures {

		private final List<String> measures;

		public Measures(List<String> measures) {
			this.measures = measures;
		}

		public List<String> getMeasures() {
			return measures;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((measures == null) ? 0 : measures.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Measures other = (Measures) obj;
			if (measures == null) {
				if (other.measures != null)
					return false;
			} else if (!measures.equals(other.measures))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Measures [measures=" + measures + "]";
		}
		
	}

	private final Dimensions dimensions;
	private final Measures measures;

	public Record(Dimensions dimensions, Measures measures) {
		this.dimensions = dimensions;
		this.measures = measures;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public Measures getMeasures() {
		return measures;
	}
	
}
