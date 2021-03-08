package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;
import com.uniovi.validators.AddProfessorFormValidator;

@Controller
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private AddProfessorFormValidator addProfessorValidator;
	
	@RequestMapping("/professor/list")
	public String getList(Model model) {
		model.addAttribute("professorList", professorService.getProfessor());
		return "professor/list";
	}

	@RequestMapping(value = "/professor/add")
	public String getProfessor(Model model) {
		model.addAttribute("professor", new Professor());
		return "professor/add";
	}

	@RequestMapping( value = "/professor/add", method = RequestMethod.POST)
	public String setProfessor( @Validated @ModelAttribute Professor profesor, BindingResult result) {
		addProfessorValidator.validate(profesor, result);
		if (result.hasErrors()) {
			return "professor/add";
		}
		professorService.addProfessor(profesor);
		return "redirect:/professor/list";
	}

	@RequestMapping(value = "/professor/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		model.addAttribute("professor", professorService.getProfessor(id));
		return "professor/details";
	}

	@RequestMapping("/professor/delete/{id}")
	public String deleteProfessor(@PathVariable Long id) {
		professorService.deleteProfessor(id);
		return "redirect:/professor/list";
	}

	@RequestMapping(value = "/professor/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		model.addAttribute("professor", professorService.getProfessor(id));
		return "professor/edit";
	}

	@RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Professor profesor) {
		profesor.setId(id);
		professorService.addProfessor(profesor);
		return "redirect:/professor/details/" + id;
	}

}
