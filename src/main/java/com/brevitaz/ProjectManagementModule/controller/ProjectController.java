package com.brevitaz.ProjectManagementModule.controller;

import com.brevitaz.ProjectManagementModule.dao.ProjectDao;
import com.brevitaz.ProjectManagementModule.model.Involvement;
import com.brevitaz.ProjectManagementModule.model.Project;
import com.brevitaz.ProjectManagementModule.model.SearchData;
import com.brevitaz.ProjectManagementModule.model.TeamMember;
import org.slf4j.LoggerFactory;
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

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);


    @RequestMapping(method = RequestMethod.POST)
    public boolean add(@RequestBody Project project){
        boolean status = projectDao.insert(project);
        LOGGER.info("Project is added successfully !!!");
        return status;
    }

    @RequestMapping(method = RequestMethod.GET)
    public SearchData getAll()
    {
        SearchData searchData = new SearchData();
        searchData.setResponse(projectDao.getAll());
        LOGGER.info("All projects are listed !!!");
        return searchData;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Project getById(@PathVariable String projectId)
    {
        Project project = projectDao.getById(projectId);
        LOGGER.info("Project with get by id + "+projectId);
        return project;
    }

    @RequestMapping(value="/name/{name}",method = RequestMethod.GET)
    public SearchData getByName(@PathVariable String projectName)
    {
        SearchData searchData = new SearchData();
        searchData.setResponse(projectDao.getByName(projectName));
        LOGGER.info("List of projects with name "+projectName);
        return searchData;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String projectId)
    {
        boolean status = projectDao.delete(projectId);
        LOGGER.info("Project is deleted successfully !!!");
        return status;
    }

    public boolean update(@PathVariable String projectId , @RequestBody Project project)
    {
        boolean status = projectDao.update(projectId,project);
        LOGGER.info("Project with id "+projectId+"is successfully updated !!!");
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

