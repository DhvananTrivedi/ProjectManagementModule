package com.brevitaz.ProjectManagementModule.dao;

import com.brevitaz.ProjectManagementModule.model.Involvement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvolvementDao
{

    public boolean insert(Involvement involvement);
    public boolean delete(String id);
    public Involvement getById(String id);
    public List<Involvement> getAll();
    public List<Involvement> getByName(String name);
    public boolean update(String id,Involvement involvement);



    }
