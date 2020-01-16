package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Calendar;

@Repository
@Transactional
public interface CalendarRepository extends CrudRepository<Calendar, Long> {

}
