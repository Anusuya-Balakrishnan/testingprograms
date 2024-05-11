import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;




@CucumberOptions(
		features = {"src/test/java/Features/demo.feature"},
		dryRun = false,
		glue = {"steps","hooks"},
		
		snippets =  SnippetType.CAMELCASE,
		plugin = {"pretty","html:report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				
		
		)
public class RunnerClass extends AbstractTestNGCucumberTests {

}
