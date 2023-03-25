package steps;

import io.cucumber.java.en.And;
import org.junit.Assert;
import support.RequestResponseWorld;
import utilities.CSVManager;

import java.util.*;


public class ListCatFactsSteps {

    private RequestResponseWorld requestResponseWorld;

    public ListCatFactsSteps(RequestResponseWorld requestResponseWorld) {
        this.requestResponseWorld = requestResponseWorld;
    }

    @And("^the \"([^\"]*)\" array containing \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" matches with the values in csv \"([^\"]*)\"$")
    public void verifyResponseValueList(String listName, String key1, String key2, String key3, String csvName) throws Exception {
        List<HashMap<String, String>> responseWithAllFields = requestResponseWorld.getResponse().body().jsonPath().get(listName);
        List<HashMap<String, String>> responseWithRequiredFields = CSVManager.transformResponse(responseWithAllFields, key1, key2, key3);

        List<HashMap<String, String>> expectedResponse = CSVManager.getAllCSVRecords("csv/books.csv", key1, key2, key3);
        expectedResponse.forEach(System.out::println);
        responseWithRequiredFields.forEach(System.out::println);
        Assert.assertTrue(expectedResponse.equals(responseWithRequiredFields));
    }
}


