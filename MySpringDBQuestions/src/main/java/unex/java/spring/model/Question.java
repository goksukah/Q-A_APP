package unex.java.spring.model;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Data
@Entity
public class Question implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String question;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="questionIDs")
	private List<Answer> answers;

	
	
	public Question(String question) {
		super();
		this.question = question;
	}
	
	public Question() {
		super();

	}
	
	public void addAnswer(Answer a) {
		this.answers.add(a);
	}


	@Override
	public String toString() {
		return  question;
	}
}
