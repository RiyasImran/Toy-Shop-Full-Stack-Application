package com.stockManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockManagement.model.Toys;

@Repository
public interface ToysRepository extends JpaRepository<Toys,Integer>{

}
