import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;




@CucumberOptions(
		features = {"src/test/java/Features/demo.feature"},
		dryRun = false,
		glue = "steps",
		snippets =  SnippetType.CAMELCASE
		
		)
public class RunnerClass extends AbstractTestNGCucumberTests {

}
