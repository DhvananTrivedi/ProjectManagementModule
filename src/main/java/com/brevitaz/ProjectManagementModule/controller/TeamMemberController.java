package com.brevitaz.ProjectManagementModule.controller;

import com.brevitaz.ProjectManagementModule.model.Involvement;
import com.brevitaz.ProjectManagementModule.model.TeamMember;
import com.brevitaz.ProjectManagementModule.model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dhvanan on 7/2/18 Wednesday
 * @project ProjectManagementModule
 **/
@RestController
@RequestMapping("/team-member")
public class TeamMemberController {
    @RequestMapping(method = RequestMethod.POST)
    boolean add(@RequestBody TeamMember teamMember){
        return true;
    }

    @RequestMapping(method = RequestMethod.GET)
    List getAll()
    {
        System.out.println("List of all the team members in the company.");
        return null;
    }

    @RequestMapping(value = "/{teamMemberId}",method = RequestMethod.GET)
    List<Project> getProjects(@PathVariable String teamMemberId)
    {
        System.out.println("Opens the particular employee's list of involved Projects.");
        return null;
    }

    @RequestMapping(value = "/{teamMemberId}/project/{projectId}",method = RequestMethod.GET)
    List<Project> getInvolvement(@PathVariable String teamMemberId,@PathVariable String projectId)
    {
        System.out.println("Opens the involvement % of the member in the particular project.");
        return null;
    }

    @RequestMapping(value = "/{teamMemberId}/project/{projectId}",method = RequestMethod.POST)
    List<Project> setInvolvement(@PathVariable String teamMemberId, @PathVariable String projectId, @RequestBody Involvement involvement)
    {
        System.out.println("Sets a new involvement to the team member.");
        return null;
    }

    @RequestMapping(value = "/{teamMemberId}/project/{projectId}",method = RequestMethod.PUT)
    List<Project> updateInvolvement(@PathVariable String teamMemberId, @PathVariable String projectId, @RequestBody Involvement involvement)
    {
        System.out.println("Updates involvement");
        return null;
    }


    @RequestMapping(value = "/involvement/{teamMemberId}",method = RequestMethod.GET)
    String showInvolvement()
    {
        return "The member is involved by so and so %";
    }
}
