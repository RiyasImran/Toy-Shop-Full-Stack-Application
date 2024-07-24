package com.stockManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockManagement.model.SignUp;

@Repository
public interface SignupRepository  extends JpaRepository<SignUp,Integer> {

}
