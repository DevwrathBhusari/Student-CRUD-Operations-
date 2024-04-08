package com.student1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.student1.entity.Student;
import com.student1.request.StudentRequest;
import com.student1.response.APIResponse;
import com.student1.response.GetAll;
import com.student1.response.GetResponse;
import com.student1.response.Response;

public interface StudentService {
	
	public Response saveStudent(StudentRequest studentRequest);
    public GetResponse  getStudent( int rollno ) ;
	public APIResponse updateStudent(StudentRequest studentRequest) ;
	public APIResponse deleteStudent( int rollno);
	public List< GetAll>  getallStudent();
	
}
