package com.app.util;
import java.io.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.app.controllers.FrontController;
import com.app.db.Entity.Course;
@Component
public class FileProcessor {
	private static final Logger logger = LoggerFactory
            .getLogger(FrontController.class);
	private MultipartFile file;
	private FileToCourseAdapter fileToCourseAdapter;
	public FileToCourseAdapter getFileToCourseAdapter() {
		return fileToCourseAdapter;
	}

	public FileProcessor(){
		//fileToCourseAdapter=new FileToCourseAdapter();
	}
	public void setFileToCourseAdapter(FileToCourseAdapter fileToCourseAdapter) {
		this.fileToCourseAdapter = fileToCourseAdapter;
	}

	
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public boolean process(){
		return processFile();
	}
	private boolean validateFile(){
		if(this.file.isEmpty()){
			return false;
		}
		return true;
	}
	private boolean processFile(){
		boolean status=false;
		
		if(!validateFile())
		return status;
			try{
			BufferedReader buffRead=new BufferedReader(new InputStreamReader(this.file.getInputStream(),"utf-8"));
			String str="";
			while((str=buffRead.readLine())!=null){
				fileToCourseAdapter.addCourse(str);
				
			}
			status=true;
		}catch(Exception exp){
			logger.error("Exception Occured"+exp.getMessage());
			exp.getStackTrace();
			return status;
		}
		return status;
	}
	public List<Course> getCourse(String course){
			return fileToCourseAdapter.getCourse(course);
	}
	public String getCount(){
		return fileToCourseAdapter.getCount();
	}
}
