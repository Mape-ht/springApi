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


import sn.springsenforageapi.springApi.entities.Role;
import sn.springsenforageapi.springApi.repositories.RoleRepository;

@RestController
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/api/Role/add")
	public Role addRole(@RequestBody Role role) {
		return roleRepository.save(role);
	}
	

	
	@PutMapping("/api/Role/update/{id}")
	public String editRole(@PathVariable int id, @RequestBody Role role) {

		Role v = roleRepository.findById(id).get();
		
		if(v!=null) {
			roleRepository.saveAndFlush(role);
			return "modification reussi";
		} else {

			return "Ce Role n'existe pas dans la base de données";
		}
	}
	
	
	@GetMapping("/api/Role/liste")
	public List<Role> listeRole(){
		return roleRepository.findAll();
	}
	
	@DeleteMapping("/api/Role/delete/{id}")
	public String deleteRole(@PathVariable int id) {
		
		Role v = roleRepository.findById(id).get();
		
		if(v!=null) {
			roleRepository.delete(v);
			return "Suppression reussi";
		} else {

			return "Ce Role n'existe pas dans la base de données";
		}
	}
	

}
