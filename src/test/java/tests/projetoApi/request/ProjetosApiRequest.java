package tests.projetoApi.request;

import base.util.PropertieUtil;
import io.restassured.response.Response;
import model.Projetos;
import service.BaseService;

import java.io.IOException;

public class ProjetosApiRequest extends BaseService {

    private static final String BASE_URI = "baseURI";

    private static final String PATH = "/projects";

    public ProjetosApiRequest() throws IOException {
        propertiesUtil = new PropertieUtil();
    }


    public Response getAllProjects() {
        setBaseURI(BASE_URI);

        return doGetRequest(PATH);
    }

    public Response createProject(Projetos projetos) {
        setBaseURI(BASE_URI);

        return doPostRequest(PATH, projetos);
    }

}
