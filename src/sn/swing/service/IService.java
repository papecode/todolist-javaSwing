package sn.swing.service; // Alt + Shift + J pour générer la documentation

import javax.swing.table.TableModel;

import sn.swing.entities.Task;

public interface IService {
	/**
	 * @param login
	 * @param password
	 * @return
	 */
	boolean authentificate (String login, String password);

	/**
	 * @param task
	 * @throws CrudOperationExeception 
	 */
	void addtask(Task task) throws CrudOperationExeception;

	/**
	 * @return
	 */
	TableModel getModel();

	/**
	 * @return
	 */
	int getAllTaskSize();

	void modifytask(Task task) throws CrudOperationExeception;
}