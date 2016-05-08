package com.conference.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Article
 *
 */

@Entity
@NamedQueries( {
        @NamedQuery( name = "Article.findAll", query = "SELECT ar FROM Article ar" ),
})
@Table( name = "ARTICLE" )
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int               articleId;
    private boolean           accepter;
    private int               dureeArticle;
    private String            intitule;
    private String            description;

    @ManyToOne
    private Session           session;

    @ManyToMany( mappedBy = "articles", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    // @ManyToMany( mappedBy = "articles", fetch = FetchType.EAGER )
    private List<Auteur>      auteurs          = new ArrayList<Auteur>();

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId( int articleId ) {
        this.articleId = articleId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession( Session session ) {
        this.session = session;
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs( List<Auteur> auteurs ) {
        this.auteurs = auteurs;
    }

    public boolean isAccepter() {
        return accepter;
    }

    public void setAccepter( boolean accepter ) {
        this.accepter = accepter;
    }

    public int getDureeArticle() {
        return dureeArticle;
    }

    public void setDureeArticle( int dureeArticle ) {
        if ( ( dureeArticle <= 20 ) && ( dureeArticle >= 15 ) )
            this.dureeArticle = dureeArticle;
        else
            System.out.println( "Error" );
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule( String intitule ) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public Article() {
        this.accepter = false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( accepter ? 1231 : 1237 );
        result = prime * result + articleId;
        result = prime * result + ( ( auteurs == null ) ? 0 : auteurs.hashCode() );
        result = prime * result + ( ( description == null ) ? 0 : description.hashCode() );
        result = prime * result + dureeArticle;
        result = prime * result + ( ( intitule == null ) ? 0 : intitule.hashCode() );
        result = prime * result + ( ( session == null ) ? 0 : session.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Article other = (Article) obj;
        if ( accepter != other.accepter )
            return false;
        if ( articleId != other.articleId )
            return false;
        if ( auteurs == null ) {
            if ( other.auteurs != null )
                return false;
        } else if ( !auteurs.equals( other.auteurs ) )
            return false;
        if ( description == null ) {
            if ( other.description != null )
                return false;
        } else if ( !description.equals( other.description ) )
            return false;
        if ( dureeArticle != other.dureeArticle )
            return false;
        if ( intitule == null ) {
            if ( other.intitule != null )
                return false;
        } else if ( !intitule.equals( other.intitule ) )
            return false;
        if ( session == null ) {
            if ( other.session != null )
                return false;
        } else if ( !session.equals( other.session ) )
            return false;
        return true;
    }

}
