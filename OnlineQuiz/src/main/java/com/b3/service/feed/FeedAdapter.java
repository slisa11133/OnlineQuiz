package com.b3.service.feed;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface FeedAdapter {
	
	public ArrayList<String[]> readFile(String fileName) throws IOException, ParserConfigurationException, SAXException;
}
