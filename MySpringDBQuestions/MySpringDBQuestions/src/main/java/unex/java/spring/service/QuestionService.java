package unex.java.spring.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import unex.java.spring.model.*;
import unex.java.spring.repo.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repo;
	
	public void addQuestion(Question q) {
		repo.save(q);
	}
	
	public Question getQuestion(Long id) throws ResponseStatusException{
		Optional<Question> m = repo.findById(id);
		if (m.isPresent()) {
			return m.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question " + id + " not found" );
		}
	}
	
	public List<Question>  getQuestionLists(){
		
		return repo.findAll();
	}
	
}
