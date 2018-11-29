package com.practice.demo.jpa.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.demo.jpa.entity.Contact;

@Repository
@Transactional
public interface ContactRepository extends JpaRepository<Contact, Long> {

	@Query("SELECT con FROM Contact con  WHERE con.lastName= (:lName)")
	List<Contact> findByLastName(@Param("lName") String lName);

}