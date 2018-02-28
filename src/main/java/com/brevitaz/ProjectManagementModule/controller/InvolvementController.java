package com.brevitaz.ProjectManagementModule.controller;


import com.brevitaz.ProjectManagementModule.dao.InvolvementDao;
import com.brevitaz.ProjectManagementModule.model.Involvement;
import com.brevitaz.ProjectManagementModule.model.SearchData;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/involvements")
public class InvolvementController {

    @Autowired
    InvolvementDao involvementDao;


    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InvolvementController.class);


    @RequestMapping(method = RequestMethod.POST)
    public boolean insert(@RequestBody Involvement involvement){
        boolean status = involvementDao.insert(involvement);
        LOGGER.info("Involvement is successfully inserted !!!");
        return status;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String id){

        boolean status = involvementDao.delete(id);
        LOGGER.info("Involvement with id "+id+" is deleted !!! ");
        return status;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public boolean update(@PathVariable String id , @RequestBody Involvement involvement){
        boolean status = involvementDao.update(id,involvement);
        LOGGER.info("Involvement with id "+id+" is successfully updated !!!");
        System.out.println(" Involvement - UPDATE !");
        return status;
    }

     @RequestMapping(method = RequestMethod.GET)
    public SearchData getAll(){

         SearchData searchData = new SearchData();
         searchData.setResponse(involvementDao.getAll());
         LOGGER.info("All involvements are listed !!!");
         return searchData;

    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Involvement geyById(@PathVariable String id){

        Involvement involvement = involvementDao.getById(id);
        LOGGER.info("Involvement with get by id "+id);
        return involvement;
    }

}
