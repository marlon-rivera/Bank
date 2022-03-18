package models;

public class User {

	private String name;
	private String lastName;
	private String birthDate;
	private long id;
	private String email;
	private long numberPhone;
	private Gender gender;

	public User(String name, String lastName, String birthDate, long id, String email, long numberPhone,
			Gender gender) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.id = id;
		this.email = email;
		this.numberPhone = numberPhone;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
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

	@Override
	public String toString() {
		return name + " " + lastName;
	}
}
