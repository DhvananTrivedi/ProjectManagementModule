package com.brevitaz.ProjectManagementModule.controller;


import com.brevitaz.ProjectManagementModule.dao.TeamLeaderDao;
import com.brevitaz.ProjectManagementModule.dao.impl.TeamLeaderDaoImpl;
import com.brevitaz.ProjectManagementModule.dao.impl.TeamMemberDaoImpl;
import com.brevitaz.ProjectManagementModule.model.Involvement;
import com.brevitaz.ProjectManagementModule.model.Project;
import com.brevitaz.ProjectManagementModule.model.TeamLeader;
import com.brevitaz.ProjectManagementModule.model.TeamMember;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teamleaders")
public class TeamLeaderController {


    @Autowired
    TeamLeaderDao teamLeaderDao;


    @RequestMapping(method = RequestMethod.POST)
    public boolean insert(@RequestBody TeamLeader teamLeader) {
        boolean status = teamLeaderDao.insert(teamLeader);
        System.out.println("Team leader is added successfully !!");
        return status;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<TeamLeader> getAll() {
        List<TeamLeader> teamLeaders = teamLeaderDao.getAll();
        System.out.println("List of all the team leaders in the company.");
        return teamLeaders;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TeamLeader getById(@PathVariable String id) {
        TeamLeader teamLeader = teamLeaderDao.getById(id);
        System.out.println("Team-leader with id - " + id);
        return teamLeader;
    }


    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<TeamLeader> getByName(@PathVariable String name) {
        List<TeamLeader> teamLeaders = teamLeaderDao.getByName(name);
        System.out.println("Team-leader with name - " + name);
        return teamLeaders;
    }


    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String id) {
        boolean status = teamLeaderDao.delete(id);
        System.out.println("Team-leader is successfully deleted");
        return status;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@PathVariable String id, @RequestBody TeamLeader teamLeader) {
        boolean status = teamLeaderDao.update(id, teamLeader);
        System.out.println("Team-leader is successfully updated");
        return status;
    }


    ////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/{teamMemberId}/project/{projectId}", method = RequestMethod.GET)
    List<Project> getInvolvement(@PathVariable String teamMemberId, @PathVariable String projectId) {
        System.out.println("Opens the involvement % of the member in the particular project.");
        return null;
    }

    @RequestMapping(value = "/{teamMemberId}/project/{projectId}", method = RequestMethod.POST)
    List<Project> setInvolvement(@PathVariable String teamMemberId, @PathVariable String projectId, @RequestBody Involvement involvement) {
        System.out.println("Sets a new involvement to the team member.");
        return null;
    }

    @RequestMapping(value = "/{teamMemberId}/project/{projectId}", method = RequestMethod.PUT)
    List<Project> updateInvolvement(@PathVariable String teamMemberId, @PathVariable String projectId, @RequestBody Involvement involvement) {
        System.out.println("Updates involvement");
        return null;
    }

}



