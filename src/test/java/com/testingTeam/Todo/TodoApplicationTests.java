package com.testingTeam.Todo;

import com.testingTeam.Todo.Entities.Course;
import com.testingTeam.Todo.Entities.Lecture;
import com.testingTeam.Todo.Repo.CourseRepo;
import com.testingTeam.Todo.Repo.LectureRepo;
import com.testingTeam.Todo.Repo.RoleRepo;
import com.testingTeam.Todo.Repo.UserRepo;
import com.testingTeam.Todo.Entities.Role;
import com.testingTeam.Todo.Entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TodoApplicationTests {

	@Autowired
	UserRepo userRepo;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	CourseRepo courseRepo;

	@Autowired
	LectureRepo lectureRepo;

	@Test
	void addUser() {
//		User user = new User();
//		user.setUsername("test123");
//		user.setEmail("test123@mail.ru");
//		user.setFirstName("testFirstName123");
//		user.setMiddleName("testMiddleName123");
//		user.setLastName("testLastName123");
//		user.setPassword("testPassword123");
//		user.setEnabled(true);

		User admin = new User();
		admin.setUsername("admin123");
		admin.setEmail("admin123@mail.ru");
		admin.setFirstName("AdminFirstName123");
		admin.setMiddleName("adminMiddleName123");
		admin.setLastName("adminLastName123");
		admin.setPassword("adminPassword123");
		admin.setEnabled(true);

		Role role = roleRepo.findById(1).get();
		System.out.println(role.getName());
		admin.setRoles(Arrays.asList(role));

		userRepo.save(admin);
	}

	@Test
	public void getUser(){
		User user = userRepo.findByUsername("test123");
		System.out.println("Username: " + user.getUsername());
	}

	@Test
	public void updateUser(){
		User user = userRepo.findByUsername("test123");
		user.setUsername("test123");
		user.setEmail("newUser@mail.ru");
		user.setFirstName("AdminFirstName");
		user.setMiddleName("adminMiddleName");
		user.setLastName("adminLastName");
		user.setPassword("adminPassword");
		user.setEnabled(true);

		userRepo.save(user);
	}

	@Test
	public void deleteUser(){
		User user = userRepo.findByUsername("test123");
		userRepo.delete(user);
	}

	@Test
	public void createCourse(){
		Course course = new Course();
		course.setName("Course-test");

		Lecture lecture = new Lecture();
		lecture.setName("Lecture1");
		lecture.setDescription("Description-1");

		Lecture lecture2 = new Lecture();
		lecture2.setName("Lecture2");
		lecture2.setDescription("Description-2");

		course.addLecture(lecture);
		course.addLecture(lecture2);

		courseRepo.save(course);
	}

	@Test
	public void getCourse(){
		Course course = courseRepo.findById(16L).get();
		System.out.println("Course-name: " + course.getName());
	}


	@Test
	public void updateCourse(){
		Course course = new Course();
		course.setName("Course-test123");

		courseRepo.save(course);
	}

	@Test
	public void deleteCourse() {
		Course course = courseRepo.findById(8L).get();
		courseRepo.delete(course);
	}

	@Test
	public void createLecture(){
		Course course = new Course();
		course.setName("Course-test");

		Lecture lecture = new Lecture();
		lecture.setCourse(course);
		lecture.setName("123");
		lecture.setDescription("123");

		courseRepo.save(course);
		lectureRepo.save(lecture);
	}

	@Test
	public void getLecture(){
		Lecture lecture = lectureRepo.findById(26L).get();
		Course course = courseRepo.findById(16L).get();
		System.out.println("Lecture-ID: " + lecture.getId());
		System.out.println("Lecture-Name: " + lecture.getName());
		System.out.println("Lecture-Description: " + lecture.getDescription());
		System.out.println("Lecture-CourseName: " + course.getName());
	}

	@Test
	public void updateLecture(){ //вопрос
		Course course = new Course();
		course.setName("Course-test123");

		Lecture lecture = new Lecture();
		lecture.setCourse(course);
		lecture.setName("123");
		lecture.setDescription("123");

		courseRepo.save(course);
		lectureRepo.save(lecture);
	}

	@Test
	public void deleteLecture(){
		Lecture lecture = lectureRepo.findById(25L).get();
		lectureRepo.delete(lecture);
	}

}
