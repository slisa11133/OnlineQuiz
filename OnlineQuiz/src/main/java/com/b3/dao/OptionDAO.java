package com.b3.dao;

import java.util.List;

import com.b3.model.Options;

public interface OptionDAO {

	//public void addOption(Option option, List<Integer> abilityList);
	public void addOption(Options option);

	public List<Options> getAllOptionsByQ(Integer questionId);

	public void deleteOptionById(Integer optionId);
	
	public void deleteOptionBySub(Integer subjectId);
	
	public void deleteOptionByQ(Integer questionId);

	public Options updateOption(Options option);

	public Options getOptionById(int optionid);
	
	public Options getAnswerByQ(Integer questionId);

}
