package sn.springsenforageapi.springApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.springsenforageapi.springApi.entities.Village;
import sn.springsenforageapi.springApi.entities.Abonne;
import sn.springsenforageapi.springApi.entities.User;
import java.util.List;

public interface VillageRepository extends JpaRepository<Village, Integer> {
	
	@Query("Select a From Abonne a Join a.village v WHERE v.id=:id")
	public List<Abonne> listeAbonneVillage(@Param("id") int id);

	@Query("Select a From User a Join a.village v WHERE v.id=:id")
	public List<User> listeUserVillage(@Param("id") int id);

}

