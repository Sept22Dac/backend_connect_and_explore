package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

}
