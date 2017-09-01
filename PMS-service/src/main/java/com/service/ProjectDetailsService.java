package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.ProjectDetailsDTO;
import com.repo.ProjectDetailsRepo;

@Service
public class ProjectDetailsService {

	@Autowired
	private ProjectDetailsRepo pRepo;
	
	List<ProjectDetailsDTO> list;
	
	public String saveProjectDataService(ProjectDetailsDTO pDto) {
		System.out.println("Inside Project service");
		return pRepo.saveProjectDataRepo(pDto);
	}
	
	public List<ProjectDetailsDTO> getProjectService() {
		
		return pRepo.getProjectList();
	}
	
	public void deleteProject(int id) {
		List li=pRepo.getPro(id);
		ProjectDetailsDTO p=(ProjectDetailsDTO) li.get(0);
		pRepo.deletePro(p);
	}
	public ProjectDetailsDTO getProject(int id) {
		List li=pRepo.getPro(id);
		ProjectDetailsDTO p=(ProjectDetailsDTO) li.get(0);
		return p;
	}
	
	public void updateProject(ProjectDetailsDTO p) {
		pRepo.updateProject(p);
	}
}
