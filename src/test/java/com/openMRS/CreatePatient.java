package com.openMRS;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.Payload;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class CreatePatient {
  // public String personId;


   @Test
    public static String PostPerson() {
       RestAssured.baseURI = "http://codefish.ninja/openmrs/ws/rest";
       RestAssured.basePath = "v1/person";
       PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
       authScheme.setUserName("Admin");
       authScheme.setPassword("Admin123");
       RestAssured.authentication = authScheme;


       Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)

               .body(Payload.createPerson("Valya", "NewYork", "M",
                       "2024-02-09", "IL"))
               .when()
               .post()
               .then()
               .statusCode(201)
               .extract()
               .response();
       Map<String, Object> parsedResponse = response.as(new TypeRef<Map<String, Object>>() {
       });

     String   personId = parsedResponse.get("uuid").toString();
return personId;
   }

@Test
public static String getIdentifier() {
    RestAssured.baseURI = "http://codefish.ninja/openmrs";
    Response response =
            given()
//                    .queryParam("source", "1")
//                    .queryParam("username", "admin")
//                    .queryParam("password", "Admin123")
                    .when()
                    .get("module/idgen/generateIdentifier.form?source=1&username=admin&password=Admin123")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
    Map<String, Object> parseResponce = response.as(new TypeRef<Map<String, Object>>() {
    });

    List<String> identifiersId = (List<String>) parseResponce.get("identifiers");
   // System.out.println(identifiersId.get(0));

    return  identifiersId.get(0);

}
 @Test
  public void CreatePerson() {

     //System.out.println("bara bara bara +>>>" + PostPerson());

     RestAssured.baseURI = "http://codefish.ninja/openmrs/ws/rest/v1/patient";
     PreemptiveBasicAuthScheme authScheme2 = new PreemptiveBasicAuthScheme();
     authScheme2.setUserName("Admin");
     authScheme2.setPassword("Admin123");
     RestAssured.authentication = authScheme2;


     Response response2 = given().accept(ContentType.JSON).contentType(ContentType.JSON)

             .body(Payload.createPatient(getIdentifier(),PostPerson()))
             .when()
             .post()
             .then()
             .statusCode(201)
             .extract()
             .response();


 }
   }










