package unex.java.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unex.java.spring.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{}

