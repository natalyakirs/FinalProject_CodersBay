package com.workhub.demo.repo;

import com.workhub.demo.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeadRepository extends JpaRepository<Lead,Integer> {
}
