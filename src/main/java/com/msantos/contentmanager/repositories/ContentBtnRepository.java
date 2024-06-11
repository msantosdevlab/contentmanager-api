package com.msantos.contentmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msantos.contentmanager.entities.components.ContentBtn;

@Repository
public interface ContentBtnRepository extends JpaRepository<ContentBtn, Long> {

}
