import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Queries {

    String queryCountry = "{\"query\":\"query country {\\n\\tcountry(code:\\\"BR\\\"){\\n    name\\n    emoji\\n    continent{\\n      code\\n      name\\n      countries{\\n        name\\n        code\\n        emoji\\n      }\\n    }\\n  }\\n}\",\"variables\":{}}";


    public static Response getResponse(String queryCountry) {

        Response response = given().
                header(Constantes.CONTENT_TYPE, Constantes.CONTENT_TYPE_VALUE).
                and().body(queryCountry).
                when()
                .post(Constantes.URL);

        return response;

    }

    public static Response getResponseWhitoutHeader(String queryCountry) {

        Response response = given()
                    .body(queryCountry).
                when()
                .post(Constantes.URL);

        return response;

    }


}
