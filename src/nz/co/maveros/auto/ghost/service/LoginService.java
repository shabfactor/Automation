package nz.co.maveros.auto.ghost.service;

import nz.co.maveros.auto.ghost.model.page.LoginPage;

public interface LoginService {
	
	void loadPage();
	
	LoginPage login(String email, String password);
	
	void logout();
}
