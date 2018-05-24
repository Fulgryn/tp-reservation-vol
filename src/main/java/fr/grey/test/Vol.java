package fr.grey.test;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
public class Vol {

    //region DECLARATIONS
    @Id
    @SequenceGenerator(name = "vol_id_seq", sequenceName = "vol_id_seq", initialValue = 1)
    @GeneratedValue(generator = "vol_id_seq")
    private Long id;

    @NotNull
    private String numeroVol;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Avion typeAvion;

    @NotNull
    private Integer nbPlaces;

    @NotBlank
    private String villeDepart;

    @NotBlank
    private String villeArrivee;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateDepart;

    @OneToMany(mappedBy= "volReservation")
    private List<Reservation> reservationsVol;
    //endregion


    //region CONSTRUCTORS
    public Vol() {
    }

    public Vol(@NotNull String numeroVol, @NotNull Avion typeAvion, @NotNull Integer place, @NotBlank String villeDepart, @NotBlank String villeArrivee, @NotNull Date dateDepart) {
        this();
        this.numeroVol = numeroVol;
        this.typeAvion = typeAvion;
        this.nbPlaces = place;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepart = dateDepart;
    }
    //endregion

    //region GETTERS // SETTERS
    public Long getId() {
        return id;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public Avion getTypeAvion() {
        return typeAvion;
    }

    public void setTypeAvion(Avion typeAvion) {
        this.typeAvion = typeAvion;
    }

    public Integer getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Integer nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }
    //endregion


    @Override
    public String toString() {
        return getNumeroVol()+"\t| "
                + getTypeAvion().toString()+"\t| "
                + getVilleDepart() + "\t| "
                + getVilleArrivee()+ "\t| "
                + String.format("%1$td-%1$tm-%1$tY", getDateDepart());
    }
}
