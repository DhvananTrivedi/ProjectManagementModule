package com.brevitaz.ProjectManagementModule.controller;

import com.brevitaz.ProjectManagementModule.model.Involvement;
import com.brevitaz.ProjectManagementModule.model.Project;
import com.brevitaz.ProjectManagementModule.model.TeamMember;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author dhvanan on 6/2/18 Tuesday
 * @project ProjectManagementModule
 **/
@RestController
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping(method = RequestMethod.POST)
    boolean add(@RequestBody Project project){
        System.out.println(" Project added!");
        return true;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Project> get()
    {
        System.out.println("View all projects.");
        return null;
    }

    @RequestMapping(value="/{projectId}",method = RequestMethod.GET)
    Project getById(@PathVariable String projectId){
        return null;
    }

    @RequestMapping(value = "/allocate-employees",method = RequestMethod.POST)
    boolean allocateEmployees(@RequestBody List employees)
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
    List<TeamMember>  allocatedEmployees(@PathVariable String projectId){
        System.out.println("List of allocated employees..");
        return null;
    }

    @RequestMapping(value = "/allocated-employees/{projectId}/involvement/{employeeId}",method = RequestMethod.GET)
    Involvement getInvolvement(@PathVariable String projectId, @PathVariable String employeeId){
        return new Involvement();
    }


}

