package com.brevitaz.ProjectManagementModule.model;

/**
 * @author dhvanan on 7/2/18 Wednesday
 * @project ProjectManagementModule
 **/
public class Involvement {

    String id;
    Project project;
    int involvementPercentage;
    //TeamMember teamMember;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getInvolvementPercentage() {
        return involvementPercentage;
    }

    public void setInvolvementPercentage(int involvementPercentage) {
        this.involvementPercentage = involvementPercentage;
    }

    @Override
    public String toString() {
        return "Involvement{" +
                "id='" + id + '\'' +
                ", project=" + project +
                ", involvementPercentage=" + involvementPercentage +
                '}';
    }
}
