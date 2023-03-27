/*  Step definition common for the framework */

package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import support.RequestResponseWorld;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class CommonSteps {
    private final static Logger logger = Logger.getLogger(CommonSteps.class.getName());
    private RequestResponseWorld requestResponseWorld;

    public CommonSteps(RequestResponseWorld requestResponseWorld) {
        this.requestResponseWorld = requestResponseWorld;
    }

    @Before
    public void before() {
        logger.info("<------Test started ------>");
    }

    @Given("^the base url is set as \"([^\"]*)\"$")
    public void setBaseURL(String url) {
        requestResponseWorld.setBaseURL(url);
    }

    @When("^a \"([^\"]*)\" request is made to the path \"([^\"]*)\" to list all facts$")
    public void setRequestMethod(String method, String path) {
        requestResponseWorld.setPath(path);
        String url = requestResponseWorld.getBaseURL();
        System.out.println("url is " + url);
        requestResponseWorld.setResponse(given().log().all().baseUri(requestResponseWorld.getBaseURL()).contentType("application/json")
                .when().get(requestResponseWorld.getPath()).then().log().all().extract());
    }

    @Then("^user should get the response code (.+)")
    public void getResponseCode(int responseCode) {
        Assert.assertEquals(responseCode, requestResponseWorld.getResponse().statusCode());

    }

    @After
    public void after() {
        logger.info("<------Test finished ------>");
    }

}
