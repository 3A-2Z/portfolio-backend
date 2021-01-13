package com.portfolio.portfolio.api;

import java.sql.SQLException;
import java.util.ArrayList;
import com.portfolio.portfolio.model.Project;
import com.portfolio.portfolio.service.PortfolioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortoflioController {
    private final PortfolioService portfolioService;

    @Autowired
    public PortoflioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }
     /*
    * for passing health check in aws
    */
    
    @GetMapping("/")
    public String awsHealthCheck(){
       return "app is running just fine";    
    } 
    /*
    *returns all project metadate from database
    */
    @CrossOrigin("http://azizamino.com")
    @GetMapping("/git/proj")
    public ArrayList<Project> getProjects() throws SQLException {
        return portfolioService.getProjects();

    }


}
