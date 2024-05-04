package com.aaa.projekt.Repository;

import com.aaa.projekt.model.Zlecenie;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZlecenieRepository extends JpaRepository<Zlecenie, Long> {
    @Query(value = "SELECT * FROM zlecenie WHERE id_user = :id_user", nativeQuery = true)
    List<Zlecenie> findAllZleceniaByUserId(@Param("id_user") Long id_user, PageRequest pageable);

}

