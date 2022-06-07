package com.localhost.categoriesinfo;

import com.localhost.testbase.TestBase;
import com.localhost.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class CategoriesCurdInfo extends TestBase {

    static String name = "Swaminarayan" + TestUtils.getRandomValue();
    static String id = "01" + TestUtils.getRandomValue();


    @Steps
    CategorySteps categorySteps;

    @Title("This will creat categories")
    @Test
    public void test001() {

        ValidatableResponse response = categorySteps.creatCategory(name , id);
        response.log().all().statusCode(201);
    }
    @Title("This will fatch single category")
    @Test
    public void test002() {

        ValidatableResponse response = categorySteps.getSingleCategory(id);
        response.log().all().statusCode(200);
    }
    @Title("This will update category")
    @Test
    public void test003() {
        name = name + "updated";
        ValidatableResponse response = categorySteps.updateCategory(name, id);
        response.log().all().statusCode(200);
        ValidatableResponse response1 = categorySteps.getSingleCategory(id);
        response1.log().all().statusCode(200);}


    @Title("This will delete category")
    @Test
    public void test004() {

        ValidatableResponse response =categorySteps.deletSingleCategory(id);
        response.log().all().statusCode(200);

        ValidatableResponse response1 =categorySteps.getSingleCategory(id);
        response1.log().all().statusCode(404);
    }
}

