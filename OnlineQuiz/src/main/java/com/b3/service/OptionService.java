package com.b3.service;

import java.util.List;

import com.b3.model.Options;

public interface OptionService {
	
	//public void addOption(Option option, List<Integer> abilityList);
	public void addOption(Options option);

	public List<Options> getAllOptionsByQ(Integer questionId);

	public void deleteOptionById(Integer optionId);

	public Options getOption(int optionid);

	public Options updateOption(Options option);
}
