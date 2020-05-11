package unex.java.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unex.java.spring.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name);
}
