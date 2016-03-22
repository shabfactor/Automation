package nz.co.maveros.auto.ghost.model.page;

public class LoginPage extends AbstractPage {

	private String email;

	private String password;

	public final static String LOGIN_URL = "/login";

	public LoginPage(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
