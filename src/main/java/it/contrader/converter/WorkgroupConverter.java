package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.WorkgroupDTO;
import it.contrader.model.Workgroup;

public class WorkgroupConverter implements Converter<Workgroup, WorkgroupDTO>{

	@Override
	public WorkgroupDTO toDTO(Workgroup workgroup) {
		// TODO Auto-generated method stub
		WorkgroupDTO workgroupDTO = new WorkgroupDTO(workgroup.getIdworkgroup(), workgroup.getName(), workgroup.getMembers(), workgroup.getResponsible(), workgroup.getWork());
		return workgroupDTO;
	}

	@Override
	public Workgroup toEntity(WorkgroupDTO workgroupDTO) {
		
		// TODO Auto-generated method stub
		Workgroup workgroup = new Workgroup(workgroupDTO.getIdworkgroup(), workgroupDTO.getName(), workgroupDTO.getMembers(), workgroupDTO.getResponsible(), workgroupDTO.getWork());
		return workgroup;
	}

	@Override
	public List<WorkgroupDTO> toDTOList(List<Workgroup> workgroupList) {
		// TODO Auto-generated method stub
		List<WorkgroupDTO> workgroupDTOlist = new ArrayList<WorkgroupDTO>();
		
		for(Workgroup workgroup : workgroupList) {
			workgroupDTOlist.add(toDTO(workgroup));
		}
		return workgroupDTOlist;
	}

	

}
