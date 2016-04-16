package com.mobile.app.controller.model.ui;

public class Dog {
	private String name;
	private String did;
	private String email;
	private String breed;
	private String description;
	private String photo;
	
	public Dog(){
		
	}

	public Dog(String name, String did, String email, String breed, String description, String photo) {
		super();
		this.name = name;
		this.did = did;
		this.email = email;
		this.breed = breed;
		this.description = description;
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", did=" + did + ", email=" + email + ", breed=" + breed + ", description="
				+ description + ", photo=" + photo + "]";
	}

}
