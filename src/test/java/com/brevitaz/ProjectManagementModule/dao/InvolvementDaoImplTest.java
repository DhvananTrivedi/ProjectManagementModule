package com.brevitaz.ProjectManagementModule.dao;

import com.brevitaz.ProjectManagementModule.model.Involvement;
import com.brevitaz.ProjectManagementModule.model.Project;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvolvementDaoImplTest {

    @Autowired
    InvolvementDao involvementDao;


    @Test
    public void testInsert() {

        Involvement involvement = new Involvement();
        involvement.setId("1133");
        involvement.setInvolvementPercentage(14);
        boolean status = involvementDao.insert(involvement);
        System.out.println(status);
        Assert.assertEquals(true, status);
    }

    @Test
    public void testDelete() {
        boolean status =involvementDao.delete("1122");
        Assert.assertEquals(true, status);
    }

    @Test
    public void testUpdate() {
        Involvement involvement = new Involvement();
        involvement.setInvolvementPercentage(25);
        boolean status = involvementDao.update("1133", involvement);
        System.out.println(status);
        Assert.assertEquals(true, status);
    }

    @Test
    public void testGetById() {
        Involvement involvement = involvementDao.getById("1133");
        System.out.println(involvement);
        Assert.assertNotNull(involvement);
    }

  /*  @Test
    public void testGetByName() {
        List<Involvement> involvements = involvementDao.getByName("aabbcc");
        System.out.println(involvements);
        Assert.assertNotNull(involvements);
    }*/

    @Test
    public void testGetAll() {
        List<Involvement> involvements = involvementDao.getAll();
        System.out.println(involvements);
        Assert.assertNotNull(involvements);
    }


}
