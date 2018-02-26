package com.brevitaz.ProjectManagementModule.dao;

import com.brevitaz.ProjectManagementModule.model.TeamLeader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamLeaderDao {

    public boolean insert(TeamLeader teamLeader);
    public boolean delete(String id);
    public TeamLeader getById(String id);
    public List<TeamLeader> getAll();
    public List<TeamLeader> getByName(String name);
    public boolean update(String id,TeamLeader teamLeader);

}
