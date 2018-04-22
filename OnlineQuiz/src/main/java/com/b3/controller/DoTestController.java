package com.b3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.b3.model.question.QuestionObject;
import com.b3.service.BaseReportFactory;
import com.b3.service.EssayService;
import com.b3.service.question.BaseQuestionFactory;
import com.b3.model.question.QuestionMCQ;
import com.b3.service.question.MCQFactory;
import com.b3.model.question.QuestionTFQ;
import com.b3.service.question.TFQFactory;
import com.b3.model.Ability;
import com.b3.model.Essay;
import com.b3.model.Options;
import com.b3.model.QuestionAbility;
import com.b3.model.Report;
import com.b3.model.User;
import com.b3.model.UserAbility;
import com.b3.model.question.Paper;
import com.b3.model.question.QuestionBFQ;
import com.b3.service.question.BFQFactory;
import com.b3.model.Subject;
import com.b3.service.SubjectService;
import com.b3.service.question.PaperFactory;
import com.b3.model.question.QuestionEssay;
import com.b3.service.question.EssayFactory;

@Controller
@RequestMapping("/DoTest")
public class DoTestController {
	private static final Logger logger = Logger.getLogger(DoTestController.class);

	public DoTestController() {
		System.out.println("DoTestController()");
	}

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private EssayService essayService;

	@RequestMapping(value = "/chooseTest", method = RequestMethod.GET)
	public ModelAndView chooseTest(ModelAndView model, HttpServletRequest request, HttpSession httpsession) throws IOException {
		String quizType = request.getParameter("quizType");
		List<Subject> listSubjects = subjectService.getAllSubjects();
		Map<String, String> Qsubjects = new LinkedHashMap<String, String>();
		for (int i = 0; i < listSubjects.size(); i++) {
			String s_id = String.valueOf(listSubjects.get(i).getId());
			String s_name = listSubjects.get(i).getName();
			Qsubjects.put(s_id, s_name);
		}

		Map<String, String> Qgrades = new LinkedHashMap<String, String>();
		Qgrades.put("1", "1");
		Qgrades.put("2", "2");
		Qgrades.put("3", "3");
		Qgrades.put("4", "4");

		Map<String, String> Qlevels = new LinkedHashMap<String, String>();
		Qlevels.put("1", "easy");
		Qlevels.put("2", "medium");
		Qlevels.put("3", "hard");

		model.setViewName("chooseTest");
		model.addObject("Qsubjects", Qsubjects);
		model.addObject("Qgrades", Qgrades);
		model.addObject("Qlevels", Qlevels);
		model.addObject("quizType", quizType);
		
		String name=(String)httpsession.getAttribute("username");
		model.addObject("msg",name);
		
		return model;
	}

	@Autowired
	private MCQFactory MCQFactory;
	@Autowired
	private TFQFactory TFQFactory;
	@Autowired
	private BFQFactory BFQFactory;
	@Autowired
	private PaperFactory PaperFactory;
	@Autowired
	private EssayFactory EssayFactory;
	BaseQuestionFactory paperFactory;

	@RequestMapping(value = "/generatePaper", method = RequestMethod.POST)
	public ModelAndView generatePaper(HttpServletRequest request, ModelAndView model, HttpSession httpsession)
			throws IOException {
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String grade = request.getParameter("grade");
		String level = request.getParameter("level");
		User u = (User) httpsession.getAttribute("current_user");
		System.out.println(u.getId());
		paperFactory = PaperFactory;

		/** 4 MCQs **/
		while (paperFactory.getQuestionSet().size() < 4) {
			BaseQuestionFactory questionFactory = MCQFactory;
			QuestionObject question = questionFactory.createQuestion(s_id, grade, level);
			/** if add failed, then clean questonObject **/
			if (!paperFactory.addQuestion(question))
				questionFactory.clearQuestion();
		}
		/** 3 TFQs **/
		while (paperFactory.getQuestionSet().size() < 7) {
			BaseQuestionFactory questionFactory = TFQFactory;
			QuestionObject question = questionFactory.createQuestion(s_id, grade, level);
			/** if add failed, then clean questonObject **/
			if (!paperFactory.addQuestion(question))
				questionFactory.clearQuestion();
		}
		/** 3 BFQs **/
		while (paperFactory.getQuestionSet().size() < 10) {
			BaseQuestionFactory questionFactory = BFQFactory;
			QuestionObject question = questionFactory.createQuestion(s_id, grade, level);
			/** if add failed, then clean questonObject **/
			if (!paperFactory.addQuestion(question))
				questionFactory.clearQuestion();
		}
		Paper paper = paperFactory.getPaper();

		model = new ModelAndView("DoTest");
		model.addObject("questions", paper.getQuestionSet());
		return model;
	}

	@RequestMapping(value = "/submitAnswer", method = RequestMethod.POST)
	public ModelAndView submitAnswer(HttpServletRequest request, ModelAndView model) throws IOException {
		Paper paper = paperFactory.getPaper();
		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < paper.getQuestionSet().size(); i++) {
			answer.add(request.getParameter("studentAnswers" + i));
		}
		paper.setStudentAnswers(answer);

		model.addObject("questions", paper.getQuestionSet());
		model.addObject("CorrectAnswers", paper.getQuestionSet());
		model.addObject("StudentAnswers", paper.getStudentAnswers());
		model.setViewName("DoTest");
		return model;

	}

	BaseQuestionFactory essayFactory;

	@RequestMapping(value = "/generateEssay", method = RequestMethod.POST)
	public ModelAndView generateEssay(HttpServletRequest request, ModelAndView model, HttpSession httpsession)
			throws IOException {
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String grade = request.getParameter("grade");
		String level = request.getParameter("level");
		User u = (User) httpsession.getAttribute("current_user");
		System.out.println(u.getId());

		/** 1 Essay **/
		essayFactory = EssayFactory;
		QuestionObject question = essayFactory.createQuestion(s_id, grade, level);

		model = new ModelAndView("DoEssay");
		model.addObject("question", question);
		return model;
	}
	
	@RequestMapping(value = "/submitEssay", method = RequestMethod.POST)
	public ModelAndView submitEssay(HttpServletRequest request, ModelAndView model, HttpSession httpsession) throws IOException {
		QuestionObject question = essayFactory.createQuestion(0, "", ""); // get exist essay(singleton)
		String answer = request.getParameter("answer");
		User u = (User) httpsession.getAttribute("current_user");
		
		Essay essay = new Essay();
		essay.setQ_id(question.getQ_id());
		essay.setQuestion(question.getQuestion());
		essay.setAnswer(answer);
		essay.setU_id(u.getId());
		essayService.addEssay(essay);
		
		model.addObject("question", question);
		model.addObject("msg", "Essay is submitted!!");
		model.setViewName("DoEssay");
		return model;

	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public ModelAndView Cancel(HttpServletRequest request) {
		String quizType = request.getParameter("quizType");
		if (quizType.equals("Test"))
			paperFactory.clearPaper();
		else if (quizType.equals("Essay"))
			essayFactory.clearQuestion();
		return new ModelAndView("redirect:/DoTest/chooseTest?quizType="+quizType);
	}

}