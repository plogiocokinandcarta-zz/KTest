package org.steps


import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.junit.jupiter.api.Assertions.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.pages.AmazonPage

var lastInstance: StepDef? = null
var driver :WebDriver ?= null
var amazonPage : AmazonPage ?= null
class StepDef : En {

    init {
        Before(){scenario: Scenario ->
            assertNotSame(this, lastInstance)
            lastInstance = this
            System.setProperty("webdriver.chrome.driver", "src/main/kotlin/org/driver/chromedriver")
            var opt: ChromeOptions  = ChromeOptions()
            opt.addArguments("start-maximized")
            driver = ChromeDriver(opt)
            driver!!.manage().window().maximize()

        }

        After(){scenario: Scenario ->
            assertSame(this, lastInstance)
            lastInstance = this
            driver!!.quit()
        }


        Given("^the user navigates to www.amazon.com$"){
           driver!!.get("https://www.amazon.com/")
           amazonPage = AmazonPage(driver!!)
        }


        And(
            "searches for {string}"
        ) { string: String? ->
            if (string != null) {
                amazonPage!!.search(string)
            }
        }

        And("navigates to the second page") {
            amazonPage!!.goToSecondPage()

        }

        And("selects the third item"){
            amazonPage!!.selectThirdItem()
        }
        Then ("the item is available for purchase") {
            assertTrue(amazonPage!!.verifyItemPurchase(),"Element is not available for purchase")

        }
    }
}