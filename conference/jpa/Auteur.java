package com.conference.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Auteur
 *
 */
@Entity
@DiscriminatorValue( "auteur" )
public class Auteur extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable( name = "AUTEUR_ARTICLE", joinColumns = { @JoinColumn( name = "AUTEUR_ID" ) }, inverseJoinColumns = {
            @JoinColumn( name = "ARTICLE_ID" ) })
    private List<Article>     articles         = new ArrayList<Article>();

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles( List<Article> articles ) {
        this.articles = articles;
    }

    public Auteur() {
        super();
    }

}
