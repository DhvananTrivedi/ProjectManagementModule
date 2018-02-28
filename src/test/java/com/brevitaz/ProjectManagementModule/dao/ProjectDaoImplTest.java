package com.brevitaz.ProjectManagementModule.dao;

import com.brevitaz.ProjectManagementModule.model.Project;
import com.brevitaz.ProjectManagementModule.model.TeamMember;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProjectDaoImplTest {

        @Autowired
        ProjectDao projectDao;

        @Test
        public void testInsert() {
            Project project = new Project();
            project.setId("3");
            project.setName("Abc project");

            boolean insertStatus = projectDao.insert(project);
            Assert.assertEquals(true, insertStatus);

            Project expectedProject = projectDao.getById("3");
            Assert.assertEquals(expectedProject,project);

            boolean deleteStatus = projectDao.delete("3");
            Assert.assertEquals(true,deleteStatus);
        }

        @Test
        public void testDelete() {

            Project project = new Project();
            project.setId("11");
            project.setName("AAA project");

            boolean insertStatus = projectDao.insert(project);
            Assert.assertEquals(true,insertStatus);

            boolean deleteStatus = projectDao.delete("11");
            Assert.assertEquals(true, deleteStatus);

            try {

                Project expectedProject = projectDao.getById("11");
                Assert.assertEquals(true,false);
            }
            catch(NullPointerException ex)
            {
                System.out.println("This ID has been already deleted.");
                Assert.assertEquals(true,true);
            }
        }

        @Test
        public void testUpdate() {
            Project project = new Project();
            project.setId("114455");
            project.setName("abcd project");
            projectDao.insert(project);

            Project project1 = new Project();
            project1.setName("AAA project");

            boolean status = projectDao.update("114455", project1);
            System.out.println(status);

            Project project2 = projectDao.getById("114455");
            System.out.println(project2);
            Assert.assertEquals("AAA project",project2.getName());
            Assert.assertEquals("114455",project2.getId());

            projectDao.delete("114455");

        }

        @Test
        public void testGetById() {

            Project project = new Project();
            project.setId("1144");
            project.setName("BBB project");
            boolean insertStatus = projectDao.insert(project);
            Assert.assertEquals(true,insertStatus);
            System.out.println(project);

            Project expectedProject = projectDao.getById("1144");
            Assert.assertEquals(expectedProject,project);

            boolean deleteStatus = projectDao.delete("1144");
            Assert.assertEquals(true,deleteStatus);

        }


        @Test
        public void testGetAll() {

            Project project = new Project();
            project.setId("1122");
            project.setName("CCC project");
            boolean insertStatus = projectDao.insert(project);
            Assert.assertEquals(true,insertStatus);

            List<Project> projects = projectDao.getAll();
            System.out.println(projects);
            Assert.assertThat(projects, hasItems(project));

            boolean status = projectDao.delete("1122");
            Assert.assertEquals(true,status);

        }
        @Test
        public void testGetByTeamMemberId()
        {
            TeamMember teamMember = new TeamMember();
            teamMember.setId("1122");
            teamMember.setName("Adhishree Adiecha");

            TeamMember teamMember1 = new TeamMember();
            teamMember1.setId("1133");
            teamMember1.setName("Dhvanan Trivedi");

            List<TeamMember> teamMembers = new ArrayList<>();

            Project project = new Project();
            project.setId("11");
            project.setTeamMembers(teamMembers);
            boolean insertStatus = projectDao.insert(project);
            System.out.println(insertStatus);

            List<Project> projects = projectDao.getByTeamMemberId("1122");
  //          System.out.println(projects);

            for (Project p:projects) {
                Assert.assertThat(p.getTeamMembers(),hasItems(teamMember,teamMember1));
            }

        }

        @Test
        public void testGetByName() {

            Project project = new Project();
            project.setId("4455");
            project.setName("DDD project");
            boolean insertStatus = projectDao.insert(project);
            Assert.assertEquals(true,insertStatus);

            Project project1 = new Project();
            project1.setId("5566");
            project1.setName("DDD proj.");
            boolean insertStatus1 = projectDao.insert(project1);
            Assert.assertEquals(true,insertStatus1);

            List<Project> projects= projectDao.getByName("DDD");
            System.out.println("PROJECT LIST : " + projects);

            Assert.assertThat(projects,hasItems(project,project1));
    }

}
