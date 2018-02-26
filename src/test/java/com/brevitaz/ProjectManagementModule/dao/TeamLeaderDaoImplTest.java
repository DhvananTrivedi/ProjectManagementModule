package com.brevitaz.ProjectManagementModule.dao;


import com.brevitaz.ProjectManagementModule.model.TeamLeader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TeamLeaderDaoImplTest {


    @Autowired
    TeamLeaderDao teamLeaderDao;

    @Test
    public void testInsert() {
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setId("7899");
        teamLeader.setName("Adhishree");
        boolean status = teamLeaderDao.insert(teamLeader);
        System.out.println(status);
        Assert.assertEquals(true, status);

    }

    @Test
    public void testDelete() {
        boolean status = teamLeaderDao.delete("789");
        Assert.assertEquals(true, status);
    }

    @Test
    public void testUpdate() {
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setName("aabbcc");
        boolean status = teamLeaderDao.update("7899", teamLeader);
        System.out.println(status);
        Assert.assertEquals(true, status);
    }

    @Test
    public void testGetById() {
        TeamLeader teamLeader = teamLeaderDao.getById("7899");
        System.out.println(teamLeader);
        Assert.assertNotNull(teamLeader);
    }

    @Test
    public void testGetByName() {
        List<TeamLeader> teamMembers = teamLeaderDao.getByName("Adhishree");
        System.out.println("TEAM MEMBERS : " + teamMembers);
        Assert.assertNotNull(teamMembers);
    }

    @Test
    public void testGetAll() {
        List<TeamLeader> teamMembers = teamLeaderDao.getAll();
        System.out.println(teamMembers);
        Assert.assertNotNull(teamMembers);
    }


}
