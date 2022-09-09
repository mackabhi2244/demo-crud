package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class DemoCrudApplicationTests {
	@Autowired
	private StudentRepository studentRepo;

	@Test
	void saveOneStudent() {
		Student s1 = new Student();
		s1.setName("Stallin");
		s1.setCourse("Development");
		s1.setFee(10000);
		studentRepo.save(s1);
	}

	@Test
	void deleteOneStudent() {
		studentRepo.deleteById(2L);
		;
	}

	@Test
	void getOneStudent() {
		Optional<Student> findById = studentRepo.findById(1L);
		if (findById.isPresent()) {
			Student student = findById.get();
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());

		} else {
			System.out.println("No record found!!");
		}
	}

	@Test
	void updateOneStudent() {
		Optional<Student> findById = studentRepo.findById(1L);
		if (findById.isPresent()) {
			Student student = findById.get();
			student.setCourse("Testing");
			student.setFee(10000);
			studentRepo.save(student);
		}

	}
@Test
	void getAllStudents() {
		Iterable<Student> findAll = studentRepo.findAll();
		for (Student student : findAll) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
			
		}

	}
@Test
void getAllStudentsusingLambdaExp() {
	Iterable<Student> findAll = studentRepo.findAll();
	findAll.forEach(e->System.out.println(e.getId()+" "+e.getName()+" "+e.getFee()+" "+e.getFee()));
}


}
