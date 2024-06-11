package com.msantos.contentmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.msantos.contentmanager.entities.PageTemplate;

@Repository
public interface PagesRepository extends JpaRepository<PageTemplate, Long> {

    @Query("SELECT page FROM PageTemplate page WHERE UPPER(page.namePage) LIKE UPPER(:namePage)")
    PageTemplate findPage(String namePage);

}