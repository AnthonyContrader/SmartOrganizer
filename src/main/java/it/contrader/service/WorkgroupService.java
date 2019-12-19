package it.contrader.service;


import it.contrader.converter.WorkgroupConverter;
import it.contrader.dao.WorkgroupDAO;


import it.contrader.dto.WorkgroupDTO;
import it.contrader.model.Workgroup;



public class WorkgroupService extends AbstractService<Workgroup, WorkgroupDTO>{
	public WorkgroupService(){
		this.dao = new WorkgroupDAO();
		this.converter = new WorkgroupConverter();
	}
}
