package testrun;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/loginpage.feature",
                                  glue="stepdef",
                                tags="@ExecelReading"
                           //dryrun="true"     
                                )

public class testrun extends AbstractTestNGCucumberTests
{
	 
	
}
