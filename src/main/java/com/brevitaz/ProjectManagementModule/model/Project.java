package com.brevitaz.ProjectManagementModule.model;

import java.util.Date;
import java.util.List;

/**
 * @author dhvanan on 6/2/18 Tuesday
 * @project ProjectManagementModule
 **/
public class Project {

    String id;
    String name;
    List<String> technologies;
    Date assignDate;
    Date dueDate;
    List<TeamMember> teamMembers;
    TeamLeader teamLeader;
    String state;


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

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public TeamLeader getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(TeamLeader teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (technologies != null ? !technologies.equals(project.technologies) : project.technologies != null)
            return false;
        if (assignDate != null ? !assignDate.equals(project.assignDate) : project.assignDate != null) return false;
        if (dueDate != null ? !dueDate.equals(project.dueDate) : project.dueDate != null) return false;
        if (teamMembers != null ? !teamMembers.equals(project.teamMembers) : project.teamMembers != null) return false;
        if (teamLeader != null ? !teamLeader.equals(project.teamLeader) : project.teamLeader != null) return false;
        return state != null ? state.equals(project.state) : project.state == null;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", technologies=" + technologies +
                ", assignDate=" + assignDate +
                ", dueDate=" + dueDate +
                ", teamMembers=" + teamMembers +
                ", teamLeader=" + teamLeader +
                ", state='" + state + '\'' +
                '}';
    }
}
