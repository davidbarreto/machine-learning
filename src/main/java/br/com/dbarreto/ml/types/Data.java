package br.com.dbarreto.ml.types;

import java.util.List;

public class Data {

	private List<Features> features;
	private List<Label> lables;
	
	public List<Features> getFeatures() {
		return features;
	}
	public void setFeatures(List<Features> features) {
		this.features = features;
	}
	public List<Label> getLables() {
		return lables;
	}
	public void setLables(List<Label> lables) {
		this.lables = lables;
	}
	
}
