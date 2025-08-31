package com.spring_sec.SpringSec1.repository;

import com.spring_sec.SpringSec1.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
