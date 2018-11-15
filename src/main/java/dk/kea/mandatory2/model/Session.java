package dk.kea.mandatory2.model;

public class Session {
	private String username;
	private String password;
	private boolean isLoggedIn;

	public Session() {
	}

	public Session(String username, String password, boolean isLoggedIn) {
		this.username = username;
		this.password = password;
		this.isLoggedIn = isLoggedIn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		isLoggedIn = loggedIn;
	}
}
