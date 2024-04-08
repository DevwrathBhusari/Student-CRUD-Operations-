 package com.student1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student1.StudentServiceImplementation.StudentServiceImplementation;
import com.student1.entity.Student;
import com.student1.request.StudentRequest;
import com.student1.response.APIResponse;
import com.student1.response.GetAll;
import com.student1.response.GetResponse;
import com.student1.response.Response;
import com.student1.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentServiceImplementation;

	
	@PostMapping("/add")
public  ResponseEntity<?>	addstudent(@RequestBody StudentRequest studentrequest ){
		
	      Response apiResponse=	studentServiceImplementation.saveStudent(studentrequest);
		return new ResponseEntity<Response>(apiResponse,HttpStatus.OK);
	}
	@GetMapping("/retrieve/{rollno}")
	public  ResponseEntity<?>	retrievestudent(@PathVariable  int rollno ){
			
		GetResponse response=	studentServiceImplementation.getStudent(rollno);
			return new ResponseEntity<GetResponse>(response,HttpStatus.OK);
		}
	@PutMapping("/update")
	public  ResponseEntity<?>	updatestudent(@RequestBody StudentRequest studentrequest ){
			
		      APIResponse apiResponse=	studentServiceImplementation.updateStudent(studentrequest);
			return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.OK);
		}
	@DeleteMapping("/delete/{rollno}")
	public  ResponseEntity<?>	deletestudent(@PathVariable  int rollno ){
			
		APIResponse apiResponse=	studentServiceImplementation.deleteStudent(rollno);
			return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.OK);
		}
	
	@GetMapping("/retrieveAll")
	public  List<GetAll>	retrieveAllstudent(){
			
		List<GetAll> getAll=	studentServiceImplementation.getallStudent();
			return getAll;

		}
	
	
}
