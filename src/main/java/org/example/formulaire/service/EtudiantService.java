package org.example.formulaire.service;

import org.example.formulaire.model.Etudiant;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EtudiantService {
    private final Map<UUID, Etudiant> etudiants;

    public EtudiantService() {
        this.etudiants = new HashMap<>();
        Etudiant etudiant = new Etudiant(UUID.randomUUID(), "damon", "matt", 23, "matt@damon.com");
        Etudiant etudiant1 = new Etudiant(UUID.randomUUID(), "washington", "denzel", 25, "denzel@washington.com");
        Etudiant etudiant2 = new Etudiant(UUID.randomUUID(), "connelly", "jennifer", 21, "jennifer@connelly.com");
        etudiants.put(etudiant.getId(), etudiant);
        etudiants.put(etudiant1.getId(), etudiant1);
        etudiants.put(etudiant2.getId(), etudiant2);
    }

    public List<Etudiant> getEtudiants() { return etudiants.values().stream().toList(); }

    public Etudiant getEtudiantById(UUID id) { return etudiants.get(id); }

    public void addEtudiant(Etudiant etudiant) {
        UUID id = UUID.randomUUID();
        etudiant.setId(id);
        etudiants.put(id, etudiant);
    }

    public void updateEtudiant(Etudiant etudiant) { etudiants.put(etudiant.getId(), etudiant); }

    public void removeEtudiant(UUID id) { etudiants.remove(id); }
}
