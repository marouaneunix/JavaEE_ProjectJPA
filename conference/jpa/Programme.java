package com.conference.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
 * Entity implementation class for Entity: Programme
 *
 */

@Entity
@NamedQueries( {
        @NamedQuery( name = "Programme.findAll", query = "SELECT prg FROM Programme prg" ),

})
@Table( name = "PROGRAMME" )
public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int               programmeId;
    @Temporal( TemporalType.DATE )
    private Date              dateSession;
    @ManyToOne
    private Admin             admin;
    @OneToMany( mappedBy = "programme", cascade = CascadeType.ALL )
    private List<Session>     sessionList      = new ArrayList<Session>();

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId( int programmeId ) {
        this.programmeId = programmeId;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList( List<Session> sessionList ) {
        this.sessionList = sessionList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin( Admin admin ) {
        this.admin = admin;
    }

    public Date getDateSession() {
        return dateSession;
    }

    public void setDateSession( Date dateSession ) {
        this.dateSession = dateSession;
    }

    public Programme() {
        super();
    }

}
