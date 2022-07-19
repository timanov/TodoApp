package com.testingTeam.Todo;

import com.testingTeam.Todo.Repo.RoleRepo;
import com.testingTeam.Todo.Repo.UserRepo;
import com.testingTeam.Todo.Entities.Role;
import com.testingTeam.Todo.Entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoApplicationTests {

	@Autowired
	UserRepo userRepo;

	@Autowired
	RoleRepo roleRepo;

	//@Test
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
		admin.setUsername("admin");
		admin.setEmail("admin@mail.ru");
		admin.setFirstName("AdminFirstName");
		admin.setMiddleName("adminMiddleName");
		admin.setLastName("adminLastName");
		admin.setPassword("adminPassword");
		admin.setEnabled(true);

		Role role = roleRepo.findById(1).get();
		System.out.println(role.getName());
		admin.addRole(role);

		//userRepo.save(admin);
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

}
