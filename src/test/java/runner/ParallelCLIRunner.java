  
package runner;

import org.junit.Test;

import cucumber.api.cli.Main;

public class ParallelCLIRunner {
	
	@Test
	public void test() {
		Main.main(new String[]{
				"--threads", "2", 
//				"-p","pretty", 
//				"-p", "html:target/cucumber-report", 
				"-p", "json:target/cucumber-report/Cucumber.json", 
//				"-p", "junit:target/cucumber-report/Cucumber.xml", 
				"--glue", "steps", 
				"-m", "--monochrome", 
				"-t", "@tag", 
				"src/main/resources/features"
		});
	}
	
}