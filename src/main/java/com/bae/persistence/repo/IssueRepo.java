package com.bae.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Issue;

@Repository
public interface IssueRepo extends JpaRepository<Issue, Long>{

	Object findByIssueName(String test_NAME);

}
