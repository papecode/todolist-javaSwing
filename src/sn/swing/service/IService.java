package sn.swing.service; // Alt + Shift + J pour générer la documentation

public interface IService {
	/**
	 * @param login
	 * @param password
	 * @return
	 */
	boolean authentificate (String login, String password);
}
