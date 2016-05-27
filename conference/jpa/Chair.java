package com.conference.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Chair
 *
 */
@Entity
@DiscriminatorValue( "chair" )
public class Chair extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany( mappedBy = "chair", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER )
    private List<Session>     sessionList      = new ArrayList<Session>();

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList( List<Session> sessionList ) {
        this.sessionList = sessionList;
    }

    public Chair() {
        super();
    }

    @Override
    public String toString() {
        return String.format( "%s", getCin() );
    }

}
