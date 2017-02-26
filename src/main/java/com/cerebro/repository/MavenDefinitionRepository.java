package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerebro.model.MavenDefinition;

@Repository("mavenDefinitionRepository")
public interface MavenDefinitionRepository extends JpaRepository<MavenDefinition, Long> {

}
