package sn.swing.service;

public class BusinessLayer implements IService {

	@Override
	public boolean authentificate(String login, String password) {
		if (login.equals("admin") && password.equals("passer")) {
			return true;
		}
		return false;
	}

}
