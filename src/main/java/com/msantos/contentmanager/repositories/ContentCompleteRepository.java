package com.msantos.contentmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msantos.contentmanager.entities.components.ContentComplete;

@Repository
public interface ContentCompleteRepository extends JpaRepository<ContentComplete, Long> {

}
