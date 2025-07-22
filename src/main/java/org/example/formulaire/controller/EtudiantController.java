package org.example.formulaire.controller;

import org.example.formulaire.model.Etudiant;
import org.example.formulaire.service.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/detail/{id}")
    public String getEtudiantById(@PathVariable("id") UUID id, Model model) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "etudiants/etudiantDetail";
    }

    @GetMapping("/add")
    public String addEtudiant(Model model) {
        Etudiant etudiant = new Etudiant();
        model.addAttribute("etudiant", etudiant);
        return "etudiants/etudiantForm";
    }

    @PostMapping("/add")
    public String addEtudiant(Etudiant etudiant) {
        etudiantService.addEtudiant(etudiant);
        return "redirect:/etudiant/liste";
    }
}
