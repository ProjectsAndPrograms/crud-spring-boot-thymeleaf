package com.crudapp.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crudapp.entity.User;
import com.crudapp.service.UserService;

@Controller("/")
public class UserController {

	private UserService userService;
	private String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String getUsersList(@RequestParam(defaultValue="1") Integer pageNo,
							   @RequestParam(defaultValue="5") Integer pageSize,
		
								Model model) {
		model.addAttribute("users", userService.getUsersByPagination(pageNo, pageSize));
		model.addAttribute("totalPages",((int)(userService.getUsersCount()/pageSize)) + 1);
		model.addAttribute("currentPage", pageNo);
		
		return "users";
	}
	
	@GetMapping("/new")
	public String createNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "create-new-user";
	}
	
	@PostMapping("/users")
	public String saveUser(@RequestParam("name") String name,
						   @RequestParam("dob") Date dob,
						   @RequestParam("email") String email,
						   @RequestParam("password") String password,
						   @RequestParam("image") MultipartFile image,
						   RedirectAttributes redirectAttributes,
						   Model model						   
	) throws IOException { 
	
		String encryptedPassword = userService.encryptPassword(password);
		String uploadedImage = userService.uploadImage(image);
		
		User user = new User(name, dob, email, encryptedPassword, uploadedImage);
		userService.saveUser(user);
		
		redirectAttributes.addFlashAttribute("flashMessage", "User created successfully!");
		return "redirect:/";
		
	}
	
	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "update-user";
	}
	
	@PostMapping("/users/{id}")
	public String saveUpdatedUser(
								  @PathVariable("id") Long id,
								  @RequestParam("name") String name,
								  @RequestParam("dob") Date dob,
								  @RequestParam("email") String email,
								  @RequestParam("password") String password,
								  @RequestParam("image") MultipartFile image,
								  @RequestParam("oldImage") String oldImageName,
								  Model model,
								  RedirectAttributes redirectAttributes								  
								 ) throws IOException 
	{
		
		User user = userService.getUserById(id);
		String encryptedPassword = "";
		if(password.equals(user.getPassword())) {
			encryptedPassword = password;
		}else {
			encryptedPassword = userService.encryptPassword(password);
		}
			
		String uploadedImage = userService.updateImage(oldImageName, image);	
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(encryptedPassword);
		user.setDob(dob);
		if(uploadedImage != null) {
			user.setImage(uploadedImage);	
		}
		
		userService.updateUser(user);
		
		redirectAttributes.addFlashAttribute("flashMessage","User updated successfully!");
		return "redirect:/";
	}
	
	
	@GetMapping("users/{id}")
	public String deleteUser(@PathVariable("id") Long id, 
							Model model,
							RedirectAttributes redirectAttributes) {
		userService.deleteUser(id);
		redirectAttributes.addFlashAttribute("flashMessage","User deleted successfully!");
		return "redirect:/";
	}
	
	@GetMapping("/uploads/{imageName}")
	public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
	        try {

	            Path imagePath = Paths.get(UPLOAD_DIR).resolve(imageName);
	            Resource resource = new UrlResource(imagePath.toUri());

	            if (resource.exists() && resource.isReadable()) {
	            	  MediaType mediaType = MediaTypeFactory.getMediaType(resource).orElse(MediaType.IMAGE_JPEG);
	                return ResponseEntity.ok()
	                        .contentType(mediaType) 
	                        .body(resource);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	
	
	
}
