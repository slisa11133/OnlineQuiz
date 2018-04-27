package com.b3.service.feed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader implements FeedAdapter {
	
	//read CSV file
	@Override
	public ArrayList<String[]> readFile(String fileName) throws IOException {
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<String[]> lines = new ArrayList<String[]>();
		String line = null;
		String cvsSplitBy = ",";

		while ((line = bufferedReader.readLine()) != null) {
			String[] data = line.split(cvsSplitBy);
			lines.add(data);
		} // while
		bufferedReader.close();
		return lines;
	} // readCSV()

}
