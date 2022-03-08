package models;

import java.time.LocalDate;

public class User {

	private String name;
	private LocalDate birthDate;
	private long id;
	private String email;
	private long numberPhone;
	private Gender gender;

	public User(String name, LocalDate birthDate, long id, String email, long numberPhone, Gender gender) {
		this.name = name;
		this.birthDate = birthDate;
		this.id = id;
		this.email = email;
		this.numberPhone = numberPhone;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(long numberPhone) {
		this.numberPhone = numberPhone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
