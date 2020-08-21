package org.launchcode.RecipeOmatic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Directions extends AbstractEntity {

    @Column
    private String directions;

    public Directions(){}

    public Directions(String directions){
        super();
        this.directions = directions;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
