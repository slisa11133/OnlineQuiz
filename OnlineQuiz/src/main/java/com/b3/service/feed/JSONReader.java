package com.b3.service.feed;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader implements FeedAdapter {
	
	//read JSON file
	@SuppressWarnings("unchecked")
	public ArrayList<String[]> readFile(String fileName) throws IOException {
			
			ArrayList<String[]> lines = new ArrayList<String[]>();
						 
	        try {
	        	JSONParser parser = new JSONParser();
	            Object obj = parser.parse(new FileReader(fileName));	 
	            JSONObject jsonObject = (JSONObject) obj;
	            JSONArray questions = (JSONArray) jsonObject.get("question");
	            Iterator<JSONObject> data = questions.iterator();
	            	            
	            while (data.hasNext()) {
	    			JSONObject dataObj = data.next();
	    			Object[] arrVal = dataObj.keySet().toArray();
	    			//Arrays.sort(arrVal);
	    			ArrayList<String> line = new ArrayList<String>();
	    			for (Object key : arrVal) {

	    				String keyStr = (String) key;
	    				String keyValue = String.valueOf(dataObj.get(keyStr));
	    				System.out.println(keyStr + ": " + keyValue);
	    				line.add(keyValue);
	    			} // for
	    			lines.add(line.toArray(new String[line.size()]));
	    		} // while
	        } catch (Exception e) {
	            e.printStackTrace();
	        }// readJSON
	        
			
			//for(int i=0;i<lines.size();i++) {
				//for(int j=0;j<lines.get(i).length;j++) {
					//System.out.println(lines.get(i)[j]);
				//}
		//}
	    
	        return lines;
	}

}
