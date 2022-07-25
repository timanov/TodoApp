package com.testingTeam.Todo;

import com.testingTeam.Todo.Entities.*;
import com.testingTeam.Todo.Repo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
class TodoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRepo userRepo;

	@MockBean
	private RoleRepo roleRepo;

	@MockBean
	private CourseRepo courseRepo;

	@MockBean
	private LectureRepo lectureRepo;

	@MockBean
	private StatusRepo statusRepo;

	@MockBean
	private ListTodoRepo listTodoRepo;

	@Test()
	void addUser() {
//		User user = new User();
//		user.setName("test123");
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
		Course course = courseRepo.findById(16L).get();
		course.setName("Course-test123456");

		courseRepo.save(course);
	}

	@Test
	public void deleteCourse() {
		Course course = courseRepo.findById(8L).get();
		courseRepo.delete(course);
	}

	@Test
	public void createLecture(){
		Course course = courseRepo.findById(16L).get();

		Lecture lecture = new Lecture();
		lecture.setCourse(course);
		lecture.setName("123");
		lecture.setDescription("123");

		lectureRepo.save(lecture);
	}

	@Test
	public void getLecture(){
		Lecture lecture = lectureRepo.findById(29L).get();
		Course course = courseRepo.findById(16L).get();
		System.out.println("Lecture-ID: " + lecture.getId());
		System.out.println("Lecture-Name: " + lecture.getName());
		System.out.println("Lecture-Description: " + lecture.getDescription());
		System.out.println("Lecture-CourseName: " + course.getName());
	}

	@Test
	public void updateLecture(){
		Course course = courseRepo.findById(16L).get();

		Lecture lecture = lectureRepo.findById(28L).get();
		lecture.setCourse(course);
		lecture.setName("123456");
		lecture.setDescription("123456");

		lectureRepo.save(lecture);
	}

	@Test
	public void deleteLecture(){
		Lecture lecture = lectureRepo.findById(24L).get();
		lectureRepo.delete(lecture);
	}

	@Test
	public void getStatus(){
		ArrayList<Status> status = (ArrayList<Status>) statusRepo.findAll();
		status.forEach(s -> System.out.println(s.getName() + "\n" + s.getDescription() + "\n" + s.getRole()));
	}

	@Test
	public void createTodo(){
		Course course = courseRepo.findById(16L).get();
		Lecture lecture = lectureRepo.findById(29L).get();
		User user = userRepo.findByUsername("admin123");
		Status status = statusRepo.findById(1L).get();

		ListTodo listTodo = new ListTodo();
		listTodo.setName("test-username1");
		listTodo.setDescription("test-description1");
		listTodo.setUpdateDate("20-07-2022 16:00");
		listTodo.setVersion(1);
		listTodo.setCourse(course);
		listTodo.setLecture(lecture);
		listTodo.setUser(user);
		listTodo.setStatus(status);

		listTodoRepo.save(listTodo);
	}

	@Test
	public void getTodo(){
		ListTodo listTodo = listTodoRepo.findById(2).get();
		System.out.println("Todo-ID: " + listTodo.getId());
		System.out.println("Todo-Name: " + listTodo.getName());
		System.out.println("Todo-Description: " + listTodo.getDescription());
		System.out.println("Todo-updateDate: " + listTodo.getUpdateDate());
		System.out.println("Todo-version: " + listTodo.getVersion());
		System.out.println("Todo-attach: " + Arrays.toString(listTodo.getAttach()));

	}
	@Test
	public void updateTodo(){
		ListTodo listTodo = listTodoRepo.findById(2).get();
		listTodo.setName("test-username3");
		listTodoRepo.save(listTodo);
	}

	@Test
	public void deleteTodo(){
		ListTodo listTodo = listTodoRepo.findById(2).get();
		listTodoRepo.delete(listTodo);
	}

	@Test
	public void testTodo() {
		System.out.println("Тест пройден");
	}

}
