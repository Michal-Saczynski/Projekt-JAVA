package com.aaa.projekt.Repository;

import com.aaa.projekt.model.Uzytkownicy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UzytkownicyRepository extends JpaRepository<Uzytkownicy,Long> {
    @Query("SELECT DISTINCT u FROM Uzytkownicy u")
    List<Uzytkownicy> findAllUzytkownicy(PageRequest pageRequest);

    Uzytkownicy findByEmail(String email);
}