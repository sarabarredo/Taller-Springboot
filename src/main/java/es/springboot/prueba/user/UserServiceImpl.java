package es.springboot.prueba.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Long id) {
		User usuario = userRepository.findUserById(id);
		return usuario;
	}
	
	@Override
	public User save(User user) {
		User usuario = userRepository.save(new User(user.getId(), user.getName(), user.getBirthDate()));
		return usuario;
	}
	
	@Override
	public User delete(Long id) {
		User usuario = userRepository.findUserById(id);
		userRepository.deleteById(id);
		
		if (usuario != null) {
			userRepository.deleteById(id);
			return usuario;
		} else {
			return null;
		}
	}
	
	@Override
	public User update(User user) {
		User usuario = userRepository.findUserById(user.getId());
	
		if (usuario != null) {
			User updatedUser = userRepository.save(user);
			return updatedUser;
		} else {
			return null;
		}
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

