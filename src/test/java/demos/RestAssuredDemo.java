package demos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredDemo {
    @Test
    public void restAssuredTest() {
        String body = """
                {
                    "username" : "admin",
                    "password" : "password123"
                }
                """;
        RestAssured.
        given()
                .header("Content-Type", "application/json")
                .body(body)
                .log().all().
        when()
                .post("https://restful-booker.herokuapp.com/auth")
                        .
        then()
                .statusCode(200).
        and().
                log().body();
    }

    @Test
    public void restAssuredTestCreateBooking() {
        String body = """
                {
                    "firstname" : "Mahmoud",
                    "lastname" : "ElSharkawy",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2024-01-01",
                        "checkout" : "2025-01-01"
                    },
                    "additionalneeds" : "IceCream"
                }
                """;
        RestAssured.
                given()
                .contentType(ContentType.JSON)
                .body(body)
                .log().all().
                when()
                .post("https://restful-booker.herokuapp.com/booking")
                        .
                then()
                .statusCode(200).body("booking.firstname", CoreMatchers.equalTo("Mahmoud")).
                and().
                log().body();
    }

    @Test
    public void restAssuredTestGetBooking() {
        RestAssured.
                given()
                .header("Accept", "application/json")
                .log().all().
                when()
                .get("https://restful-booker.herokuapp.com/booking/906").
                then()
                .statusCode(200).body("firstname", CoreMatchers.equalTo("Mahmoud")).
                and().
                log().body();
    }

    @Test
    public void restAssuredTestGetBookingDynamic() {
        ///////////// Create Booking
        Response createBooking = createBooking("Hany", "Mohamed");
        String bookingid = createBooking.body().jsonPath().get("bookingid").toString();


        //////////// Get Booking by id
        Response getBookingResponse = RestAssured.
                given()
                .header("Accept", "application/json")
                .pathParam("bookingid", bookingid)
                .log().all().
                when()
                .get("https://restful-booker.herokuapp.com/booking/{bookingid}").
                then()
                .statusCode(200).
                and().
                log().body().extract().response();

        String firstName = getBookingResponse.body().jsonPath().get("firstname").toString();
        Assert.assertEquals(firstName, "Hany");
    }




    private Response createBooking(String firstName, String lastName) {
        String body = """
                {
                    "firstname" : "{FIRST_NAME}",
                    "lastname" : "{LAST_NAME}",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2024-01-01",
                        "checkout" : "2025-01-01"
                    },
                    "additionalneeds" : "IceCream"
                }
                """
                .replace("{FIRST_NAME}", firstName)
                .replace("{LAST_NAME}", lastName);
        return RestAssured.
                given()
                .contentType(ContentType.JSON)
                .body(body)
                .log().all().
                when()
                .post("https://restful-booker.herokuapp.com/booking").
                then()
                .statusCode(200).
                and().
                log().body().extract().response();
    }

}
