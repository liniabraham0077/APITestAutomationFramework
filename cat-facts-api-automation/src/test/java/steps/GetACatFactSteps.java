package steps;

import io.cucumber.java.en.And;
import io.restassured.common.mapper.TypeRef;
import org.junit.Assert;
import support.RequestResponseWorld;
import utilities.CSVManager;

import java.util.HashMap;
import java.util.Map;

public class GetACatFactSteps {


    private RequestResponseWorld requestResponseWorld;

    public GetACatFactSteps(RequestResponseWorld requestResponseWorld) {
        this.requestResponseWorld = requestResponseWorld;
    }

    @And("^the get a cat fact response values for \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" matches with the value in csv \"([^\"]*)\"$")
    public void verifyResponseValue(String key1, String key2, String key3, String csvName) throws Exception {
        String responseID = requestResponseWorld.getResponse().body().jsonPath().getJsonObject(key1);
        HashMap<String, String> csvRowMap =  CSVManager.findCatFactRowFromCSV(responseID, csvName, key1, key2, key3);
        HashMap<String, String> apiResponseMapWithAllValues = requestResponseWorld.getResponse().body().as(new TypeRef<HashMap<String, String>>() {
        });
        HashMap<String, String> apiResponseMapWithRequiredValues = new HashMap<String, String>();
        for (Map.Entry val : apiResponseMapWithAllValues.entrySet()) {
            apiResponseMapWithRequiredValues.put(key1, apiResponseMapWithAllValues.get(key1));
            apiResponseMapWithRequiredValues.put(key2, apiResponseMapWithAllValues.get(key2));
            apiResponseMapWithRequiredValues.put(key3, apiResponseMapWithAllValues.get(key3));
        }
        System.out.println("requiredMap is " + apiResponseMapWithRequiredValues);
        Assert.assertTrue(csvRowMap.equals(apiResponseMapWithRequiredValues));

    }
}
