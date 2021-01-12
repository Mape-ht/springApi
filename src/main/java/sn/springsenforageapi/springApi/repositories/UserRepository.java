package sn.springsenforageapi.springApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.springsenforageapi.springApi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
