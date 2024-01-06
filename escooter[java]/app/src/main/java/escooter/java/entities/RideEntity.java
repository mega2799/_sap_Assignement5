package escooter.java.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ride")
public class RideEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "startedDate")
    private Date startedDate;
    
    @Column(name = "ongoing")
    private boolean ongoing;

    @Column(name = "endDate")
    private Date endDate;

    @ManyToOne(fetch=FetchType.LAZY)
    private UserEntity user;

    @ManyToOne(fetch=FetchType.LAZY)
    private EscooterEntity escooter;

    public RideEntity(Date startedDate, boolean ongoing, Date endDate, UserEntity user, EscooterEntity escooter) {
        this.startedDate = startedDate;
        this.ongoing = ongoing;
        this.endDate = endDate;
        this.user = user;
        this.escooter = escooter;
    }

}
