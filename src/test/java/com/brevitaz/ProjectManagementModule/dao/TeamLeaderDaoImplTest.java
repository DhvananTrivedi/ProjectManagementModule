package com.brevitaz.ProjectManagementModule.dao;


import com.brevitaz.ProjectManagementModule.model.TeamLeader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TeamLeaderDaoImplTest {


    @Autowired
    TeamLeaderDao teamLeaderDao;

    @Test
    public void testInsert() {
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setId("111");
        teamLeader.setName("Adhishree");
        boolean insertStatus = teamLeaderDao.insert(teamLeader);
        Assert.assertEquals(true, insertStatus);

        TeamLeader expectedTeamLeader = teamLeaderDao.getById("111");
        Assert.assertEquals(expectedTeamLeader,teamLeader);

        boolean deleteStatus = teamLeaderDao.delete("111");
        Assert.assertEquals(true,deleteStatus);
    }

    @Test
    public void testDelete() {

        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setId("222");
        teamLeader.setName("Adhishree");
        boolean insertStatus = teamLeaderDao.insert(teamLeader);

        boolean deleteStatus = teamLeaderDao.delete("222");
        Assert.assertEquals(true, deleteStatus);

        try{
            TeamLeader expectedTeamLeader = teamLeaderDao.getById("222");
        }
        catch(NullPointerException ex)
        {
            System.out.println("This ID has been already deleted");
        }
    }

    @Test
    public void testUpdate()/*****************/
    {
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setName("aabbcc");
        boolean status = teamLeaderDao.update("7899", teamLeader);
        System.out.println(status);
        Assert.assertEquals(true, status);
    }

    @Test
    public void testGetById() {

        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setId("333");
        teamLeader.setName("Adhishree");
        boolean insertStatus = teamLeaderDao.insert(teamLeader);
        Assert.assertEquals(true,insertStatus);
        TeamLeader expectedTeamLeader = teamLeaderDao.getById("333");
        Assert.assertEquals(expectedTeamLeader,teamLeader);
        boolean deleteStatus = teamLeaderDao.delete("333");
        Assert.assertEquals(true,deleteStatus);
    }

    @Test
    public void testGetByName() {

        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setId("1122");
        teamLeader.setName("Dhvanan Trivedi");
        boolean insertStatus = teamLeaderDao.insert(teamLeader);

        TeamLeader teamLeader1 = new TeamLeader();
        teamLeader1.setId("2255");
        teamLeader1.setName("Dhvanan");
        boolean insertStatus1 = teamLeaderDao.insert(teamLeader1);

        List<TeamLeader> teamLeaders = teamLeaderDao.getByName("Dhvanan");
        System.out.println("TEAM MEMBERS : " + teamLeaders);
        Assert.assertThat(teamLeaders,hasItems(teamLeader,teamLeader1));

        boolean deleteStatus = teamLeaderDao.delete("2255");
        boolean deleteStatus1 = teamLeaderDao.delete("1122");
        Assert.assertEquals(true,deleteStatus);
        Assert.assertEquals(true,deleteStatus1);

    }

    @Test
    public void testGetAll() {

        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setId("4455");
        teamLeader.setName("Adhishree Adiecha");
        boolean insertStatus = teamLeaderDao.insert(teamLeader);

        TeamLeader teamLeader1 = new TeamLeader();
        teamLeader1.setId("5566");
        teamLeader1.setName("Dhvanan Trivedi");
        boolean insertStatus1 = teamLeaderDao.insert(teamLeader1);

        List<TeamLeader> teamLeaders = teamLeaderDao.getAll();
        System.out.println(teamLeaders);

        Assert.assertThat(teamLeaders,hasItems(teamLeader,teamLeader1));
    }


}
