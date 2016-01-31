package com.app.util;

import java.util.List;

import javax.transaction.Transactional;

import com.app.db.Entity.Course;
import com.app.db.dao.CourseDaoImpl;

public class FileToCourseAdapter {
	CourseDaoImpl courseDao;
	public CourseDaoImpl getCourseDao() {
		return courseDao;
	}
	public void setCourseDao(CourseDaoImpl courseDao) {
		this.courseDao = courseDao;
	}


	@Transactional
	public  void addCourse(String line){

		Course course=new Course();
		String []words=line.split(",");
		String id=words[0].replaceAll("\"", "");
		course.setId(Integer.parseInt(id));
		course.setTitle(words[1]);
		course.setImage(words[2]);
		course.setUrl(words[3]);
		course.setPrice(words[4]);
		course.setType(words[5]);
		course.setCategory(words[6]);
		course.setRating(words[7]);
		course.setDescription(words[8]);
		
		courseDao.addEntry(course);
		
	}
	@Transactional
	public List<Course> getCourse(String type){
		return courseDao.getCourse(type);
	}
	
	@Transactional
	public String getCount(){
		return courseDao.getCount();
	}
}
