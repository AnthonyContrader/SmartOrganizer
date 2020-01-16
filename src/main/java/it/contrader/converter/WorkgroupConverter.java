package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.WorkgroupDTO;
import it.contrader.model.Workgroup;

@Component
public class WorkgroupConverter extends AbstractConverter<Workgroup,WorkgroupDTO>{

	@Override
	public Workgroup toEntity(WorkgroupDTO workgroupDTO) {
		// TODO Auto-generated method stub
		Workgroup workgroup=null;
		if(workgroupDTO!=null) {
			workgroup=new Workgroup(workgroupDTO.getId(), workgroupDTO.getName(), workgroupDTO.getResponsible(), workgroupDTO.getWork());
		}
		return workgroup;
	}



	@Override
	public WorkgroupDTO toDTO(Workgroup workgroup) {
		// TODO Auto-generated method stub
		WorkgroupDTO workgroupDTO=null;
		if(workgroup!=null) {
			workgroupDTO=new WorkgroupDTO(workgroup.getId(), workgroup.getName(), workgroup.getResponsible(), workgroup.getWork());
		}
		return workgroupDTO;
	}

}
