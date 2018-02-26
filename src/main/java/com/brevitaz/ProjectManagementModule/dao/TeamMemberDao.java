package com.brevitaz.ProjectManagementModule.dao;

import com.brevitaz.ProjectManagementModule.model.TeamLeader;
import com.brevitaz.ProjectManagementModule.model.TeamMember;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberDao {


    public boolean insert(TeamMember teamMember);
    public boolean delete(String id);
    public TeamMember getById(String id);
    public List<TeamMember> getAll();
    public List<TeamMember> getByName(String name);
    public boolean update(String id,TeamMember teamMember);


}


