package org.vtech.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vtech.entity.Admins;

@Repository
public interface AdminRepository extends CrudRepository<Admins, Integer> {

	Optional<Admins> findByNameAndPassword(String name, String password);
	
	Optional<Admins> findByName(String name);
}
