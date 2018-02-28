package com.brevitaz.ProjectManagementModule.controller;

import com.brevitaz.ProjectManagementModule.dao.ProjectDao;
import com.brevitaz.ProjectManagementModule.model.Involvement;
import com.brevitaz.ProjectManagementModule.model.Project;
import com.brevitaz.ProjectManagementModule.model.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author dhvanan on 6/2/18 Tuesday
 * @project ProjectManagementModule
 **/
@RestController
@RequestMapping("/projects")
public class ProjectController {


    @Autowired
    ProjectDao projectDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean add(@RequestBody Project project){
        boolean status = projectDao.insert(project);
        System.out.println(" Project added!");
        return status;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Project> getAll()
    {
        List<Project> projects = projectDao.getAll();
        System.out.println("View all projects.");
        return projects;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Project getById(@PathVariable String projectId)
    {
        Project project = projectDao.getById(projectId);
        System.out.println("Project - BY ID");
        return project;
    }

    @RequestMapping(value="/{name}",method = RequestMethod.GET)
    public List<Project> getByName(@PathVariable String projectName)
    {
        List<Project> projects = projectDao.getByName(projectName);
        System.out.println("Projects - GET BY NAME ");
        return projects;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String projectId)
    {
        boolean status = projectDao.delete(projectId);
        System.out.println("Projects - DELETE");
        return status;
    }

    public boolean update(@PathVariable String projectId , @RequestBody Project project)
    {
        boolean status = projectDao.update(projectId,project);
        System.out.println("Projects - UPDATE");
        return status;
    }

    ////////////////////////////////////////////////////////////////////////////


    @RequestMapping(value = "/allocate-employees",method = RequestMethod.POST)
    public boolean allocateEmployees(@RequestBody List employees)
    {
        System.out.println("Allocating employees to project");
        return true;
    }


    @RequestMapping(value = "/allocate-employees/assign-involvement",method = RequestMethod.POST)
    boolean assignInvolvement(@RequestBody List employees)
    {
        System.out.println("Assigning involvement of employees to project");
        return true;
    }

    @RequestMapping(value = "/allocated-employees/{projectId}",method = RequestMethod.GET)
    public List<TeamMember>  allocatedEmployees(@PathVariable String projectId)
    {
        System.out.println("List of allocated employees..");
        return null;
    }

    @RequestMapping(value = "/allocated-employees/{projectId}/involvement/{employeeId}",method = RequestMethod.GET)
    Involvement getInvolvement(@PathVariable String projectId, @PathVariable String employeeId){
        return new Involvement();
    }


}

