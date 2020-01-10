package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.contrader.model.Calendar;
import it.contrader.model.Employees;

@Repository
@Transactional
public interface CalendarRepository extends CrudRepository<Calendar, Long> {
	
	List<Calendar> findAllByEmployee(Employees employee);
	
}
