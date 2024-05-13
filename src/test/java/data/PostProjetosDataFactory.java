package data;

import model.Projetos;
import model.ProjetosBuilder;
import net.datafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class PostProjetosDataFactory {

    private static final Faker FAKER = new Faker();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public static Projetos createNewProject() {
        return newProject();
    }

    private static Projetos newProject() {
        return new ProjetosBuilder()
                .name(FAKER.name().firstName())
                .leader((FAKER.name().lastName()))
                .description(FAKER.address().country())
                .endDate("2030-10-02").build();
    }

}
