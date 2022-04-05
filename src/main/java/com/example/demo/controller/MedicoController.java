package com.example.demo.controller;

import com.example.demo.Medico;
import com.example.demo.repo.MedicoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    
    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository repo){
        medicoRepository = repo;
    }

    @GetMapping("/all")
	Iterable<Medico> getPrimi(){
		return medicoRepository.findAll();
	}
	
	@GetMapping("/{codMedico}")
	Medico getCodMedico(@PathVariable int codMedico) {
		return medicoRepository.findById(codMedico).orElseThrow();
	}
	
	@PostMapping("/new") 
	Medico createMedico( @RequestBody Medico nuovomedico) {
		return  medicoRepository.save(nuovomedico);
	}
	
	@PutMapping("/{codMedico}")
	Medico updateMedico(@PathVariable int codMedico, @RequestBody Medico medicoDto){
		Medico medicoToUpdate = medicoRepository.findById(codMedico).orElseThrow();
		medicoToUpdate.setCodMedico(medicoDto.getCodMedico());
		medicoToUpdate.setNomeMedico(medicoDto.getNomeMedico());
		return medicoRepository.save(medicoToUpdate);
	}
	
	@DeleteMapping("/delete")
	void deleteMedico(@PathVariable int codMedico) {
		Medico medico = medicoRepository.findById(codMedico).orElseThrow();
		medicoRepository.delete(medico);
    }
}
