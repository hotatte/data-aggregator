package com.hotatte.dataaggregator.dto;

import java.util.List;

public class Dimensions {
	private final List<String> headers;
	private final List<String> dimensions;
	
	public Dimensions(List<String> headers, List<String> dimensions) {
		this.headers = headers;
		this.dimensions = dimensions;
	}

	public List<String> getDimensions() {
		return dimensions;
	}

	public List<String> getHeaders() {
		return headers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dimensions == null) ? 0 : dimensions.hashCode());
		result = prime * result + ((headers == null) ? 0 : headers.hashCode());
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
		if (headers == null) {
			if (other.headers != null)
				return false;
		} else if (!headers.equals(other.headers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dimensions [dimensions=" + dimensions + ", headers=" + headers + "]";
	}
	
}