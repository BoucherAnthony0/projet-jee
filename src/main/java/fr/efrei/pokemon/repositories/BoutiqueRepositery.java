package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BoutiqueRepositery extends JpaRepository<Boutique, String> {
}
