package com.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.ProjectDetailsDTO;

@Repository
public class ProjectDetailsRepo{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	List<ProjectDetailsDTO> list;
	public String saveProjectDataRepo(ProjectDetailsDTO pDto) {
		System.out.println("Inside ProjectRepo"+ pDto.getProjectName());
		hibernateTemplate.save(pDto);
		return "Saved";
	}
	
	public List<ProjectDetailsDTO> getProjectList() {
		list= hibernateTemplate.loadAll(ProjectDetailsDTO.class);
		return list;
	}
	
	public List getPro(int id) {
		List li=hibernateTemplate.find("from ProjectDetailsDTO where pNo=?",id);
		return li;
	}
	
	public void deletePro(ProjectDetailsDTO p) {
			hibernateTemplate.delete(p);	
	}
	
	public void updateProject(ProjectDetailsDTO p) {
		hibernateTemplate.update(p);	
}
}
