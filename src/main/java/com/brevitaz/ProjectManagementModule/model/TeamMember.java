package com.brevitaz.ProjectManagementModule.model;

import java.util.List;

/**
 * @author dhvanan on 7/2/18 Wednesday
 * @project ProjectManagementModule
 **/
public class TeamMember {

    String id;
    String name;
    List<Involvement> involvements;
    String designation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Involvement> getInvolvements() {
        return involvements;
    }

    public void setInvolvements(List<Involvement> involvements) {
        this.involvements = involvements;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", involvements=" + involvements +
                ", designation='" + designation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamMember that = (TeamMember) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (involvements != null ? !involvements.equals(that.involvements) : that.involvements != null) return false;
        return designation != null ? designation.equals(that.designation) : that.designation == null;
    }

}
