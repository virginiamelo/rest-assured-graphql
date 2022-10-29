import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class CountriesAPI_LanguageTest {

    String queryLanguage = "{\"query\":\"query {\\n  languages(filter:{code:{eq:\\\"pt\\\"}}){\\n    code\\n    name\\n  }\\n}\",\"variables\":{}}";
    String queryAllLanguage = "{\"query\":\"query {\\n  languages(filter:{}){\\n    code\\n    name\\n  }\\n}\",\"variables\":{}}";


    @Test
    public void shouldReturnStatusCode200() {

        Response response = Queries.getResponse(queryLanguage);
        response.then().statusCode(Constantes.STATUS_OK);
        response.then().body("data.languages[0].name", equalTo("Portuguese"));

    }

    @Test
    public void shouldReturnAllLanguages() {

        Response response = Queries.getResponse(queryAllLanguage);
        response.then().statusCode(Constantes.STATUS_OK);
        response.then().body("data.languages.size", equalTo(114));

    }


}
