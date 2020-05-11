package unex.java.spring.controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import unex.java.spring.model.*;
import unex.java.spring.service.*;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService service;

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/")
	public String view(Model model) {
		return "login";
	}
	@GetMapping("/login")
	public String getLogin(Model model) {
		return "login";
	}
	
	@PostMapping("/login")
	public String checkLogin(
			@RequestParam("name") String name,
			@RequestParam("pswd") String pswd,
			Model model) {
		if(loginService.checkCredentials(name, pswd)) {
			return "view";
		}
		//duplicateUser checks if the user already exists in the system
		if(loginService.duplicateUser(name)) {
			model.addAttribute("message", "Incorrect password!"); //test this error again
		} else {
			model.addAttribute("message", "Username does not exist! Please check your credentials.");
		}
		
		return "login";
	}

	@GetMapping("/displayQuestions")
	public String viewQuestions(Model model){
		model.addAttribute("questions", service.getQuestionLists());
		return "view";
	}
	
	@PostMapping("/displayQuestions")
	public String addQuestion(
			@RequestParam("question") String question, 
			@RequestParam("answer") String answer, 
			Model model) {
		if(question != null && question != "") {
			Question q = new Question(question);
			if(answer != null && answer != "") {
				List<Answer> answers = new ArrayList<Answer>();
				answers.add(new Answer(answer));
				q.setAnswers(answers);
			}
			service.addQuestion(q);
			model.addAttribute("questions", service.getQuestionLists());
		}
		return "view";
	}
	
	@GetMapping("/addQuestion")
	public String addNewQuestion() {
		return "addQuestion";
	}
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(
			@RequestParam("name") String name,
			@RequestParam("pswd") String pswd,
			Model model) {
		if(loginService.duplicateUser(name) || name.length() < 1) {
			model.addAttribute("message", "Please try a different username.");
			return "register";
		} else {
			loginService.register(name, pswd);
			model.addAttribute("message", "You have successfully registered!");
		}
		return "login";
	}
	@GetMapping("/addAnswer")
	public String viewAnswer(
			@RequestParam("id") String id, 
			Model model) {
		
		Question question = service.getQuestion(Long.parseLong(id));
		model.addAttribute("question", question);
		return "addAnswer";
	}
	
	@PostMapping("/addAnswer")
	public String addAnswerToQuestion(
			@RequestParam("id") String id,
			@RequestParam("answer") String answer,
			Model model) {
		
		Question question = service.getQuestion(Long.parseLong(id));
		if(answer !=null && answer !="") {
			question.addAnswer(new Answer(answer));
		}		
		service.addQuestion(question);
		model.addAttribute("questions", service.getQuestionLists());
		return "view";
	}
	
	
	
}
