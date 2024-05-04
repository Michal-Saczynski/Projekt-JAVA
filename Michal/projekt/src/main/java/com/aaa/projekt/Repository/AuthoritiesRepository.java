package com.aaa.projekt.Repository;

import com.aaa.projekt.model.Authorities;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
    @Query("SELECT DISTINCT a FROM Authorities a")
    List<Authorities> findAllUsers(PageRequest pageRequest);
}