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


import sn.springsenforageapi.springApi.entities.Village;
import sn.springsenforageapi.springApi.entities.User;
import sn.springsenforageapi.springApi.repositories.VillageRepository;

@RestController
public class VillageController {
	
	@Autowired
	private VillageRepository villageRepository;
	
	@PostMapping("/api/Village/add")
	public Village addVillage(@RequestBody Village village) {
		return villageRepository.save(village);
	}
	

	
	@PutMapping("/api/Village/update/{id}")
	public String editVillage(@PathVariable int id, @RequestBody Village village) {

		Village v = villageRepository.findById(id).get();
		
		if(v!=null) {
			village.setId(v.getId());
			villageRepository.saveAndFlush(village);
			return "modification reussi";
		} else {

			return "Ce Village n'existe pas dans la base de données";
		}
	}
	
	
	@GetMapping("/api/Village/liste")
	public List<Village> listeVillage(){
		return villageRepository.findAll();
	}
	
	@GetMapping("/api/Village/user/{id}")
	public List<User> listeUserVillage(@PathVariable int id){
		return villageRepository.listeUserVillage(id);
	}
	
	@DeleteMapping("/api/Village/delete/{id}")
	public String deleteVillage(@PathVariable int id) {
		
		Village v = villageRepository.findById(id).get();
		
		if(v!=null) {
			villageRepository.delete(v);
			return "Suppression reussi";
		} else {

			return "Ce Village n'existe pas dans la base de données";
		}
	}
	

}
