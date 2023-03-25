import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue = {"steps"},plugin = { "pretty", "html:target/test-report/cucumber-reports.html" },
        monochrome = true
)
public class CucumberRunnerTest {
}
