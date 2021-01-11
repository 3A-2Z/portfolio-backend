package com.portfolio.portfolio.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import com.portfolio.portfolio.datasource.PostgresDatasource;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;
import com.portfolio.portfolio.dao.PortfolioDao;
import com.portfolio.portfolio.model.Project;
@Repository("postgres")
public class PortfolioDataAccessService implements PortfolioDao {
    private final RestTemplate restTemplate;
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    public PortfolioDataAccessService(JdbcTemplate jdbcTemplate, RestTemplateBuilder restTemplateBuilder){
        this.jdbcTemplate = jdbcTemplate;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public void getGitHubProjects() {
        String url = "https://api.github.com/users/3A-2Z/repos";
        String res = restTemplate.getForObject(url, String.class);

        
        JSONArray jsonRes = new JSONArray(res);
       for(int i = 0; i < jsonRes.length(); i++){
           JSONObject tmp = jsonRes.getJSONObject(i);
           String descript = " ";
           try { descript = tmp.getString("description");} catch(org.json.JSONException e) { descript = "null";};
           final String query = "insert into projects(id,title,descript,link) values(?,?,?,?) ON CONFLICT (id) DO UPDATE SET title = EXCLUDED.title, descript = EXCLUDED.descript, link = EXCLUDED.link;";
           Object[] params = {tmp.getInt("id"),tmp.getString("name"), descript, tmp.getString("html_url")};
           int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
           jdbcTemplate.update(query,params, types);
       }
       
        
    }
    @Override
    public ArrayList<Project> getProjects(){
        final String query = "SELECT * FROM projects";
        ArrayList<Project> projects = new ArrayList<Project>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, new Object[]{});
        for(Map<String, Object> row: rows){

            Project project = new Project((String)row.get("id"),(String)row.get("title"),(String)row.get("descript"),(String)row.get("link"));
            projects.add(project);
        }
      
        return projects;
    }

} 