package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.ProjectDetailsDTO;
import com.aartek.validator.ProjectDetailsValidator;
import com.service.ProjectDetailsService;

@Controller
public class ProjectDetailsController {

	@Autowired
	private ProjectDetailsService pService;

	@Autowired
	private ProjectDetailsValidator validator;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String saveDetails(ModelMap map) {
		map.put("ProjectDetailsDTO", new ProjectDetailsDTO());
		List<ProjectDetailsDTO> projects = pService.getProjectService();
		map.addAttribute("projects", projects);
		return "project";
	}

	@RequestMapping(value = "/showDetails", method = RequestMethod.POST)
	public String saveProject(@ModelAttribute("ProjectDetailsDTO") ProjectDetailsDTO pDto, BindingResult bResult,
			ModelMap map) {
		validator.validate(pDto, bResult);
		
		if (bResult.hasErrors()) {
			List<ProjectDetailsDTO> projects = pService.getProjectService();
			map.addAttribute("projects", projects);
			return "project";
		}
		pService.saveProjectDataService(pDto);
		return "redirect:/project.do";
	}
	
	@RequestMapping(value="/deleteProject")
	public String deleteProject(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));	
		pService.deleteProject(Integer.parseInt(request.getParameter("id")));
		return "redirect:/project.do";
	}
	
	@RequestMapping(value="/editProject")
	public String getProject(HttpServletRequest request,ModelMap map) {
		map.put("project", pService.getProject(Integer.parseInt(request.getParameter("id"))));
		return "editProject";
	}
	
	@RequestMapping(value="/editProject",method=RequestMethod.POST)
	public String saveProject(@ModelAttribute("project") ProjectDetailsDTO p,BindingResult bResult) {
		if (bResult.hasErrors()) {
			return "editProject";
		}
		pService.updateProject(p);
		return "redirect:/project.do";
	}
}
