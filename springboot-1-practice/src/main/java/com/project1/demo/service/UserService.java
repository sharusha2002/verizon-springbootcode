package com.project1.demo.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.project1.demo.dto.User;

@Service
public class UserService {

	ArrayList<User> listOfUsers = new ArrayList<>(
			Arrays.asList(new User(1, "Sharusha", "Chennai"), new User(2, "Meha", "Coimbatore"),
					new User(3, "Sandhiya", "Thiuvannamalai")));

	public ArrayList<User> getAllUsers() {
		return listOfUsers;
	}

	public User getUserById(Integer userid) {
		User user = listOfUsers.stream().filter(ref -> ref.userid().equals(userid)).findFirst().get();
		return user;
	}

	public void addNewUser(User user) {
		listOfUsers.add(user);
	}

	public void updateUser(Integer userid, User user) {
		listOfUsers.set(
				listOfUsers.indexOf(listOfUsers.stream().filter(ref -> ref.userid().equals(userid)).findFirst().get()),
				user);
	}

	public void deleteUser(Integer userid) {
		listOfUsers.remove(listOfUsers.stream().filter(ref -> ref.userid().equals(userid)).findFirst().get());
	}
}
