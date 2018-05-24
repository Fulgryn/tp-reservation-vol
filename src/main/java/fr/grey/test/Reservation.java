package fr.grey.test;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Reservation {

    //region DECLARATIONS
    @Id
    @SequenceGenerator(name = "reservation_id_seq", sequenceName = "reservation_id_seq", initialValue = 1)
    @GeneratedValue(generator = "reservation_id_seq")
    private Long id;

    @NotBlank
    private String codeReservation;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotNull
    private Integer age;

    @ManyToOne
    private Vol volReservation;
    //endregion

    //region CONSTRUCTORS
    public Reservation() {
    }
    //endregion

    //region GETTERS // SETTERS
    public Long getId() {
        return id;
    }

    public String getCodeReservation() {
        return codeReservation;
    }

    public void setCodeReservation(String codeReservation) {
        this.codeReservation = codeReservation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    //endregion
}
