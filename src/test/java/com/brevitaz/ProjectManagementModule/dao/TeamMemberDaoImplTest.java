package com.brevitaz.ProjectManagementModule.dao;


import com.brevitaz.ProjectManagementModule.model.TeamMember;
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
public class TeamMemberDaoImplTest {

    @Autowired
    TeamMemberDao teamMemberDao;

    @Test
    public void testInsert()
    {
        TeamMember teamMember = new TeamMember();
        teamMember.setId("778899");
        teamMember.setName("Adhishree");
        boolean insertStatus = teamMemberDao.insert(teamMember);

        TeamMember expectedTeamLeader = teamMemberDao.getById("778899");
        Assert.assertEquals(expectedTeamLeader,teamMember);

        boolean deleteStatus = teamMemberDao.delete("778899");
        Assert.assertEquals(true,deleteStatus);

    }

    @Test
    public void testDelete()
    {
        TeamMember teamMember = new TeamMember();
        teamMember.setId("114455");
        teamMember.setName("Dhvanan");
        boolean insertStatus = teamMemberDao.insert(teamMember);

        boolean deleteStatus = teamMemberDao.delete("114455");
        Assert.assertEquals(true,deleteStatus);

        try{

            TeamMember expectedTeamMember = teamMemberDao.getById("114455");

        }catch(Exception ex)
        {
            System.out.println("This ID has been already deleted");
        }
    }

    @Test
    public void testUpdate()
    {
        TeamMember teamMember = new TeamMember();
        teamMember.setName("aabbcc");
        teamMember.setId("2233");
        teamMemberDao.insert(teamMember);

        TeamMember teamMember2  = new TeamMember();
        teamMember2.setName("Adhishree Adiecha");

        boolean status = teamMemberDao.update("2233",teamMember2);
        System.out.println(status);

        TeamMember teamMember1 = teamMemberDao.getById("2233");
        System.out.println(teamMember1);

        teamMemberDao.delete("2233");
    }


    @Test
    public void testGetById()
    {
        TeamMember teamMember = new TeamMember();
        teamMember.setId("1122");
        teamMember.setName("Adhishree");
        boolean insertStatus = teamMemberDao.insert(teamMember);

        TeamMember expectedTeamMember = teamMemberDao.getById("1122");
        Assert.assertEquals(expectedTeamMember,teamMember);

        boolean deleteStatus = teamMemberDao.delete("1122");
        Assert.assertEquals(true,deleteStatus);
    }

    @Test
    public void testGetByName()
    {
        TeamMember teamMember = new TeamMember();
        teamMember.setId("8899");
        teamMember.setName("Dhvanan");
        teamMemberDao.insert(teamMember);

        TeamMember teamMember1 = new TeamMember();
        teamMember1.setId("7788");
        teamMember1.setName("Dhvanan Trivedi");
        teamMemberDao.insert(teamMember1);


        List<TeamMember> teamMembers = teamMemberDao.getByName("Dhvanan Trivedi");
        System.out.println("TEAM MEMBERS : "+teamMembers);
        Assert.assertThat(teamMembers,hasItems(teamMember,teamMember1));

        teamMemberDao.delete("8899");
        teamMemberDao.delete("7788");

    }

    @Test
    public void testGetAll()
    {
        TeamMember teamMember = new TeamMember();
        teamMember.setId("4455");
        teamMember.setName("Adhishree Adiecha");
        boolean insertStatus = teamMemberDao.insert(teamMember);
        Assert.assertEquals(true,insertStatus);

        TeamMember teamMember1 = new TeamMember();
        teamMember1.setId("5566");
        teamMember1.setName("Dhvanan Trivedi");
        boolean insertStatus1 = teamMemberDao.insert(teamMember1);
        Assert.assertEquals(true,insertStatus1);


        List<TeamMember> teamMembers = teamMemberDao.getAll();
        System.out.println(teamMembers);
        System.out.println("size of list-"+teamMembers.size());
        Assert.assertThat(teamMembers,hasItems(teamMember,teamMember1));

        teamMemberDao.delete("4455");
        teamMemberDao.delete("5566");

    }


}
