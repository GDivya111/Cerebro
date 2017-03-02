package com.cerebro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cerebro.model.Definition;
import com.cerebro.service.CerebroService;
import com.cerebro.util.Constants;
import com.cerebro.util.ServiceFactory;

@SuppressWarnings({ "unchecked" })
@Service("cerebroServiceImpl")
public class CerebroServiceImpl implements CerebroService {

    @Autowired
    @Qualifier("serviceFactory")
    private ServiceFactory serviceFactory;

    @Override
    public List<Definition> getDefinitions(String definitionType) {
	Map<String, Object> map = serviceFactory.getDomainAndRepository(definitionType, null);
	JpaRepository<Object, Long> repository = (JpaRepository<Object, Long>) map.get(Constants.REPOSITORY);

	List<Definition> definitionsList = new ArrayList<>();
	if (null != repository) {
	    List<Object> definitionsFromDB = repository.findAll();
	    definitionsList = serviceFactory.getDefinitions(definitionsFromDB);
	}

	return definitionsList;
    }

    @Override
    public void saveDefinition(Definition definition, String definitionType) {
	Map<String, Object> map = serviceFactory.getDomainAndRepository(definitionType, definition);
	JpaRepository<Object, Long> repository = (JpaRepository<Object, Long>) map.get(Constants.REPOSITORY);
	Object object = map.get(Constants.ENTITY);
	repository.save(object);
    }

    @Override
    public void saveDefinitions(List<Definition> definitions, String definitionType) {
	for (Definition definition : definitions) {
	    Map<String, Object> map = serviceFactory.getDomainAndRepository(definitionType, definition);
	    JpaRepository<Object, Long> repository = (JpaRepository<Object, Long>) map.get(Constants.REPOSITORY);
	    Object object = map.get(Constants.ENTITY);
	    repository.save(object);
	}

    }

}
