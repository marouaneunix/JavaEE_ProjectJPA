package com.conference.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@DiscriminatorValue( "admin" )
public class Admin extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany( mappedBy = "admin", cascade = CascadeType.ALL )
    private List<Programme>   programmeList    = new ArrayList<Programme>();

    public List<Programme> getProgrammeList() {
        return programmeList;
    }

    public void setProgrammeList( List<Programme> programmeList ) {
        this.programmeList = programmeList;
    }

    public Admin() {
        super();
    }

}
