package sn.springsenforageapi.springApi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


import sn.springsenforageapi.springApi.entities.User;
import sn.springsenforageapi.springApi.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/api/User/add")
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	

	
	@PutMapping("/api/User/update/{id}")
	public String editUser(@PathVariable int id, @RequestBody User user) {

		User v = userRepository.findById(id).get();
		
		if(v!=null) {
			userRepository.saveAndFlush(user);
			return "modification reussi";
		} else {

			return "Cet User n'existe pas dans la base de données";
		}
	}
	
	
	@GetMapping("/api/User/liste")
	public List<User> listeUser(){
		return userRepository.findAll();
	}
	
	@DeleteMapping("/api/User/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		
		User v = userRepository.findById(id).get();
		
		if(v!=null) {
			userRepository.delete(v);
			return "Suppression reussi";
		} else {

			return "Cet User n'existe pas dans la base de données";
		}
	}
	

}
