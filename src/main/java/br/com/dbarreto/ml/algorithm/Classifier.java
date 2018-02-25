package br.com.dbarreto.ml.algorithm;

import java.util.List;

import br.com.dbarreto.ml.types.Features;
import br.com.dbarreto.ml.types.Label;

public interface Classifier {

	List<Label> classify(List<Features> trainingSet, List<Label> trainingLabels, List<Features> testSet);
}
