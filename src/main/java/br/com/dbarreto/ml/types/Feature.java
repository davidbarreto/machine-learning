package br.com.dbarreto.ml.types;

public class Feature<T extends Number> {

	private T value;
	
	public Feature() {}
	
	public Feature(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Feature [" + value + "]";
	}
}
