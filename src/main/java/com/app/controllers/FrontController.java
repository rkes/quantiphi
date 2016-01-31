package com.app.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.app.db.Entity.Course;
import com.app.db.dao.CourseDaoImpl;
import com.app.util.FileProcessor;

import org.slf4j.*;

@Controller("/app")
public class FrontController {
	private static final Logger logger = LoggerFactory
            .getLogger(FrontController.class);
	
	@Autowired
	private FileProcessor fileProcessor;
	
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	public @ResponseBody String uploadData(
			@RequestParam("file") MultipartFile file){
		
		fileProcessor.setFile(file);
		
		if(fileProcessor.process()){
			return "File SuccessFully Uploaded";
		}
		else
			return "File did not got Uploaded";
	}
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public @ResponseBody List<Course> getData(
			@RequestParam("title") String courseName){
		
		//CourseDaoImpl cDaoImpl=new CourseDaoImpl();
		return fileProcessor.getCourse(courseName);
	}
	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	public @ResponseBody String getCount(){
		
		//CourseDaoImpl cDaoImpl=new CourseDaoImpl();
		return fileProcessor.getCount();
	}
}
