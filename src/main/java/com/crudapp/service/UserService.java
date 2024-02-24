package com.crudapp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.crudapp.entity.User;

public interface UserService {
	List<User> getAllUsers();
	
	List<User> getUsersByPagination(int pageNo, int pageSize);
	
	Integer getUsersCount();
	
	User getUserById(Long id);
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Long id);

	String uploadImage(MultipartFile image) throws IOException;
	
	String updateImage(String oldImageName, MultipartFile image) throws IOException;
	
	String encryptPassword(String password);
	
	
}
