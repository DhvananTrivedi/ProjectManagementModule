package com.brevitaz.ProjectManagementModule.dao;

import com.brevitaz.ProjectManagementModule.model.Project;
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
public class ProjectDaoImplTest {

        @Autowired
        ProjectDao projectDao;

        @Test
        public void testInsert() {
            Project project = new Project();
            project.setId("3");
            project.setName("Abc project");
            boolean status = projectDao.insert(project);
            System.out.println(status);
            Assert.assertEquals(true, status);
        }

        @Test
        public void testDelete() {
            boolean status =projectDao.delete("2");
            Assert.assertEquals(true, status);
        }

        @Test
        public void testUpdate() {
            Project project = new Project();
            project.setName("aabbcc");
            boolean status = projectDao.update("2", project);
            System.out.println(status);
            Assert.assertEquals(true, status);
        }

        @Test
        public void testGetById() {
            Project project = projectDao.getById("3");
            System.out.println(project);
            Assert.assertNotNull(project);
        }

        @Test
        public void testGetByName() {
            List<Project> projects= projectDao.getByName("aabbcc");
            System.out.println("TEAM MEMBERS : " + projects);
            Assert.assertNotNull(projects);
        }

        @Test
        public void testGetAll() {
            List<Project> projects = projectDao.getAll();
            System.out.println(projects);
            Assert.assertNotNull(projects);
        }

        @Test
        public void testGetAllByCandidateId()
        {

        }



    }
