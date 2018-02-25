package br.com.dbarreto.ml;

import java.io.IOException;
import java.util.List;

import br.com.dbarreto.ml.algorithm.Classifier;
import br.com.dbarreto.ml.algorithm.knn.KNearestNeighborns;
import br.com.dbarreto.ml.types.Data;
import br.com.dbarreto.ml.types.Label;
import br.com.dbarreto.ml.util.FileUtils;

public class Main {

	public static void main(String[] args) throws IOException {

		//Get the data
		Data trainingData = FileUtils.parseCSVFile("/home/dbarreto/git/MachineLearning/src/main/resources/training-data.csv");
		Data testData = FileUtils.parseCSVFile("/home/dbarreto/git/MachineLearning/src/main/resources/test-data-no-label.csv");
		Data ans = FileUtils.parseCSVFile("/home/dbarreto/git/MachineLearning/src/main/resources/test-data.csv");
		
		//Call the classifier
		Classifier classifier = new KNearestNeighborns(5);
		List<Label> labels = classifier.classify(trainingData.getFeatures(), trainingData.getLables(), testData.getFeatures());
		
		//Compare to known values
		int count = 0;
		for (int i = 0; i < labels.size(); i++) {
			Label l = labels.get(i);
			Label test = ans.getLables().get(i);
			
			if (l.equals(test)) {
				count++;
			}
		} 
		
		//Calculate the accuracy
		double accuracy = ((double) count) / labels.size();
		
		System.out.println("Accuracy = " + accuracy);
	}
}
