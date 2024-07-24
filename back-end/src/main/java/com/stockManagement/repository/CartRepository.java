package com.stockManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockManagement.model.ViewCart;

@Repository
public interface CartRepository extends JpaRepository<ViewCart,Integer>{

}
