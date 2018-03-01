package com.brevitaz.ProjectManagementModule.controller;


import com.brevitaz.ProjectManagementModule.dao.TeamLeaderDao;
import com.brevitaz.ProjectManagementModule.dao.impl.TeamLeaderDaoImpl;
import com.brevitaz.ProjectManagementModule.dao.impl.TeamMemberDaoImpl;
import com.brevitaz.ProjectManagementModule.model.*;
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

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TeamLeaderController.class);


    @RequestMapping(method = RequestMethod.POST)
    public boolean insert(@RequestBody TeamLeader teamLeader) {
        boolean status = teamLeaderDao.insert(teamLeader);
        LOGGER.info("Teamleader is added successfully !!!");
        return status;
    }


    @RequestMapping(method = RequestMethod.GET)
    public SearchData getAll() {

        SearchData searchData = new SearchData();
        searchData.setResponse(teamLeaderDao.getAll());
        LOGGER.info("All team-leaders are listed !!!");
        return searchData;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TeamLeader getById(@PathVariable String id) {
        TeamLeader teamLeader = teamLeaderDao.getById(id);
        LOGGER.info("Team-leader with get by id + "+id);
        return teamLeader;
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public SearchData getByName(@RequestBody String name) {

        SearchData searchData = new SearchData();
        searchData.setResponse(teamLeaderDao.getByName(name));
        LOGGER.info("List of team-leaders with name "+name);
        return searchData;
    }


    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String id) {
        boolean status = teamLeaderDao.delete(id);
        LOGGER.info("Teamleader is deleted successfully !!!");
        return status;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@PathVariable String id, @RequestBody TeamLeader teamLeader) {
        boolean status = teamLeaderDao.update(id, teamLeader);
        LOGGER.info("Team-leader with id "+id+"is successfully updated !!!");
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


