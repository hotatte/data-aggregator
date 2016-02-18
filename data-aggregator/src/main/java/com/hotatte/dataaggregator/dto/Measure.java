package com.hotatte.dataaggregator.dto;

public class Measure {
	private final String name;
	private final String value;
	private final Function function;

	public Measure(String name, String value, Function function) {
		this.name = name;
		this.value = value;
		this.function = function;
	}
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	public Function getFunction() {
		return function;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Measure other = (Measure) obj;
		if (function != other.function)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Measure [name=" + name + ", value=" + value + ", function=" + function + "]";
	}
}