package br.com.dbarreto.ml.util;

import br.com.dbarreto.ml.types.Distance;
import br.com.dbarreto.ml.types.Feature;
import br.com.dbarreto.ml.types.Features;
import br.com.dbarreto.ml.types.Label;

public class DistanceUtils {

	public static Distance calculateEuclidianDistance(Features trainingSet, Features testSet, Label label) {
		
		int len = Math.min(trainingSet.getFeatures().size(), testSet.getFeatures().size()); 
		
		double sum = 0;
		for (int i = 0; i < len; i++) {
			
			Feature<? extends Number> feature = trainingSet.getFeatures().get(i);
			Feature<? extends Number> anotherFeature = testSet.getFeatures().get(i);
			
			double value = feature.getValue().doubleValue();
			double anotherValue = anotherFeature.getValue().doubleValue();
			
			double diff = value - anotherValue;
			
			sum += diff*diff;
		}
		
		Distance d = new Distance(sum, label);
		
		return d;
	}
}
