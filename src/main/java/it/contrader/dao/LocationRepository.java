package it.contrader.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Location;
import it.contrader.model.User;

@Repository
@Transactional
public interface LocationRepository extends CrudRepository<Location, Long>{

	Location findById(long id);
}
