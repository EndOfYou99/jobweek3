package hangman.businessLogic;

import jakarta.validation.constraints.NotBlank;

public class User {

	private String username;

	private String password;

	public User() {

	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	@NotBlank(message = "You must fill this field")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@NotBlank(message = "You must fill this field")
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
