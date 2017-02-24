package com.cerebro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cerebro.model.Definition;
import com.cerebro.service.CerebroService;

@RestController
public class CerebroController {

    @Autowired
    @Qualifier("cerebroServiceImpl")
    private CerebroService cerebroService;

    @RequestMapping(value = "/definitions/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Definition> getDefinitions(@PathVariable("type") String definitionType) {
	return cerebroService.getDefinitions(definitionType);
    }

    @RequestMapping(value = "/addDefinitions/{type}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addDefinitions(@RequestBody Definition definition, @PathVariable("type") String definitionType) {
	cerebroService.saveDefinition(definition, definitionType);
    }
}