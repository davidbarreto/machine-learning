package br.com.dbarreto.ml.types;

public class Distance implements Comparable<Distance> {

	private double value;
	private Label label;
	
	public Distance() {}
	
	public Distance(double value, Label label) {
		this.value = value;
		this.label = label;
	}
	
	@Override
	public int compareTo(Distance o) {
		return value < o.getValue() ? -1 : (value > o.getValue() ? 1 : 0);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
}
