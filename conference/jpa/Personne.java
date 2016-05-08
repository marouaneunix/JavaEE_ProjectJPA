package com.conference.jpa;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.conference.jpa.service.EncryptPass;

/**
 * Entity implementation class for Entity: Personne
 *
 */
@Entity
@NamedQueries( {
        @NamedQuery( name = "Personne.findAll", query = "SELECT p FROM Personne p" ),
        @NamedQuery( name = "Personne.findByCin", query = "SELECT p FROM Personne p WHERE p.cin = :cin" ),
})
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "type", discriminatorType = DiscriminatorType.STRING )
@Table( name = "PERSONNE" )
public abstract class Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String            cin;
    private String            nom;
    private String            prenom;
    @Lob
    private String            password;

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {

        this.password = EncryptPass.encPass( password );
    }

    public String getCin() {
        return cin;
    }

    public void setCin( String cin ) {
        this.cin = cin;
    }

    public Personne() {
        super();
    }

}
