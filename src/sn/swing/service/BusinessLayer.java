package sn.swing.service;

import java.util.List;

import javax.swing.table.TableModel;

import sn.swing.entities.Task;
import sn.swing.exceptions.RepositoryException;
import sn.swing.models.TaskModel;
import sn.swing.repository.ITaskRepository;
import sn.swing.repository.InMemoryTaskRepository;

public class BusinessLayer implements IService {
	
	private ITaskRepository repository;
	private TaskModel model;
	
	public BusinessLayer() {
		repository = new InMemoryTaskRepository();
		model = new TaskModel();
	}

	@Override
	public boolean authentificate(String login, String password) {
		if (login.equals("admin") && password.equals("passer")) {
			return true;
		}
		return false;
	}

	@Override
	public void addtask(Task task) throws CrudOperationExeception {
		try {
			repository.create(task);
			// - 
			model.add(task);
		} catch (RepositoryException e) {
			throw new CrudOperationExeception("Error while adding task :" +e.getMessage()  ); 	
			}
		
	}

	@Override
	public TableModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public int getAllTaskSize() {
		return model.getRowCount();
	}

	@Override
	public void modifytask(Task task) throws CrudOperationExeception {
		try {
			repository.update(task);
			
			//- 
			List<Task> tasks = repository.list();
			model.LoadTasks(tasks);;
					
			
		} catch (RepositoryException e) {
			throw new CrudOperationExeception("Error while modifying task :" +e.getMessage()  ); 	
			}
		
	}

}
