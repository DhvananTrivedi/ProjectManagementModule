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
import static org.hamcrest.CoreMatchers.hasItems;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvolvementDaoImplTest {

    @Autowired
    InvolvementDao involvementDao;

    @Test
    public void testInsert() {

        Involvement involvement = new Involvement();
        involvement.setId("1212");
        involvement.setInvolvementPercentage(25);

        boolean status = involvementDao.insert(involvement);
        Assert.assertEquals(true, status);

        Involvement expectedInvolvement = involvementDao.getById("1212");
        Assert.assertEquals(expectedInvolvement,involvement);

        boolean status1 = involvementDao.delete("1212");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void testDelete() {
        Involvement involvement = new Involvement();
        involvement.setId("1211");
        involvement.setInvolvementPercentage(20);
        boolean status = involvementDao.insert(involvement);

        boolean status1 =involvementDao.delete("1211");
        Assert.assertEquals(true, status1);

        try{
            Involvement inv = involvementDao.getById("1211");
            Assert.assertEquals(true,false);
        }
        catch(NullPointerException ex)
        {
            System.out.println("Id has been already deleted");
            Assert.assertEquals(true,true);
        }
    }

    @Test
    public void testUpdate() {
        Involvement involvement = new Involvement();
        involvement.setId("1144");
        involvement.setInvolvementPercentage(25);

        boolean status = involvementDao.insert(involvement);
        System.out.println(involvement);

        Involvement involvement1 = new Involvement();
        involvement1.setInvolvementPercentage(30);
        boolean status1 = involvementDao.update("1144", involvement1);
        System.out.println(involvement1);
        Assert.assertEquals(true,status1);

        Involvement involvement2 = involvementDao.getById("1144");
        System.out.println(involvement2);
        Assert.assertEquals("1144",involvement2.getId());
        Assert.assertEquals(30,involvement2.getInvolvementPercentage());
        boolean status2 = involvementDao.delete("1144");
        Assert.assertEquals(true,status2);
    }

    @Test
    public void testGetById() {
        Involvement involvement = new Involvement();
        involvement.setId("1122");
        involvement.setInvolvementPercentage(20);
        boolean status = involvementDao.insert(involvement);

        Involvement involvement1 = involvementDao.getById("1122");
        Assert.assertEquals(involvement,involvement1);
       /*
        Assert.assertEquals("1122",involvement1.getId());
        Assert.assertEquals(20,involvement1.getInvolvementPercentage());
        */
        boolean status1 = involvementDao.delete("1122");

        Assert.assertEquals(true,status1);
    }


    @Test
    public void testGetAll() {

        Involvement involvement = new Involvement();
        involvement.setId("14141515");
        involvement.setInvolvementPercentage(10);
        involvementDao.insert(involvement);

        Involvement involvement1 = new Involvement();
        involvement1.setId("15151616");
        involvement1.setInvolvementPercentage(15);
        involvementDao.insert(involvement1);

        List<Involvement> involvements = involvementDao.getAll();
        System.out.println(involvements);

        Assert.assertThat(involvements, hasItems(involvement,involvement1));
//        Assert.assertThat(involvements, containsInAnyOrder(involvement1,involvement));

        Involvement involvement11 = involvementDao.getById("14141515");
        Assert.assertEquals("14141515",involvement11.getId());

        Involvement involvement22 = involvementDao.getById("15151616");
        Assert.assertEquals("15151616",involvement22.getId());

        boolean status = involvementDao.delete("14141515");
        Assert.assertEquals(true,status);

        boolean status1 = involvementDao.delete("15151616");
        Assert.assertEquals(true,status1);
    }

}
