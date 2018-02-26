package br.com.dbarreto.ml.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Features {

	public static final int DEFAULT_INITIAL_CAPACITY = 10;
	
	private List<Feature<? extends Number>> features;
	
	public Features() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public Features(int initialCapacity) {
		features = new ArrayList<>(initialCapacity);
	}
	
	public List<Feature<?>> getFeatures() {
		return features;
	}
	
	public void addAllFeatures(Collection<Feature<? extends Number>> list) {
		features.addAll(list);
	}
	
	public void addFeature(Feature<? extends Number> e) {
		features.add(e);
	}

	@Override
	public String toString() {
		return "Features [" + features + "]";
	}
}
