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
import javax.transaction.Transactional;

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
import com.b3.service.GeneratePaperService;
import com.b3.service.GeneratePaperServiceImpl;
import com.b3.service.GeneratePaperServiceImpl2;
import com.b3.service.GradeService;
import com.b3.service.question.BaseQuestionFactory;
import com.b3.model.question.QuestionMCQ;
import com.b3.service.question.MCQFactory;
import com.b3.model.question.QuestionTFQ;
import com.b3.service.question.TFQFactory;
import com.b3.dao.UserAbilityDAO;
import com.b3.memento.EssayCareTaker;
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
import com.b3.memento.EssayMemento;
import com.b3.memento.EssayOriginator;

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
	@Autowired
	private EssayCareTaker essayCareTaker;
	@Autowired
	private GeneratePaperService generatePaperServiceImpl = new GeneratePaperServiceImpl();
	@Autowired
	private GeneratePaperService generatePaperServiceImpl2 = new GeneratePaperServiceImpl2();
	// @Autowired
	// private GeneratePaperService generateEssayService;

	@RequestMapping(value = "/chooseTest", method = RequestMethod.GET)
	public ModelAndView chooseTest(ModelAndView model, HttpServletRequest request, HttpSession httpsession)
			throws IOException {
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

		User u = (User) httpsession.getAttribute("current_user");
		boolean memento_exist = essayCareTaker.checkExist(u.getId());

		model.setViewName("chooseTest");
		model.addObject("Qsubjects", Qsubjects);
		model.addObject("Qgrades", Qgrades);
		model.addObject("Qlevels", Qlevels);
		model.addObject("quizType", quizType);
		model.addObject("memento_exist", memento_exist);

		String name = (String) httpsession.getAttribute("username");
		model.addObject("name", name);

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
		// paperFactory = PaperFactory;
		//
		// /** 4 MCQs **/
		// while (paperFactory.getQuestionSet().size() < 4) {
		// BaseQuestionFactory questionFactory = MCQFactory;
		// QuestionObject question = questionFactory.createQuestion(s_id, grade, level);
		// /** if add failed, then clean questonObject **/
		// if (!paperFactory.addQuestion(question))
		// questionFactory.clearQuestion();
		// }
		// /** 3 TFQs **/
		// while (paperFactory.getQuestionSet().size() < 7) {
		// BaseQuestionFactory questionFactory = TFQFactory;
		// QuestionObject question = questionFactory.createQuestion(s_id, grade, level);
		// /** if add failed, then clean questonObject **/
		// if (!paperFactory.addQuestion(question))
		// questionFactory.clearQuestion();
		// }
		// /** 3 BFQs **/
		// while (paperFactory.getQuestionSet().size() < 10) {
		// BaseQuestionFactory questionFactory = BFQFactory;
		// QuestionObject question = questionFactory.createQuestion(s_id, grade, level);
		// /** if add failed, then clean questonObject **/
		// if (!paperFactory.addQuestion(question))
		// questionFactory.clearQuestion();
		// }
		// Paper paper = paperFactory.getPaper();

		model = new ModelAndView("DoTest");

		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
		
		// model.addObject("questions", paper.getQuestionSet());
		httpsession.setAttribute("paperFactory", generatePaperServiceImpl.generatePaper(u, s_id, grade, level));

		Paper paper = generatePaperServiceImpl.generatePaper(u, s_id, grade, level).getPaper();
		model.addObject("questions", paper.getQuestionSet());
		return model;
	}

	@Autowired
	private GradeService gradeservice;
	@Autowired
	private UserAbilityDAO uasdao;

	@Transactional
	@RequestMapping(value = "/submitAnswer", method = RequestMethod.POST)
	public ModelAndView submitAnswer(HttpServletRequest request, ModelAndView model, HttpSession httpsession)
			throws IOException {
		paperFactory = (BaseQuestionFactory) httpsession.getAttribute("paperFactory");
		Paper paper = paperFactory.getPaper();
		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < paper.getQuestionSet().size(); i++) {
			answer.add(request.getParameter("studentAnswers" + i));
		}
		paper.setStudentAnswers(answer);
		User u = (User) httpsession.getAttribute("current_user");
		int result = gradeservice.gradecomputation(paper, u.getId());
		Map<String, Float> current = gradeservice.CurrentAbility(paper, u.getId());
		ArrayList<Float> currentnum = new ArrayList<Float>();
		int num = 5;
		while (num > 0) {
			if (current.containsKey(String.valueOf(num))) {
				currentnum.add(current.get(String.valueOf(num)));
			} else {
				currentnum.add((float) 0);
			}
			num--;
		}

		List<UserAbility> userability = uasdao.getUserAbilities(u.getId());

		for (UserAbility ua : userability) {
			if (current.containsKey(String.valueOf(ua.getAId()))) {
				ua.setResult(ua.getResult() + current.get(String.valueOf(ua.getAId())));
			}
		}
		for (UserAbility ua : userability) {
			uasdao.setUserAbilities(ua);
		}

		model.addObject("current", currentnum);

		model.addObject("questions", paper.getQuestionSet());
		model.addObject("CorrectAnswers", paper.getQuestionSet());
		model.addObject("StudentAnswers", paper.getStudentAnswers());

		model.addObject("grade", result);
		model.setViewName("ShowResult");
		
		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
		
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

		// /** create 1 Essay **/
		// essayFactory = EssayFactory;
		// QuestionObject question = essayFactory.createQuestion(s_id, grade, level);
		//
		// /** add to memento **/
		// EssayOriginator originator = new EssayOriginator();
		// originator.setU_id(u.getId());
		// originator.setQ_id(question.getQ_id());
		// originator.setQuestion(question.getQuestion());
		// originator.setAnswer("");
		// EssayMemento essayMemento = originator.saveToMemento();
		// essayCareTaker.addMemento(essayMemento);

		httpsession.setAttribute("essayFactory", generatePaperServiceImpl2.generatePaper(u, s_id, grade, level));
		model = new ModelAndView("DoEssay");
		// model.addObject("question", question);
		QuestionObject question = generatePaperServiceImpl2.generatePaper(u, s_id, grade, level).createQuestion(s_id,
				grade, level);

		EssayOriginator originator = new EssayOriginator();
		originator.setU_id(u.getId());
		originator.setQ_id(question.getQ_id());
		originator.setQuestion(question.getQuestion());
		originator.setAnswer("");
		EssayMemento essayMemento = originator.saveToMemento();
		essayCareTaker.addMemento(essayMemento);

		model.addObject("question", question);
		model.addObject("state", "new");
		
		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
		
		return model;
	}

	@RequestMapping(value = "/EssayMemento")
	public ModelAndView EssayMemento(ModelAndView model, HttpSession httpsession) throws IOException {
		User u = (User) httpsession.getAttribute("current_user");
		EssayMemento essayMemento = essayCareTaker.getMemento(u.getId());
		EssayOriginator originator = new EssayOriginator();
		originator.undoFromMemento(essayMemento);
		EssayMemento result = originator.getMemento();

		model = new ModelAndView("DoEssay");
		model.addObject("question", result);
		model.addObject("state", "memento");
		
		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
		
		return model;
	}

	@RequestMapping(value = "/submitEssay", method = RequestMethod.POST)
	public ModelAndView submitEssay(HttpServletRequest request, ModelAndView model, HttpSession httpsession)
			throws IOException {
		essayFactory = (BaseQuestionFactory) httpsession.getAttribute("essayFactory");
		String answer = request.getParameter("answer");
		User u = (User) httpsession.getAttribute("current_user");
		EssayMemento essayMemento = essayCareTaker.getMemento(u.getId());

		Essay essay = new Essay();
		essay.setQ_id(essayMemento.getQ_id());
		essay.setQuestion(essayMemento.getQuestion());

		essayCareTaker.removeMemento(essayMemento); // delete memento after submit essay
		essay.setAnswer(answer);
		essay.setU_id(u.getId());
		essayService.addEssay(essay);

		model.addObject("question", essayMemento);
		model.addObject("submit", "Essay is submitted!!");
		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
		model.setViewName("DoEssay");
		return model;

	}

	@RequestMapping(value = "/saveToMemento", method = RequestMethod.POST)
	public ModelAndView saveToMemento(HttpServletRequest request, ModelAndView model, HttpSession httpsession)
			throws IOException {
		String answer = request.getParameter("answer");
		User u = (User) httpsession.getAttribute("current_user");
		EssayMemento essayMemento = essayCareTaker.getMemento(u.getId());

		/** add to memento **/
		EssayOriginator originator = new EssayOriginator();
		originator.setU_id(u.getId());
		originator.setQ_id(essayMemento.getQ_id());
		originator.setQuestion(essayMemento.getQuestion());
		originator.setAnswer(answer);
		EssayMemento result = originator.saveToMemento();
		essayCareTaker.addMemento(result);

		model.addObject("question", result);
		String name=(String)httpsession.getAttribute("username");
		model.addObject("name",name);
		model.setViewName("DoEssay");
		return model;

	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public ModelAndView Cancel(HttpServletRequest request) {
		String quizType = request.getParameter("quizType");
		String state = request.getParameter("state");
		if (quizType.equals("Test"))
			paperFactory.clearPaper();
		else if (quizType.equals("Essay")) {
			//if (state.equals("new"))
			if (essayFactory != null)
				essayFactory.clearQuestion();
		}

		return new ModelAndView("redirect:/DoTest/chooseTest?quizType=" + quizType);
	}

}