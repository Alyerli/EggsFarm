package com.eggsfarm.cds.dao;

import com.eggsfarm.cds.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersDao extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
