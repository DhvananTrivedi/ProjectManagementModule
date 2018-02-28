package com.brevitaz.ProjectManagementModule.dao;

import com.brevitaz.ProjectManagementModule.model.Project;
import com.brevitaz.ProjectManagementModule.model.TeamMember;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao {


    public boolean insert(Project project);
    public boolean delete(String id);
    public Project getById(String id);
    public List<Project> getAll();
    public List<Project> getByName(String name);
    public boolean update(String id,Project project);
    public List<Project> getByTeamMemberId(String id);


    }
