package it.contrader.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Employees;

@Repository
@Transactional
public interface EmployeesRepository extends CrudRepository<Employees, Long> {


}
