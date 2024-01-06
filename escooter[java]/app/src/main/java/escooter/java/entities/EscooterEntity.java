package escooter.java.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Escooter")
public class EscooterEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "state")
    public String state;

    @Column(name = "location")
    public String location;

}
