package com.portfolio.portfolio.dao;
import com.portfolio.portfolio.model.Project;
import java.util.ArrayList;
public interface PortfolioDao {

    ArrayList<Project> getProjects();
    void getGitHubProjects();
}