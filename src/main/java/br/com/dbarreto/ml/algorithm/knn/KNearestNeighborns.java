package br.com.dbarreto.ml.algorithm.knn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.stat.Frequency;

import br.com.dbarreto.ml.algorithm.Classifier;
import br.com.dbarreto.ml.types.Distance;
import br.com.dbarreto.ml.types.Features;
import br.com.dbarreto.ml.types.Label;
import br.com.dbarreto.ml.util.DistanceUtils;

public class KNearestNeighborns implements Classifier {
	
	public static final int DEFAULT_K = 5;
	private int k;
	
	public KNearestNeighborns() {
		this(DEFAULT_K);
	}
	
	public KNearestNeighborns(int k) {
		this.k = k;
	}

	@Override
	public List<Label> classify(List<Features> trainingSet, List<Label> trainingLabels, List<Features> testSet) {
		
		List<Label> resultLabels = new ArrayList<>();
		
		for (Features testInstance : testSet) {
			
			List<Distance> distances = new ArrayList<>();
			for (int i = 0; i < trainingSet.size(); i++) {
				
				Features trainingInstance = trainingSet.get(i);
				Label trainingLabel = trainingLabels.get(i);
				
				Distance dist = DistanceUtils.calculateEuclidianDistance(trainingInstance, testInstance, trainingLabel);
				distances.add(dist);
			}
			
			Collections.sort(distances);
			resultLabels.add(getMostVotedLabel(distances));
		}
		
		return resultLabels;
	}

	private Label getMostVotedLabel(List<Distance> distances) {

		Frequency frequency = new Frequency();
		for (int i = 0; i < this.k; i++) {
			frequency.addValue(distances.get(i).getLabel());
		}

		return (Label) frequency.getMode().get(0);
	}
}
