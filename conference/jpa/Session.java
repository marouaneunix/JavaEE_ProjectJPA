package com.conference.jpa;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Session
 *
 */

@Entity
@NamedQueries( {
        @NamedQuery( name = "Session.findAll", query = "SELECT s FROM Session s" ),

})
@Table( name = "SESSION" )
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int               sessionId;
    private String            intitule;
    @Temporal( TemporalType.TIME )
    private Date              dateDebute;
    @Temporal( TemporalType.TIME )
    private Date              dateFin;
    @ManyToOne
    private Chair             chair;
    @ManyToOne
    private Programme         programme;
    @OneToMany( mappedBy = "session", cascade = { CascadeType.ALL }, orphanRemoval = false, fetch = FetchType.EAGER )
    private Set<Article>      articleList      = new HashSet<Article>();

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId( int sessionId ) {
        this.sessionId = sessionId;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair( Chair chair ) {
        this.chair = chair;
    }

    public Set<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList( Set<Article> articleList ) {
        this.articleList = articleList;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme( Programme programme ) {
        this.programme = programme;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule( String intitule ) {
        this.intitule = intitule;
    }

    public Date getDateDebute() {
        return dateDebute;
    }

    public void setDateDebute() throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat( "hh:mm" );
        this.dateDebute = sdf1.parse( "09:00" );
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin( Date dateFin ) {
        this.dateFin = dateFin;
    }

    public Session() {
        super();
        try {
            this.setDateDebute();
        } catch ( ParseException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
