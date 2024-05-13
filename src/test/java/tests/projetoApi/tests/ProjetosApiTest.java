package tests.projetoApi.tests;

import base.Hooks;
import base.RequestManager;
import base.util.FileUtil;
import data.PostProjetosDataFactory;
import model.Projetos;
import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import tests.projetoApi.request.ProjetosApiRequest;

import java.io.File;
import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class ProjetosApiTest extends Hooks {

    private final ProjetosApiRequest projetosApiRequest;

    public ProjetosApiTest() throws IOException {
        projetosApiRequest = new ProjetosApiRequest();
    }

    @Test
    @DisplayName("Teste Projetos")
    @Tags({@Tag("projetos"), @Tag("critical")})
    public void consultaProjetos() {
        RequestManager.shared().setResponse(projetosApiRequest.getAllProjects());
        Assertions.assertEquals(OK.value(), RequestManager.shared().getResponse().statusCode());
    }

    @Test
    @DisplayName("Teste Projetos")
    @Tags({@Tag("projetos"), @Tag("critical")})
    public void criaProjeto() {
        Projetos projetos = PostProjetosDataFactory.createNewProject();
        RequestManager.shared().setResponse(projetosApiRequest.createProject(projetos));
        System.out.println(RequestManager.shared().getResponse().getBody().asString());
        Assertions.assertEquals(CREATED.value(), RequestManager.shared().getResponse().statusCode());
        RequestManager.shared().getResponse().then()
                .body(matchesJsonSchema(new File(FileUtil.getContractsBasePath(
                        "projetoApi", "projetoCriadoResponse"))));
    }


}
