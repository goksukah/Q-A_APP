package unex.java.spring.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String pswd;
	
	public User() {}
	
	public User(String name, String pswd) {
		super();
		this.name = name;
		this.pswd = pswd;
	}

}
