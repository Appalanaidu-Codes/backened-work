package com.academy.customerManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//
import com.academy.customerManager.model.Member;


public interface Memberrepository extends JpaRepository <Member, Long >  {

}
