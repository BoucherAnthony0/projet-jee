package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Boutique;
import fr.efrei.pokemon.repositories.BoutiqueRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoutiqueService {
    private final BoutiqueRepositery boutiqueRepository;

    @Autowired
    public BoutiqueService(BoutiqueRepositery boutiqueRepository) {
        this.boutiqueRepository = boutiqueRepository;
    }

    // Trajet de la donnée
    // Base de données -> Entité -> Repository -> Service -> Controller
    public List<Boutique> findAll() {
        // SELECT * FROM boutique;
        return boutiqueRepository.findAll();
    }

    public Boutique findById(String id) {
        // Optional : soit l'objet soit null
        // SELECT * FROM boutique WHERE id = :id
        return boutiqueRepository.findById(id).orElse(null);
    }

    // Trajet de la donnée
    // Controller -> Service -> Repository -> Entité -> BDD
    public void save(Boutique boutique) {
        // INSERT INTO boutique VALUES (:name, :objetsEnVente);
        boutiqueRepository.save(boutique);
    }

    public void delete(String id) {
        // DELETE FROM boutique WHERE id = :id
        boutiqueRepository.deleteById(id);
    }

    public void update(String id, Boutique boutiqueBody) {
        Boutique boutiqueAModifier = findById(id);
        boutiqueAModifier.setName(boutiqueBody.getName());
        boutiqueAModifier.setObjetsEnVente(boutiqueBody.getObjetsEnVente());
        boutiqueRepository.save(boutiqueAModifier);
    }

    public void partialUpdate(String id, Boutique boutiqueBody) {
        Boutique boutiqueAModifier = findById(id);
        if (boutiqueBody.getName() != null) {
            boutiqueAModifier.setName(boutiqueBody.getName());
        }
        if (boutiqueBody.getObjetsEnVente() != null) {
            boutiqueAModifier.setObjetsEnVente(boutiqueBody.getObjetsEnVente());
        }
        boutiqueRepository.save(boutiqueAModifier);
    }
}

