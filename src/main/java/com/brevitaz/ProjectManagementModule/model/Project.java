package com.brevitaz.ProjectManagementModule.model;

import java.util.Date;
import java.util.List;

/**
 * @author dhvanan on 6/2/18 Tuesday
 * @project ProjectManagementModule
 **/
public class Project {
    String name;
    List<String> technologies;
    Date assignDate;
    Date dueDate;
    List<TeamMember> teamMembers; /// Can be refactored with a List of TeamMember Class Objects.
    TeamLeader teamLeader;
    String state;




}
