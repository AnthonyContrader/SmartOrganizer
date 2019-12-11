package it.contrader.service;

import java.util.List;

import it.contrader.converter.ToolConverter;
import it.contrader.dao.ToolDAO;
import it.contrader.dto.ToolDTO;

public class ToolService {
	
	private ToolDAO toolDAO;
	private ToolConverter toolConverter;
	
	public ToolService() {
		this.toolDAO = new ToolDAO();
		this.toolConverter = new ToolConverter();
	}
	
	public List<ToolDTO> getAll(){
		return toolConverter.toDTOList(toolDAO.getAll());
	}
	
	public ToolDTO read(int idtools) {
		return toolConverter.toDTO(toolDAO.read(idtools));
	}
	
	public boolean insert(ToolDTO dto) {
		return toolDAO.insert(toolConverter.toEntity(dto));
	}
	
	public boolean update(ToolDTO dto) {
		return toolDAO.update(toolConverter.toEntity(dto));
	}
	
	public boolean delete(int idtools) {
		return toolDAO.delete(idtools);
	}
	
}
