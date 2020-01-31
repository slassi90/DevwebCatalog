package org.sid.dao;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.sid.CatMvcApplication;
import org.sid.Entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
@Query("select p from Produit p where p.designation like :x")
public Page<Produit>chercher(@Param("x")String mc,Pageable pageable);
}
