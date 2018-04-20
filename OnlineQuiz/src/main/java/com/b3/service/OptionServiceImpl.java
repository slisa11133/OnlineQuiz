package com.b3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.b3.dao.OptionDAO;
import com.b3.model.Options;

@Service
@Transactional
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionDAO optionDAO;

	@Override
	@Transactional
	// public void addOption(Option option, List<Integer> abilityList) {
	public void addOption(Options option) {
		//optionDAO.addOption(option, abilityList);
		optionDAO.addOption(option);
	}

	@Override
	@Transactional
	public List<Options> getAllOptionsByQ(Integer questionId) {
		return optionDAO.getAllOptionsByQ(questionId);
	}

	@Override
	@Transactional
	public void deleteOptionById(Integer optionId) {
		optionDAO.deleteOptionById(optionId);
	}

	public Options getOption(int optionid) {
		return optionDAO.getOptionById(optionid);
	}

	public Options updateOption(Options option) {
		// TODO Auto-generated method stub
		return optionDAO.updateOption(option);
	}

	/**public void setOptionDAO(OptionDAO optionDAO) {
		this.optionDAO = optionDAO;
	}**/

}
