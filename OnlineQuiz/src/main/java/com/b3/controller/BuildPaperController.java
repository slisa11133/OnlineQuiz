
package com.b3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.b3.model.Subject;
import com.b3.service.SubjectService;
import com.b3.model.Question;
import com.b3.service.QuestionService;
import com.b3.model.Options;
import com.b3.service.OptionService;



@Controller
public class BuildPaperController{
	int sub_id = 0; 
	private static final Logger logger = Logger.getLogger(BuildPaperController.class);
	
	public void BuildPaperController() {
		System.out.println("buildpapercontroller");
	}

	@Autowired
	private SubjectService subjectservice;
	@RequestMapping(value = "/")
	public ModelAndView subjectList(ModelAndView model) throws IOException {
		List<Subject> subjectlist = subjectservice.getAllSubjects();
		for(Subject su:subjectlist) {
			System.out.println(su.getName());
		}
		model.addObject("type", "Subject");
		model.addObject("subjectlist", subjectlist);
		model.setViewName("exam");
		return model;
	}
	@Autowired
	private QuestionService  questionservice;
	@Autowired 
	private OptionService optionsrevice;

//	@RequestMapping(value = "/paper+{subject}",method = RequestMethod.GET)
//	public ModelAndView buildPaper(@PathVariable String subject,ModelAndView model) throws IOException{
//		int subjectId = Integer.valueOf(subject);
//		List<Question> questionlist = questionservice.getTenQuestionBySub(subjectId);
//		List<Paper> paperlist = paperservice.generatePaper(questionlist);
//		
//
//		model.setViewName("paper");
//		model.addObject("questionlist",questionlist);
//		return model;
//	}

	
	
}
