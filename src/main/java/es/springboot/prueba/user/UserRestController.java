package es.springboot.prueba.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/")
public class UserRestController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	// Get all users
	
	@GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		
		List<User> lista = new ArrayList<User>();
		lista = userServiceImpl.getAllUsers();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	// Get user by ID
	
	@GetMapping(value = "users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
		User user = userServiceImpl.findById(id);
		
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	// Add new user
	
	@PostMapping(path = "users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> saveUser(@RequestBody User user){
		userServiceImpl.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	// Update user by id
	
	@PutMapping(path = "users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
		user.setId(id);
		User userUpdate = userServiceImpl.update(user);
		
		if (userUpdate != null) {
			return new ResponseEntity<User>(HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Delete user by id
	
	@DeleteMapping(path = "users/{id}") 
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
		User user = userServiceImpl.delete(id);
		
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

}
