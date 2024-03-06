package com.aaa.projekt.Repository;

import com.aaa.projekt.model.Produkty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduktyRepository extends JpaRepository<Produkty,Long> {
    @Query("SELECT DISTINCT p FROM Produkty p")
    List<Produkty> findAllProdukty(PageRequest pageRequest);
}

