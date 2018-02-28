package com.brevitaz.ProjectManagementModule.model;

import java.util.List;

/**
 * @author dhvanan on 7/2/18 Wednesday
 * @project ProjectManagementModule
 **/
public class TeamMember {

    String id;
    String name;
    List<Project> projects;
    List<Involvement> involvements;
    String designation;
    String teamName; //List<String> teams

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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", projects=" + projects +
                ", involvements=" + involvements +
                ", designation='" + designation + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamMember that = (TeamMember) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (projects != null ? !projects.equals(that.projects) : that.projects != null) return false;
        if (involvements != null ? !involvements.equals(that.involvements) : that.involvements != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        return teamName != null ? teamName.equals(that.teamName) : that.teamName == null;
    }

}
