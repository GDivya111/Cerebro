package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerebro.model.JenkinsDefinition;

@Repository("jenkinsDefinitionRepository")
public interface JenkinsDefinitionRepository extends JpaRepository<JenkinsDefinition, Long> {

}
