package org.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.PageFactory
import java.time.Duration

abstract class BasePage(protected val driver:WebDriver ) {

    protected val wait :WebDriverWait

    init {
        PageFactory.initElements(driver, this)
        wait= WebDriverWait(driver, Duration.ofSeconds(5))
    }


}