package escooter.java.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    public String name;

    public UserEntity(String name) {
        this.name = name;
    }

    
}
