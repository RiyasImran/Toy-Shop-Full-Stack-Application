package com.stockManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockManagement.model.Decoration;

@Repository
public interface DecorationRepository extends JpaRepository<Decoration,Integer> {

}
