import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestExercicios {

    @Test
    public void exercicio04_TesteParOuImpar(){

        String url= "http://localhost:8080/exercicios/parOuImpar";
        String textoQueryParam = "3";

        RestAssured.given()
                .queryParams("numero",textoQueryParam)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(textoQueryParam));


    }
    @Test
    public void exercicio05_TesteCalcularSalario(){

        String pathParamSalario = "3000";
        String url= "http://localhost:8080/exercicios/calculaSalario/"+pathParamSalario;

        RestAssured.given()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Salario liquido = 2050.6516"));


    }

    @Test
    public void exercicio06_TesteCpfValido(){

        String url= "http://localhost:8080/exercicios/validarCpf";
        String cpf = "64622821001";

        RestAssured.given()
                .log().all()
                .queryParam("cpf",cpf)
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.equalTo("CPF Valido"));


    }
}
