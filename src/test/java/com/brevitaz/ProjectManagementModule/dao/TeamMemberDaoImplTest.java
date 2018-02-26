package com.brevitaz.ProjectManagementModule.dao;


import com.brevitaz.ProjectManagementModule.model.TeamMember;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        boolean status = teamMemberDao.insert(teamMember);
        System.out.println(status);
        Assert.assertEquals(true,status);

    }

    @Test
    public void testDelete()
    {
        boolean status = teamMemberDao.delete("8899");
        Assert.assertEquals(true,status);
    }

    @Test
    public void testUpdate()
    {
        TeamMember teamMember = new TeamMember();
        teamMember.setName("aabbcc");
        teamMember.setTeamName("ABC");
        boolean status = teamMemberDao.update("778899",teamMember);
        System.out.println(status);
        Assert.assertEquals(true,status);
    }

    @Test
    public void testGetById()
    {
        TeamMember teamMember = teamMemberDao.getById("7788");
        System.out.println(teamMember);
        Assert.assertNotNull(teamMember);
    }

    @Test
    public void testGetByName()
    {
        List<TeamMember> teamMembers = teamMemberDao.getByName("Adhishree");
        System.out.println("TEAM MEMBERS : "+teamMembers);
        Assert.assertNotNull(teamMembers);
    }

    @Test
    public void testGetAll()
    {
        List<TeamMember> teamMembers = teamMemberDao.getAll();
        System.out.println(teamMembers);
        Assert.assertNotNull(teamMembers);
    }





}
