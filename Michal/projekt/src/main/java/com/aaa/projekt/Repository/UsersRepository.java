package com.aaa.projekt.Repository;

import com.aaa.projekt.model.Users;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT DISTINCT u FROM Users u")
    List<Users> findAllUsers(PageRequest pageRequest);
    Users findByUsername(String username);
}