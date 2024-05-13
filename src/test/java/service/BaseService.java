package service;

import base.RequestManager;
import base.util.PropertieUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected PropertieUtil propertiesUtil;

    public void setBaseURI(String baseURI)  {
        RequestManager.shared().setBaseURI(propertiesUtil.getPropertyByName(baseURI));
    }

    public Response doGetRequest(String resource) {
        return given()
                .spec(RequestManager.shared().getRequest())
                .contentType(ContentType.JSON)
                .when()
                .get(resource);
    }

    public Response doPostRequest(String resource, Object body) {
        return given().log().all()
                .spec(RequestManager.shared().getRequest())
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(resource);
    }

}
