package com.localhost.categoriesinfo;

import com.localhost.constants.categories.EndPoints;
import com.localhost.model.CategoryPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CategorySteps {
    @Step("creat category by name: {0} ,id : {1}")
    public ValidatableResponse creatCategory(String name, String id) {
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setName(name);
        categoryPojo.setId(id);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(categoryPojo)
                .when()
                .post(EndPoints.CREAT_CATEGORIES)
                .then();
    }

    @Step("getting single category by category id : {0}")
    public ValidatableResponse getSingleCategory(String id) {
        return SerenityRest.given().log().all()
                .pathParam("categoryID", id)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES_BY_ID)
                .then();
    }

    @Step("Updating category information with name: {0} ,id : {1}")
    public ValidatableResponse updateCategory(String name, String id) {
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setName(name);
        categoryPojo.setId(id);
        return SerenityRest.given().log().all()
                //.header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .pathParam("categoryID", id)
                .body(categoryPojo)
                .when()
                .put(EndPoints.UPDATE_CATEGORY_BY_ID)
                .then();
    }

    @Step("Deleting single category by category id : {0}")
    public ValidatableResponse deletSingleCategory(String id) {
        return SerenityRest.given().log().all()
                .pathParam("categoryID", id)
                .when()
                .delete(EndPoints.DELETE_CATEGORY_BY_ID)
                .then();
    }
}