package com.brevitaz.ProjectManagementModule.controller;

import com.brevitaz.ProjectManagementModule.dao.TeamMemberDao;
import com.brevitaz.ProjectManagementModule.model.Involvement;
import com.brevitaz.ProjectManagementModule.model.SearchData;
import com.brevitaz.ProjectManagementModule.model.TeamMember;
import com.brevitaz.ProjectManagementModule.model.Project;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

/**
 * @author dhvanan on 7/2/18 Wednesday
 * @project ProjectManagementModule
 **/

@RestController
@RequestMapping("/team-members")
public class TeamMemberController {


    @Autowired
    TeamMemberDao teamMemberDao;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TeamMemberController.class);


    @RequestMapping(method = RequestMethod.POST)
    public boolean insert(@RequestBody TeamMember teamMember){
        boolean status = teamMemberDao.insert(teamMember);
        LOGGER.info("Team-member is added successfully !!!");
        return status;
    }

    @RequestMapping(method = RequestMethod.GET)
    public SearchData getAll()
    {
        SearchData searchData = new SearchData();
        searchData.setResponse(teamMemberDao.getAll());
        LOGGER.info("All team-members are listed !!!");
        return searchData;
    }

    @RequestMapping(value="/{id}" , method=RequestMethod.GET)
    public TeamMember getById(@PathVariable String teamMemberId)
    {
        TeamMember teamMember = teamMemberDao.getById(teamMemberId);
        LOGGER.info("team-member with get by id + "+teamMemberId);
        return teamMember;
    }

    @RequestMapping(value = "name/{name}" , method=RequestMethod.GET)
    public SearchData getByName(@PathVariable String teamMemberName)
    {
        SearchData searchData = new SearchData();
        searchData.setResponse(teamMemberDao.getByName(teamMemberName));
        LOGGER.info("List of team-members with name "+teamMemberName);
        return searchData;
    }

    @RequestMapping(value = "/{id}" ,method=RequestMethod.PUT)
    public boolean update(@PathVariable String id , @RequestBody TeamMember teamMember)
    {
        boolean status = teamMemberDao.update(id,teamMember);
        LOGGER.info("team-member with id "+id+"is successfully updated !!!");
        return status;
    }

    @RequestMapping(value = "/{id}" ,method=RequestMethod.DELETE)
    public boolean delete(@PathVariable String id )
    {
        boolean status = teamMemberDao.delete(id);
        LOGGER.info("Team-member is deleted successfully !!!");
        return status;
    }


    //////////////////////////////////////////////////////////////////
   /* @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public List<Project> getProjects(@PathVariable String teamMemberId)
    {

        System.out.println("Opens the particular employee's list of involved Projects.");
        return null;
    }*/

    @RequestMapping(value = "/{teamMemberId}/project/{projectId}",method = RequestMethod.GET)
    public List<Project> getInvolvement(@PathVariable String teamMemberId,@PathVariable String projectId)
    {
        System.out.println("Opens the involvement % of the member in the particular project.");
        return null;
    }

    @RequestMapping(value = "/{teamMemberId}/project/{projectId}",method = RequestMethod.POST)
    public List<Project> setInvolvement(@PathVariable String teamMemberId, @PathVariable String projectId, @RequestBody Involvement involvement)
    {
        System.out.println("Sets a new involvement to the team member.");
        return null;
    }

    @RequestMapping(value = "/{teamMemberId}/project/{projectId}",method = RequestMethod.PUT)
    public List<Project> updateInvolvement(@PathVariable String teamMemberId, @PathVariable String projectId, @RequestBody Involvement involvement)
    {
        System.out.println("Updates involvement");
        return null;
    }


    @RequestMapping(value = "/involvement/{teamMemberId}",method = RequestMethod.GET)
    public String showInvolvement()
    {
        return "The member is involved by so and so %";
    }
}

