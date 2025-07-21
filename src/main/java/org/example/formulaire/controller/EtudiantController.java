package org.example.formulaire.controller;

import org.example.formulaire.model.Etudiant;
import org.example.formulaire.service.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {

    private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public String index() { return "index"; }

    @GetMapping("/liste")
    public String getEtudiants(Model model) {
        List<Etudiant> etudiants = etudiantService.getEtudiants();
        model.addAttribute("etudiants", etudiants);
        return "etudiants/etudiantList";
    }
}
