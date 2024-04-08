package com.student1.StudentServiceImplementation;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.student1.dao.StudentDao;
import com.student1.entity.Student;
import com.student1.request.StudentRequest;
import com.student1.response.APIResponse;
import com.student1.response.DuplicateResponse;
import com.student1.response.GetAll;
import com.student1.response.GetResponse;
import com.student1.response.Response;
import com.student1.service.StudentService;

import antlr.collections.List;

@Service
@Component
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentDao repo;
	
	
	@Override
	public Response saveStudent(StudentRequest studentRequest) {
		java.util.List<Student> students=repo.findAll();
		for(int i=0;i<=students.size()-1;i++) {
		if((studentRequest.getName()).equals(students.get(i).getName())) {
			return new DuplicateResponse("This name already exists", "use another name");
		}
		}
		Student student = new Student();
		student.setName(studentRequest.getName());
		student.setRollno(studentRequest.getRollno());		
		student.setMarks(studentRequest.getMarks());
		
		repo.save(student);
		return new APIResponse("Success", "data saved..");
	}


	@Override
	public GetResponse getStudent( int rollno) {
		Student student = repo.findById(rollno).get();
		
		GetResponse getresponse=new GetResponse();
		getresponse.setRollno(student.getRollno());
		getresponse.setName(student.getName());
		getresponse.setMarks(student.getMarks());
		
		return new GetResponse(getresponse.getRollno(), getresponse.getName(), getresponse.getMarks());
	}
	

	@Override
	public APIResponse updateStudent(StudentRequest studentRequest) {
		
		Student student=repo.findById(studentRequest.getRollno()).get();
		
		student.setRollno(studentRequest.getRollno());
		student.setName(studentRequest.getName());
		if(studentRequest.getMarks()==0) {
		
			repo.save(student);
		}
		else {
			student.setMarks(studentRequest.getMarks());
			repo.save(student);
		} 
		
		return new APIResponse("Success", "data saved..");
	}
	
	@Override
	public APIResponse deleteStudent( int rollno) {
		 repo.deleteById(rollno);	
		return new APIResponse("Rollno deleted","Success...");
	}


	@Override
	public java.util.List<GetAll> getallStudent() {

	java.util.List<Student> students=repo.findAll();
	
	java.util.List<GetAll> getAlls=new ArrayList<>();
	
	for (Student student : students) {
		GetAll getAll=new GetAll();
		
		getAll.setMarks(student.getMarks());
		getAll.setRollno(student.getRollno());
		getAll.setName(student.getName());
		
		getAlls.add(getAll);
		}

		
		
		return getAlls;
	}
	

	
	
	
	
	
	
	
	
	

}
