package com.brevitaz.ProjectManagementModule.dao.impl;

import com.brevitaz.ProjectManagementModule.config.ClientConfig;
import com.brevitaz.ProjectManagementModule.config.ObjectMapperProvider;
import com.brevitaz.ProjectManagementModule.dao.InvolvementDao;
import com.brevitaz.ProjectManagementModule.model.Involvement;
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
public class InvolvementDaoImpl implements InvolvementDao{


    @Autowired
    private ClientConfig client;

    @Autowired
    private Environment environment;

    @Autowired
    private ObjectMapperProvider mapper;


    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InvolvementDaoImpl.class);

    private static final String TYPE = "doc";

    public boolean insert(Involvement involvement){
        IndexRequest request = new IndexRequest(
                environment.getProperty("elasticsearch.index.involvements"),TYPE,involvement.getId());

        mapper.getInstance().setSerializationInclusion(JsonInclude.Include.NON_NULL);


        try {


            String json = mapper.getInstance().writeValueAsString(involvement);
            request.source(json, XContentType.JSON);
            IndexResponse response = client.getClient().index(request);
            return ((response.status()+"").equals("CREATED")||(response.status()+"").equals("OK"));

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String id){

        DeleteRequest deleteRequest = new DeleteRequest(
                environment.getProperty("elasticsearch.index.involvements"),TYPE, id);

        try {
            DeleteResponse response = client.getClient().delete(deleteRequest);
            LOGGER.info("Delete response status -"+response.status());
            return (response.status() + "").equals("OK");

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Involvement getById(String id)
    {
        GetRequest request = new GetRequest(
                environment.getProperty("elasticsearch.index.involvements"),TYPE,id
        );

        try {
            GetResponse getResponse=client.getClient().get(request);
            Involvement involvement  = mapper.getInstance().readValue(getResponse.getSourceAsString(), Involvement.class);
            return involvement;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Involvement> getAll()
    {

        List<Involvement> involvements = new ArrayList<>();
        SearchRequest searchRequest = new SearchRequest( environment.getProperty("elasticsearch.index.involvements"));
        searchRequest.types(TYPE);

        try {
            SearchResponse searchResponse = client.getClient().search(searchRequest);
            SearchHit[] hits = searchResponse.getHits().getHits();

            Involvement involvement;
            for (SearchHit hit : hits) {
                involvement = mapper.getInstance().readValue(hit.getSourceAsString(), Involvement.class);
                involvements.add(involvement);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return involvements;
    }

    public List<Involvement> getByName(String name){
        //init
        List<Involvement> involvements = new ArrayList<>();
        SearchRequest request = new SearchRequest(
                environment.getProperty("elasticsearch.index.involvements"));
        //request.types(environment.getProperty("request.type"));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", name)
                .fuzziness(Fuzziness.AUTO)
                .prefixLength(3)
                .maxExpansions(10);
        //exec
        try {
            searchSourceBuilder.query(matchQueryBuilder);
            request.source(searchSourceBuilder);
            SearchResponse response = client.getClient().search(request);
            SearchHits hits = response.getHits();
            for (SearchHit hit : hits) {

                Involvement involvement = mapper.getInstance().readValue(hit.getSourceAsString(),Involvement.class);
                System.out.println(involvement);
                involvements.add(involvement);
            }
        }
        catch(IOException ioE){
            System.out.println(ioE);
            return null;
        }
        return involvements;
    }

    public boolean update(String id,Involvement involvement){

        // init
        UpdateRequest request = new UpdateRequest(
                environment.getProperty("elasticsearch.index.involvements"),TYPE,id);
        mapper.getInstance().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //exec
        try {

            String json = mapper.getInstance().writeValueAsString(involvement);
            request.doc(json,XContentType.JSON);
            UpdateResponse response = client.getClient().update(request);
            return (""+response.status()).equals("OK");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}
