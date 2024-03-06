package com.aaa.projekt.Repository;

import com.aaa.projekt.model.Role;
import com.aaa.projekt.model.Uzytkownicy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT DISTINCT r FROM Role r")
    List<Role> findAllRole(PageRequest pageRequest);
}

