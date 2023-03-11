package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Sports;

public interface SportsRepository extends JpaRepository<Sports, Long> {

}
