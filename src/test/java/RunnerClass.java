import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;




@CucumberOptions(
		features = {"src/test/java/Features"},
		dryRun = false,
		glue = "steps",
		tags = "@Smoke and @sanity",
		snippets =  SnippetType.CAMELCASE
		
		)
public class RunnerClass extends AbstractTestNGCucumberTests {

}
