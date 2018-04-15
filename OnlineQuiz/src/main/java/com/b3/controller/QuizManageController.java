package com.b3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.b3.model.Subject;
import com.b3.service.SubjectService;
import com.b3.model.Question;
import com.b3.service.QuestionService;
import com.b3.model.Options;
import com.b3.service.OptionService;

@Controller
@RequestMapping("/QuizManage")
public class QuizManageController {
	int s_id = 0;
	String s_name = "";
	int q_id = 0;
	String q_content = "";
	private static final Logger logger = Logger.getLogger(QuizManageController.class);

	public QuizManageController() {
		System.out.println("QuizManageController()");
	}

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/SubjectList")
	public ModelAndView listSubject(ModelAndView model) throws IOException {
		List<Subject> listSubject = subjectService.getAllSubjects();
		model.addObject("type", "Subject");
		model.addObject("listSubject", listSubject);
		model.setViewName("QuizManage");
		return model;
	}

	@RequestMapping(value = "/newSubject", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Subject subject = new Subject();
		model.addObject("subject", subject);
		model.addObject("type", "Subject");
		model.addObject("operation", "Add New Subject");
		model.setViewName("QuizForm");
		return model;
	}

	@RequestMapping(value = "/saveSubject", method = RequestMethod.POST)
	public ModelAndView saveSubject(@ModelAttribute Subject subject) {
		// if true then creating the subject, false showing "already exist" message
		if (subject.getId() == 0) {
			if (subjectService.addSubject(subject) == true) {
				return new ModelAndView("redirect:/QuizManage/SubjectList");
			} else {
				ModelAndView model = new ModelAndView();
				model.addObject("type", "Subject");
				model.addObject("operation", "Add New Subject");
				model.addObject("msg", "Subject already exist!");
				model.setViewName("QuizForm");
				return model;
			}
		} else {
			subjectService.updateSubject(subject);
			return new ModelAndView("redirect:/QuizManage/SubjectList");
		}

	}

	@RequestMapping(value = "/deleteSubject", method = RequestMethod.GET)
	public ModelAndView deleteSubject(HttpServletRequest request) {
		int subjectId = Integer.parseInt(request.getParameter("id"));
		subjectService.deleteSubject(subjectId);
		return new ModelAndView("redirect:/QuizManage/SubjectList");
	}

	@RequestMapping(value = "/editSubject", method = RequestMethod.GET)
	public ModelAndView editSubject(HttpServletRequest request) {
		int subjectId = Integer.parseInt(request.getParameter("id"));
		Subject subject = subjectService.getSubject(subjectId);
		ModelAndView model = new ModelAndView("QuizForm");
		model.addObject("subject", subject);
		model.addObject("type", "Subject");
		model.addObject("operation", "Edit Subject");
		return model;
	}

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/QuestionList", method = RequestMethod.GET)
	public ModelAndView listQuestion(HttpServletRequest request) {
		int subjectId = Integer.parseInt(request.getParameter("s_id"));
		String subjectName = request.getParameter("s_name");
		s_id = subjectId;
		s_name = subjectName;
		List<Question> listQuestion = questionService.getAllQuestionsBySub(subjectId);
		ModelAndView model = new ModelAndView("QuizForm");
		model.addObject("type", "Question");
		model.addObject("s_id", subjectId);
		model.addObject("s_name", subjectName);
		model.addObject("listQuestion", listQuestion);
		model.setViewName("QuizManage");
		return model;
	}

	@RequestMapping(value = "/newQuestion", method = RequestMethod.GET)
	public ModelAndView newQuestion(ModelAndView model) {
		Question question = new Question();
		model.addObject("question", question);
		model.addObject("type", "Question");
		model.addObject("operation", "Add New Question");
		model.addObject("s_name", s_name);
		model.setViewName("QuizForm");
		return model;
	}

	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	public ModelAndView saveQuestion(@ModelAttribute Question question) {
		question.setSubId(s_id);
		// if true then creating the subject, false showing "already exist" message
		if (question.getId() == 0) { // add
			// List<Integer> abilityList = null;
			// questionService.addQuestion(question, abilityList);
			questionService.addQuestion(question);
		} else { // update
			questionService.updateQuestion(question);

		}
		return new ModelAndView("redirect:/QuizManage/QuestionList?s_id=" + s_id + "&s_name=" + s_name);
	}

