package com.portfolio.portfolio.model;
/*
* Project object to transmit project data to frontend
*/
public class Project {
    private String id;
    private String name;
    private String description;
    private String url;

    public Project(String id,String name, String description, String url){
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;

    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getURL(){
        return url;
    }
    public String getID(){
        return id;
    }

}
