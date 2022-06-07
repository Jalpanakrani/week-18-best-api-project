package com.localhost.storeinfo;

import com.localhost.constants.categories.EndPoints;
import com.localhost.model.CategoryPojo;
import com.localhost.model.StorePojo;
import cucumber.api.java.gl.E;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import jnr.ffi.Address;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StoreSteps {
    @Step("creat store by name: {0} ,type: {1},address {2},address2{3},city {4},stste {5},zip {6},lat{7}," +
            "lng{8},hours{9}")
    public ValidatableResponse creatStore(String name, String type, String address, String address2, String city,
                                          String state, String zip, int lat, int lag, String hours) {
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lag);
        storePojo.setHours(hours);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post(EndPoints.CREAT_STORE)
                .then();
    }

    @Step
    public ValidatableResponse getStoreById(int storeId) {

        return SerenityRest.given().log().all()
                .pathParam("storeID", storeId)
                .when()
                .get(EndPoints.GET_SINGLE_STORE_BY_ID)
                .then();
    }

    @Step("updating store information by name: {0} ,type: {1},address {2},address2{3},city {4},stste {5},zip {6},lat{7}," +
            "lng{8},hours{9}")
    public ValidatableResponse updateStoreDetail(int storeId, String name, String type, String address, String address2, String city, String state, String zip,
                                                 int lat, int lng, String hours) {
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("storeID", storeId)
                .body(storePojo)
                .when()
                .patch(EndPoints.UPDATE_STORE_BY_ID)
                .then();}

        @Step("Deleting store information with storeId: {0}")
        public ValidatableResponse deletStore(int StoreId){

            return SerenityRest.given().log().all()
                    .pathParam("storeID", StoreId)
                    .when()
                    .delete(EndPoints.DELETE_STORE_BY_ID)
                    .then();

        }
    }
