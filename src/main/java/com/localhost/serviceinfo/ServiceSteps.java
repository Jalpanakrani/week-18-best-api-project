package com.localhost.serviceinfo;

import com.localhost.constants.categories.EndPoints;
import com.localhost.model.ServicesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ServiceSteps {
    @Step("creat service by name: {0}")
    public ValidatableResponse creatService(String name) {
       ServicesPojo servicesPojo = new ServicesPojo();
       servicesPojo.setName(name);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(servicesPojo)
                .when()
                .post(EndPoints.CREAT_SERVICE)
                .then();
    }
        @Step("getting single service by service name : {0}")
    public ValidatableResponse getSingleService(String id) {
        return SerenityRest.given().log().all()
                .pathParam("serviceID", id)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICE_BY_ID)
                .then();
        }

    @Step("Updating category information with name: {0}")
    public ValidatableResponse updateService(int serviceiD,String name){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);
        return SerenityRest.given().log().all()
                //.header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .pathParam("serviceID", serviceiD)
                .body(servicesPojo)
                .when()
                .patch(EndPoints.UPDATE_SERVICE_BY_ID)
                .then();
        }

    @Step("Deleting single service by swervice name : {0}")
    public ValidatableResponse deletSingleService(int id) {
        return SerenityRest.given().log().all()
                .pathParam("serviceID", id)
                .when()
                .delete(EndPoints.DELETE_SERVICE_BY_ID)
                .then();
    }
    @Step
    public ValidatableResponse getSingleService(int serviceId){
        return SerenityRest.given().log().all()
                .pathParam("serviceID",serviceId)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICE_BY_ID)
                .then();
    }

}
