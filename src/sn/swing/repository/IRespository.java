package sn.swing.repository;
import java.util.List;

import sn.swing.exceptions.RepositoryException;

public interface IRespository<T> {
	/**
	 * @param entity
	 * @throws RepositoryException
	 */
	void create (T entity) throws RepositoryException;
	/**
	 * 
	 * @return
	 * @throws RepositoryException
	 */
		
	List<T> list() throws RepositoryException;
	/**
	 * @param id
	 * @return
	 * @throws RepositoryException
	 */
	T read (int id) throws  RepositoryException;
	void update (T entity) throws RepositoryException;
	/**
	 * @param id
	 * @throws RepositoryException
	 */
	void delete(int id) throws RepositoryException;
}
