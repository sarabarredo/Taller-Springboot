package es.springboot.prueba.user;

import java.util.List;

public interface UserService {
	
	public List<User> getAllUsers();
	public List<User> findAll();
	public User findById(Long id);
	public User update(User user);
	public User save(User user);
	public User delete(Long id);
	
}
