package org.launchcode.RecipeOmatic.Models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @Column(updatable = false, nullable = false)
    private int id;

    @PrePersist
    public void autofill() {
        UUID uuid = UUID.randomUUID();
        this.id = (int)UUID.randomUUID().getMostSignificantBits();
    }

    public int getId() {
        return id;
    }

}
