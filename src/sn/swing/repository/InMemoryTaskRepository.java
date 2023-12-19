package sn.swing.repository;

import java.util.ArrayList;
import java.util.List;

import sn.swing.entities.Task;
import sn.swing.exceptions.RepositoryException;

public class InMemoryTaskRepository implements ITaskRepository {
	
	private List<Task> tasks;
	
	public InMemoryTaskRepository() {
		tasks = new ArrayList<>();
	}
	@Override
	public void create(Task entity) throws RepositoryException {
		if (entity.getReference() == -1 ) {
			entity.setReference(tasks.size() + 1 );
		}
		
		tasks.add(entity);

	}

	@Override
	public List<Task> list() throws RepositoryException {
		return tasks;
	}

	@Override
	public Task read(int id) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Task entity) throws RepositoryException {
		if(tasks.contains(entity)) {
			int index = tasks.indexOf(entity);
			tasks.remove(index);
			tasks.add(index, entity);
		}

	}

	@Override
	public void delete(int id) throws RepositoryException {
		// TODO Auto-generated method stub

	}

}
