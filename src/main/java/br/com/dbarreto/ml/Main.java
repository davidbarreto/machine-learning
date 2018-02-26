package br.com.dbarreto.ml;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.dbarreto.ml.algorithm.Classifier;
import br.com.dbarreto.ml.algorithm.knn.KNearestNeighborns;
import br.com.dbarreto.ml.types.Data;
import br.com.dbarreto.ml.types.Label;
import br.com.dbarreto.ml.util.FileUtils;

public class Main {
	
	private static Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws IOException {

		//Get the data
		ClassLoader loader = Main.class.getClassLoader();
		
		Data trainingData = FileUtils.parseCSVFile(loader.getResource("training-data.csv").getPath());
		Data testData = FileUtils.parseCSVFile(loader.getResource("test-data-no-label.csv").getPath());
		Data ans = FileUtils.parseCSVFile(loader.getResource("test-data.csv").getPath());
		
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
		
		logger.info("Accuracy = {}", accuracy);
	}
}
