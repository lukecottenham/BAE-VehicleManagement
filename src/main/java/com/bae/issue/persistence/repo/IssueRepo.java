package com.bae.issue.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.issue.persistence.domain.Issue;

@Repository
public interface IssueRepo extends JpaRepository<Issue, Long>{

}
