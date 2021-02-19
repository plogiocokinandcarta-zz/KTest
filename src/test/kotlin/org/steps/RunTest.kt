package org.steps


import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith



@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/kotlin/org/features/AmazonSearch.feature"],
    plugin=["pretty",
        "html:target/report.html","json:target/cucumber"]

)

class RunTest