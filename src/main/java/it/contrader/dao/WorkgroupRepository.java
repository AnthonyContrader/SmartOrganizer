package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Workgroup;
@Repository
@Transactional
public interface WorkgroupRepository extends CrudRepository<Workgroup, Long>{

}
