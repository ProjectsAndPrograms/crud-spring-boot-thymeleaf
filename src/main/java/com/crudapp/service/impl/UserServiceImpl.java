package com.crudapp.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.crudapp.entity.User;
import com.crudapp.repository.UserRepository;
import com.crudapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	private String UPLOAD_DIR = System.getProperty("user.dir") 
								+ "/src/main/resources/static/uploads/";
	
	Path rootLocation = Paths.get(UPLOAD_DIR);
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public Integer getUsersCount() {
		return (int) userRepository.count();
	}


	@Override
	public List<User> getUsersByPagination(int pageNo, int pageSize) {
		
		PageRequest pageReq = PageRequest.of(pageNo-1, pageSize);
		Page<User> page = userRepository.findAll(pageReq);
		
		return page.getContent();
	}
	
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);		
	}

	@Override
	public String uploadImage(MultipartFile image) throws IOException {
		
		if(image != null && !image.isEmpty()) {
						
			String originalFilename = image.getOriginalFilename();
			String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
			String uniqueName = UUID.randomUUID().toString() + extension;
			
			Path path = Paths.get(UPLOAD_DIR + uniqueName);
			Files.write(path, image.getBytes());
			
			System.out.println("UPLOAD PATH : " + UPLOAD_DIR + uniqueName);
			return uniqueName;
		}		
		return null;
	}
	
	@Override
	public String encryptPassword(String password) {		
		 int strength = 10; 
		 BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(strength, new SecureRandom());
		 String encodedPassword = bCryptPasswordEncoder.encode(password);
		
		return encodedPassword;
	}
	
	@Override
	public String updateImage(String oldImageName, MultipartFile image) throws IOException {
		
		if(image != null && !image.isEmpty()) {
			File oldImage = new File(UPLOAD_DIR + oldImageName);
			if(oldImage.exists() && oldImage.isFile()) {
				oldImage.delete();
			}
		}
		return uploadImage(image);
	}


	

	
	

}
