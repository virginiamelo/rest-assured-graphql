import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class CountriesAPI_CountryTest {

    String queryCountry = "{\"query\":\"query country {\\n\\tcountry(code:\\\"BR\\\"){\\n    name\\n    emoji\\n    continent{\\n      code\\n      name\\n      countries{\\n        name\\n        code\\n        emoji\\n      }\\n    }\\n  }\\n}\",\"variables\":{}}";

    @Test
    public void shouldReturnStatusCode200() {

        Response response = Queries.getResponse(queryCountry);
        response.then().statusCode(Constantes.STATUS_OK);
        response.then().body("data.country.name", equalTo("Brazil"));
    }

    @Test
    public void shouldReturnErrorWithoutHeader() {

        Response response = Queries.getResponseWhitoutHeader(queryCountry);
        response.then().statusCode(Constantes.STATUS_BAD_REQUEST);
        response.then().body("html.body", equalTo("POST body missing, invalid Content-Type, or JSON object has no keys."));

    }







    // RASCUNHOS
    //response.then().body("data.country.continent.countries[0].name", equalTo("Argentina"));
    //response.then().body("data.country.continent.countries[0].name", instanceOf(String.class));

    //// String continent = response.jsonPath().get("data.country").toString();
    // //response.then().log().body();
    // response.then().assertThat().statusCode(200);
    // String continent = response.jsonPath().
    // get("data.continents[0].code");
    // System.out.println(continent);
    //System.out.println(continent);
    //response.then().log().body();
    //System.out.println(response);

}
