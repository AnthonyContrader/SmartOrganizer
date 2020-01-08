package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Location;


@Repository
@Transactional
public interface LocationRepository extends CrudRepository<Location, Long> {

	

}
