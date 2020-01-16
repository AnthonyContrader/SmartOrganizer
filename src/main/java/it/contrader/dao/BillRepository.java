package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Bill;

@Repository
@Transactional
public interface BillRepository extends CrudRepository<Bill, Long> {


}