	@RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
	public ModelAndView deleteQuestion(HttpServletRequest request) {
		int questionId = Integer.parseInt(request.getParameter("id"));
		questionService.deleteQuestionById(questionId);
		return new ModelAndView("redirect:/QuizManage/QuestionList?s_id=" + s_id + "&s_name=" + s_name);
	}

	@RequestMapping(value = "/editQuestion", method = RequestMethod.GET)
	public ModelAndView editQuestion(HttpServletRequest request) {
		int questionId = Integer.parseInt(request.getParameter("id"));
		Question question = questionService.getQuestion(questionId);
		ModelAndView model = new ModelAndView("QuizForm");
		model.addObject("question", question);
		model.addObject("type", "Question");
		model.addObject("s_name", s_name);
		model.addObject("operation", "Edit Question");
		return model;
	}

	@Autowired
	private OptionService optionService;

	@RequestMapping(value = "/OptionList", method = RequestMethod.GET)
	public ModelAndView listOption(HttpServletRequest request) {
		int questionId = Integer.parseInt(request.getParameter("q_id"));
		String question = request.getParameter("q_content");
		q_id = questionId;
		q_content = question;
		List<Options> listOption = optionService.getAllOptionsByQ(questionId);
		ModelAndView model = new ModelAndView("QuizForm");
		model.addObject("type", "Option");
		model.addObject("s_id", s_id);
		model.addObject("s_name", s_name);
		model.addObject("q_id", questionId);
		model.addObject("q_content", question);
		model.addObject("listOption", listOption);
		model.setViewName("QuizManage");
		return model;
	}

	@RequestMapping(value = "/newOption", method = RequestMethod.GET)
	public ModelAndView newOption(ModelAndView model) {
		Options option = new Options();
		model.addObject("option", option);
		model.addObject("type", "Option");
		model.addObject("operation", "Add New Option");
		model.addObject("s_name", s_name);
		model.addObject("q_content", q_content);
		model.setViewName("QuizForm");
		return model;
	}

	@RequestMapping(value = "/saveOption", method = RequestMethod.POST)
	public ModelAndView saveOption(@ModelAttribute Options option) {
		option.setQId(q_id);
		option.setSubId(s_id);
		// if true then creating the subject, false showing "already exist" message
		if (option.getId() == 0) { // add
			// List<Integer> abilityList = null;
			// questionService.addQuestion(question, abilityList);
			optionService.addOption(option);
		} else { // update
			optionService.updateOption(option);

		}
		return new ModelAndView("redirect:/QuizManage/OptionList?s_id=" + s_id + "&s_name=" + s_name + "&q_id=" + q_id
				+ "&q_content=" + q_content);
	}

	@RequestMapping(value = "/deleteOption", method = RequestMethod.GET)
	public ModelAndView deleteOption(HttpServletRequest request) {
		int optionId = Integer.parseInt(request.getParameter("id"));
		optionService.deleteOptionById(optionId);
		return new ModelAndView("redirect:/QuizManage/OptionList?s_id=" + s_id + "&s_name=" + s_name + "&q_id=" + q_id
				+ "&q_content=" + q_content);
	}

	@RequestMapping(value = "/editOption", method = RequestMethod.GET)
	public ModelAndView editOption(HttpServletRequest request) {
		int optionId = Integer.parseInt(request.getParameter("id"));
		Options option = optionService.getOption(optionId);
		ModelAndView model = new ModelAndView("QuizForm");
		model.addObject("option", option);
		model.addObject("type", "Option");
		model.addObject("s_name", s_name);
		model.addObject("q_content", q_content);
		model.addObject("operation", "Edit Option");
		return model;
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public ModelAndView Cancel(HttpServletRequest request) {
		String type = request.getParameter("type");
		String url = "";
		if (type.equals("Subject")) {
			url = "redirect:/QuizManage/SubjectList";
		} else if (type.equals("Question")) {
			url = "redirect:/QuizManage/QuestionList?s_id=" + s_id + "&s_name=" + s_name;
		} else if (type.equals("Option")) {
			url = "redirect:/QuizManage/OptionList?s_id=" + s_id + "&s_name=" + s_name + "&q_id=" + q_id + "&q_content="
					+ q_content;
		}
		return new ModelAndView(url);
	}

}