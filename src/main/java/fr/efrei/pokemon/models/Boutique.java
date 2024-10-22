package fr.efrei.pokemon.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Boutique {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // AUTO INCREMENT
    private String id;

    private String name; //Nom de la boutique

    @OneToMany //Lien objet en vente
    private List<Objet> objetsEnVente; //liste des objets dispo

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Objet> getObjetsEnVente() {
        return objetsEnVente;
    }

    public void setObjetsEnVente(List<Objet> objetsEnVente) {
        this.objetsEnVente = objetsEnVente;
    }
}
