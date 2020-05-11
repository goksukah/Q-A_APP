package unex.java.spring.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Answer {
	

	@Id
	@GeneratedValue
	private Long id;
	
	private String answer;

	
	public Answer(String answer) {
		this.answer = answer;
	}

	public Answer() {
		super();
	}
	
	@Override
	public String toString() {
		return  answer;
	}



}


