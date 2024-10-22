package fr.efrei.pokemon.models;

import fr.efrei.pokemon.constants.PrixObjet;
import jakarta.persistence.*;

@Entity
public class Objet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name; //nom de l'objet

    private int price; //prix de l'objet

    private int quantity; //quantité dispo

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
