package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.contrader.model.Tool;

@Repository
@Transactional
public interface ToolRepository extends CrudRepository<Tool, Long> {

}
