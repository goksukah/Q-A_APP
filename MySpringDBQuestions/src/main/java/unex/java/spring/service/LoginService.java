package unex.java.spring.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unex.java.spring.model.User;
import unex.java.spring.repo.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
	
	public void register(String name, String pswd) {
		repo.save(new User(name, pswd));
	}
	public boolean duplicateUser(String name) {
	Boolean flag=false;	
	List<User> duplicates = repo.findByName(name);
	if(duplicates.size() >= 1 ) 
	{
	 flag=true;
		}
	return flag;
	}
	
	public boolean checkCredentials(String name, String pswd) {
		
			List<User> userList =repo.findByName(name);
			if(userList.get(0).getName().equals(name) && userList.get(0).getPswd().equals(pswd)) {
				return true;
			}
		
		return false;
	}
	
}
