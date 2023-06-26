package cz.itnetwork.spring.data.repositories;

import cz.itnetwork.spring.data.entities.InsuredEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * interface for working with the database
 */
public interface InsuredRepository extends CrudRepository<InsuredEntity, Long> {
}
