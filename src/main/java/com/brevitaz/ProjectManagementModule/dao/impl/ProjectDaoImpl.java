package com.brevitaz.ProjectManagementModule.dao.impl;

import com.brevitaz.ProjectManagementModule.dao.ProjectDao;
import com.brevitaz.ProjectManagementModule.model.Project;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {


    @Autowired
    RestHighLevelClient client;

    @Autowired
    Environment environment;

    private ObjectMapper mapper = new ObjectMapper();

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProjectDaoImpl.class);


    public boolean insert(Project project){
        IndexRequest request = new IndexRequest(
                environment.getProperty("elasticsearch.index.projects"),environment.getProperty("elasticsearch.type.doc"),project.getId()
        );

        //exec
        try {

            String json = mapper.writeValueAsString(project);
            request.source(json, XContentType.JSON);
            IndexResponse response = client.index(request);
            return ((response.status()+"").equals("CREATED")||(response.status()+"").equals("OK"));

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id){

        //init
        DeleteRequest deleteRequest = new DeleteRequest(
                environment.getProperty("elasticsearch.index.projects"), environment.getProperty("elasticsearch.type.doc"), id);

        try {
            DeleteResponse response = client.delete(deleteRequest);
            LOGGER.info("Delete response status -"+response.status());
            return (response.status() + "").equals("OK");

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    public Project getById(String id)
    {
        GetRequest request = new GetRequest(
                environment.getProperty("elasticsearch.index.projects"),environment.getProperty("elasticsearch.type.doc"),id
        );

        try {
            GetResponse getResponse=client.get(request);
            Project project  = mapper.readValue(getResponse.getSourceAsString(), Project.class);
            return project;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Project> getAll()
    {

        List<Project> projects = new ArrayList<>();
        SearchRequest searchRequest = new SearchRequest( environment.getProperty("elasticsearch.index.projects"));
        searchRequest.types(environment.getProperty("elasticsearch.type.doc"));

        try {
            SearchResponse searchResponse = client.search(searchRequest);
            SearchHit[] hits = searchResponse.getHits().getHits();

            Project project;
            for (SearchHit hit : hits) {
                project = mapper.readValue(hit.getSourceAsString(), Project.class);
                projects.add(project);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return projects;
    }

    public List<Project> getByName(String name){
        ///init
        List<Project> projects = new ArrayList<>();
        SearchRequest request = new SearchRequest(
                environment.getProperty("elasticsearch.index.projects"));
        ///request.types(environment.getProperty("request.type"));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", name)
                .fuzziness(Fuzziness.AUTO)
                .prefixLength(3)
                .maxExpansions(10);
        //exec
        try {
            searchSourceBuilder.query(matchQueryBuilder);
            request.source(searchSourceBuilder);
            SearchResponse response = client.search(request);
            SearchHits hits = response.getHits();
            for (SearchHit hit : hits) {
                Project project = mapper.readValue(hit.getSourceAsString(), Project.class);
                System.out.println(project);
                projects.add(project);
            }
        }
        catch(IOException ioE){
            System.out.println(ioE);
            return null;
        }
        return projects;
    }

    public boolean update(String id,Project project){

        // init
        UpdateRequest request = new UpdateRequest(
                environment.getProperty("elasticsearch.index.projects"),environment.getProperty("elasticsearch.type.doc"),id);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //exec
        try {

            System.out.println("HELLO");
            String json = mapper.writeValueAsString(project);
            request.doc(json,XContentType.JSON);
            UpdateResponse response = client.update(request);
            return (""+response.status()).equals("OK");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }





}
