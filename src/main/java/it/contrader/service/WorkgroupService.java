package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import it.contrader.converter.WorkgroupConverter;

import it.contrader.dao.WorkgroupRepository;

import it.contrader.dto.WorkgroupDTO;

import it.contrader.model.Workgroup;


@Service
public class WorkgroupService extends AbstractService<Workgroup, WorkgroupDTO> {

	@Autowired
	private WorkgroupConverter converter;
	@Autowired
	private WorkgroupRepository repository;



}
