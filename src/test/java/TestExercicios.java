import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestExercicios {

    @Test
    public void exercicio01_TesteParOuImpar(){

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
}
