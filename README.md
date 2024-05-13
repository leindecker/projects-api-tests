# Projetos-Api-Tests

# Introdução

- Projeto responsável pelos testes automatizados dos microsserviços do documentado no Swagger de Testes [Swagger - Projetos](https://tranquil-cove-07655-38b519d38c2f.herokuapp.com/docs/#/Projetos/createProject)

### Tecnologias Utilizadas

* [Java](https://www.java.com/pt-BR/) - Linguagem utilizada para a escrita dos testes
* [Maven](https://maven.apache.org/) - Gerenciador de dependências
* [Junit5](https://junit.org/junit5/) - Framework de Teste utilizado no projeto
* [Rest-assured](https://rest-assured.io/) - Framework responsável por fazer chamadas em API Rest.

### Instalação / Execução dos Testes

Configurar profile no Intellij

```sh
$ Acessar o menu Run
$ Clicar em Edit Configurations
$ Abrir opção 'Junit' -> 'Runner'
$ No campo 'Environment Variables' informar "profile=local"
$ Clicar em Apply e em OK
```

Executando pelo Maven.
```sh
$ Clonar o projeto
$ Acessar a raíz do projeto ( Onde esta localizado o arquivo pom.xml)
$ Executar o comando 'mvn test'
```