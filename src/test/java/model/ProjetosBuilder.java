package model;

public class ProjetosBuilder {

    private String name;
    private String leader;
    private String description;
    private String endDate;

    public ProjetosBuilder name(String name) {
        this.name = name;

        return this;
    }

    public ProjetosBuilder leader(String leader) {
        this.leader = leader;

        return this;
    }

    public ProjetosBuilder description(String description) {
        this.description = description;

        return this;
    }

    public ProjetosBuilder endDate(String endDate) {
        this.endDate = endDate;

        return this;
    }

    public Projetos build() {
        return new Projetos(name, leader, description, endDate);
    }

}
