package com.cerebro.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/uploadDefinitions/{sheetName}/{definitionType}/{fileName}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String uploadDefinitions(@PathVariable("sheetName") String sheetName, @PathVariable("definitionType") String definitionType,
	    @PathVariable("fileName") String fileName) {
	String status = "upload success";
	URL url = getClass().getClassLoader().getResource(fileName + ".xlsx");
	File file = new File(url.getPath());
	System.out.println("path: " + file.getAbsolutePath());

	List<Definition> definitions = new ArrayList<>();
	Row row = null;
	Cell cell0 = null;
	Cell cell1 = null;
	Definition definition = null;
	// create workbook instance which will hold xlsx file
	try (InputStream inputStream = new FileInputStream(file); XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream)) {
	    // get sheet based on path variable
	    XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);

	    //get iterator of rows
	    Iterator<Row> rows = sheet.iterator();

	    while (rows.hasNext()) {
		row = rows.next();
		definition = new Definition();

		cell0 = row.getCell(0);
		cell1 = row.getCell(1);

		if (null == cell0 || null == cell1) {
		    break;
		}

		String cell1String = cell1.getStringCellValue();
		if (cell1String.startsWith("http")) {
		    cell1String = "<a href='" + cell1String + "' target='_blank'>" + cell1String + "</a>";
		}

		definition.setDescription(cell0.getStringCellValue());
		definition.setDetails(cell1String);

		definitions.add(definition);
	    }

	    cerebroService.saveDefinitions(definitions, definitionType);

	} catch (IOException e) {
	    status = "upload failed";
	    e.printStackTrace();
	}
	return status;
    }
}