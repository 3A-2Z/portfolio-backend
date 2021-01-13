package com.portfolio.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.SQLException;
import java.util.Date;

import com.portfolio.portfolio.service.PortfolioService;

@SpringBootApplication
public class PortfolioApplication {
	private final PortfolioService portfolioService;

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);

	}

	@Autowired
	public PortfolioApplication(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
	}
	/*
	* Makes call to GitHub API every hour to retrieve new and updated projects
	*/
	@Scheduled(initialDelay = 1000L, fixedDelayString = "PT1H")
	void Job() throws InterruptedException, SQLException {
		
		portfolioService.getGitHubProjects();
		System.out.println("Projects Database updated on " + new Date());

	}

}

