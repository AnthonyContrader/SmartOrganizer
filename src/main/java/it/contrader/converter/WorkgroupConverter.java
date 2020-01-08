package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.WorkgroupDTO;
import it.contrader.model.Workgroup;

@Component
public class WorkgroupConverter extends AbstractConverter<Workgroup, WorkgroupDTO>{

	@Override
	public Workgroup toEntity(WorkgroupDTO workgroupDTO) {
		// TODO Auto-generated method stub
		Workgroup workgroup = null;
		if(workgroupDTO!= null) {
			workgroup = new Workgroup(workgroupDTO.getIdworkgroup(),workgroupDTO.getName(),workgroupDTO.getMembers(),workgroupDTO.getResponsible(),workgroupDTO.getWork());
		}
		return workgroup;
	}

	@Override
	public WorkgroupDTO toDTO(Workgroup workgroup) {
		WorkgroupDTO workgroupDTO =null;
		if(workgroup!=null)
		{
			workgroupDTO = new WorkgroupDTO(workgroup.getIdworkgroup(), workgroup.getName(), workgroup.getMembers(), workgroup.getResponsible(), workgroup.getWork());
		}
		return workgroupDTO;
				
		
		// TODO Auto-generated method stub

	}

}
