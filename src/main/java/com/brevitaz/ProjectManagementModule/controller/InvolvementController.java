package com.brevitaz.ProjectManagementModule.controller;


import com.brevitaz.ProjectManagementModule.dao.InvolvementDao;
import com.brevitaz.ProjectManagementModule.model.Involvement;
import com.brevitaz.ProjectManagementModule.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/involvements")
public class InvolvementController {

    @Autowired
    InvolvementDao involvementDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean insert(@RequestBody Involvement involvement){
        boolean status = involvementDao.insert(involvement);
        System.out.println(" Involvement - POST !");
        return status;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String id){

        boolean status = involvementDao.delete(id);
        System.out.println(" Involvement - DELETE !");
        return status;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public boolean update(@PathVariable String id , @RequestBody Involvement involvement){
        boolean status = involvementDao.update(id,involvement);
        System.out.println(" Involvement - UPDATE !");
        return status;
    }

     @RequestMapping(method = RequestMethod.GET)
    public List<Involvement> getAll(){

        List<Involvement> involvements = involvementDao.getAll();
        System.out.println(" Involvement - GET !");
        return involvements;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Involvement geyById(@PathVariable String id){

        Involvement involvement = involvementDao.getById(id);
        System.out.println(" Involvement - GET BY ID!");
        return involvement;
    }

}
