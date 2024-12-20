package Tip_Top.Tip_Top;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import io.cucumber.junit.*;



@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\java\\Features\\TipTop.feature"},
tags = "@vaibhav",
glue = {"Step_Def"},
plugin = {"pretty",
		"html:target/report/cucumber.html", "json:target/report/cucumber.json"}
)

public class Test_Runner {

}
