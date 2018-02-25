package br.com.dbarreto.ml.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import br.com.dbarreto.ml.types.Data;
import br.com.dbarreto.ml.types.Feature;
import br.com.dbarreto.ml.types.Features;
import br.com.dbarreto.ml.types.Label;

public class FileUtils {
	
	public static final char DEFAULT_CSV_DELIMITER = ',';

	public static Data parseCSVFile(Reader reader) throws IOException {
		return parseCSVFile(reader, true, DEFAULT_CSV_DELIMITER);
	}
	
	public static Data parseCSVFile(String filePath) throws IOException {
		return parseCSVFile(filePath, true, DEFAULT_CSV_DELIMITER);
	}
	
	public static Data parseCSVFile(String filePath, boolean hasLabel, char delimiter) throws IOException {
		Reader reader = new FileReader(filePath);
		return parseCSVFile(reader, hasLabel, delimiter);
	}
	
	public static Data parseCSVFile(Reader reader, boolean hasLabel, char delimiter) throws IOException {
		
		Data data = new Data();
		List<Features> featuresList = new ArrayList<>();
		List<Label> labelList = new ArrayList<>();
		
		for (CSVRecord record : CSVFormat.DEFAULT.withDelimiter(delimiter).parse(reader)) {
			
			Features features = new Features();
			
			Iterator<String> it = record.iterator();
			while (it.hasNext()) {
				
				String field = it.next();
				
				if (!it.hasNext() && hasLabel) {
					labelList.add(new Label(field));
				} else {
					Feature<Double> feature = new Feature<>();
					feature.setValue(Double.parseDouble(field));
					
					features.addFeature(feature);
				}
			}
			
			featuresList.add(features);
		}
		
		data.setFeatures(featuresList);
		data.setLables(labelList);
		
		return data;
	}
}
