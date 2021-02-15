package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@RestController
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;

	@RequestMapping("/professor/list")
	public String getList() {
		return professorService.getProfessor().toString();
	}

	@RequestMapping(value="/professor/add", method=RequestMethod.POST)
	public String setProfessor(@ModelAttribute Professor profesor) {
		professorService.addProfessor(profesor);
		return "Added";
	}
	
	@RequestMapping("/professor/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return professorService.getProfessor(id).toString();
	}
	
	@RequestMapping("/professor/delete/{id}")
	public String deleteProfessor(@PathVariable Long id) {
		professorService.deleteProfessor(id);
		return "Deleted";
	}
	
	@RequestMapping(value="/professor/edit", method=RequestMethod.POST)
	public String editProfessor(@ModelAttribute Professor profesorCambios) {
		//Conseguir el profesor a cambiar
		Professor profesorACambiar=professorService.getProfessor(profesorCambios.getId());
		//Cambiar cosas
		profesorACambiar.setDni(profesorCambios.getDni());
		profesorACambiar.setNombre(profesorCambios.getNombre());
		profesorACambiar.setApellido(profesorCambios.getApellido());
		profesorACambiar.setCategoria(profesorCambios.getCategoria());
		return "Edited";
	}
}
