package com.vikas.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.demo.model.Alien;

public interface AlienRepoJPA extends JpaRepository<Alien, Integer>
{
			
}
