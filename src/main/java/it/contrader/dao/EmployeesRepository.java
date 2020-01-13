package it.contrader.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Employees;
import it.contrader.model.Workgroup;

@Repository
@Transactional
public interface EmployeesRepository extends CrudRepository<Employees, Long> {

	Employees findById(long idemployee);
	
	List<Employees> findAllByWorkgroup(Workgroup workgroup);

}
