package com.bae.user.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.user.persistence.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
