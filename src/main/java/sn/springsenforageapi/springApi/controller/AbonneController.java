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


import sn.springsenforageapi.springApi.entities.Abonne;
import sn.springsenforageapi.springApi.repositories.AbonneRepository;

@RestController
public class AbonneController {
	
	@Autowired
	private AbonneRepository abonneRepository;
	
	@PostMapping("/api/Abonne/add")
	public Abonne addAbonne(@RequestBody Abonne abonne) {
		return abonneRepository.save(abonne);
	}
	

	
	@PutMapping("/api/Abonne/update/{id}")
	public String editAbonne(@PathVariable int id, @RequestBody Abonne abonne) {

		Abonne v = abonneRepository.findById(id).get();
		
		if(v!=null) {
			abonneRepository.saveAndFlush(abonne);
			return "modification reussi";
		} else {

			return "Cet abonne n'existe pas dans la base de données";
		}
	}
	
	
	@GetMapping("/api/Abonne/liste")
	public List<Abonne> listeAbonne(){
		return abonneRepository.findAll();
	}
	
	@DeleteMapping("/api/Abonne/delete/{id}")
	public String deleteAbonne(@PathVariable int id) {
		
		Abonne v = abonneRepository.findById(id).get();
		
		if(v!=null) {
			abonneRepository.delete(v);
			return "Suppression reussi";
		} else {

			return "Cet Abonne n'existe pas dans la base de données";
		}
	}
	

}
