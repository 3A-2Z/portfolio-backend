package com.portfolio.portfolio.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.portfolio.portfolio.dao.PortfolioDao;
import com.portfolio.portfolio.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {
    private final PortfolioDao portfolioDao;

    @Autowired
    public PortfolioService(@Qualifier("postgres") PortfolioDao portfolioDao){
        this.portfolioDao = portfolioDao;
    } 
    /*
    * Returns stored project data
    */
    public  ArrayList<Project> getProjects() throws SQLException {
        return portfolioDao.getProjects();
        
    }
    /*
    * Retrieves projects from GitHub
    */
    public  void getGitHubProjects() throws SQLException {
        portfolioDao.getGitHubProjects();
        
    }

}
