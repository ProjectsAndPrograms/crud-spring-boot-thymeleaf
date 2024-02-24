package com.crudapp.entity;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name="users", uniqueConstraints={@UniqueConstraint(columnNames ={"email"})})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;	
	private Date dob;	
	private String email;	
	private String password;	
	private String image;

	public User() {}
	
	public User(String name, Date dob, String email, String password, String image) {
		super();
		
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getFormattedDob() {
		SimpleDateFormat d = new SimpleDateFormat("dd MMM yyyy");
		return d.format(dob);
	}
	public String getImageUrl() {
		
		if(image == null) {
			return "/images/user.png";
		}else {
			String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";				
			if(new File((UPLOAD_DIR + image.trim())).exists()) {
				 return "/uploads/" + image.trim();
			} 
			else {
				return"/images/user.png";
			}
		}
		
	
		
		
	}
	
}
