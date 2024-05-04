package com.aaa.projekt.Repository;

import com.aaa.projekt.model.Zamowienia;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZamowieniaRepository extends JpaRepository<Zamowienia,Long> {
    @Query("SELECT DISTINCT z FROM Zamowienia z")
    List<Zamowienia>findAllZamowienia(PageRequest pagesRequst);
}
