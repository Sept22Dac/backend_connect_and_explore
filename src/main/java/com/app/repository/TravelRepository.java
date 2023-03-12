package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long>{

}
