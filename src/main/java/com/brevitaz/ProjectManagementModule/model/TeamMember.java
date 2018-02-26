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
    String teamName;

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
}
