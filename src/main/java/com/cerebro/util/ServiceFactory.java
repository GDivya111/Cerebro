package com.cerebro.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cerebro.model.ApacheKafkaDefinition;
import com.cerebro.model.CoreJavaDefinition;
import com.cerebro.model.Definition;
import com.cerebro.model.GroovyDefinition;
import com.cerebro.repository.ApacheKafkaDefinitionRepository;
import com.cerebro.repository.CoreJavaDefinitionJpaRepository;
import com.cerebro.repository.GroovyDefinitionRepository;

/**
 * Factory class to get service based definition type
 * @author Avinash Babu Donthu - 19 Feb 2017
 *
 */
@Component(value = "serviceFactory")
public class ServiceFactory {

    @Autowired
    @Qualifier("coreJavaDefinitionRepository")
    private CoreJavaDefinitionJpaRepository coreJavaDefinitionJpaRepository;

    @Autowired
    @Qualifier("apacheKafkaDefinitionRepository")
    private ApacheKafkaDefinitionRepository apacheKafkaDefinitionRepository;

    @Autowired
    @Qualifier("groovyDefinitionRepository")
    private GroovyDefinitionRepository groovyDefinitionRepository;

    private Map<String, Object> entityRepositoryMap = new HashMap<>();

    public Map<String, Object> getDomainAndRepository(String definitionType, Definition definition) {
	switch (definitionType) {
	case Constants.CORE_JAVA:
	    entityRepositoryMap.put(Constants.REPOSITORY, coreJavaDefinitionJpaRepository);
	    if (null != definition) {
		CoreJavaDefinition coreJavaDefinition = new CoreJavaDefinition();
		BeanUtils.copyProperties(definition, coreJavaDefinition);
		entityRepositoryMap.put(Constants.ENTITY, coreJavaDefinition);
	    }
	    break;
	case Constants.APACHE_KAFKA:
	    entityRepositoryMap.put(Constants.REPOSITORY, apacheKafkaDefinitionRepository);
	    if (null != definition) {
		ApacheKafkaDefinition apacheKafkaDefinition = new ApacheKafkaDefinition();
		BeanUtils.copyProperties(definition, apacheKafkaDefinition);
		entityRepositoryMap.put(Constants.ENTITY, apacheKafkaDefinition);
	    }
	    break;
	case Constants.GROOVY:
	    entityRepositoryMap.put(Constants.REPOSITORY, groovyDefinitionRepository);
	    if (null != definition) {
		GroovyDefinition groovyDefinition = new GroovyDefinition();
		BeanUtils.copyProperties(definition, groovyDefinition);
		entityRepositoryMap.put(Constants.ENTITY, groovyDefinition);
	    }
	    break;
	}

	return entityRepositoryMap;
    }

    public List<Definition> getDefinitions(List<Object> definitions) {
	List<Definition> defs = definitions.stream().map(def -> {
	    Definition definition = new Definition();
	    BeanUtils.copyProperties(def, definition);
	    return definition;
	}).collect(Collectors.toList());

	return defs;
    }
}