package org.pages


import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.NoSuchElementException;

class AmazonPage(driver: WebDriver) : BasePage(driver) {


    @FindBy(xpath =  "//*[@id='twotabsearchtextbox']")
    lateinit var inputSearch: WebElement

    @FindBy(xpath = "//span/div/div/ul/li/a[text()=\'2\']")
    lateinit var secondPage: WebElement

    @FindBy(xpath = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div/div/span/div/div")
    lateinit var thirdElement: WebElement

    @FindBy(xpath = "//*[@id='add-to-cart-button']")
    lateinit var addToCart: WebElement

    var searchItems: String = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"

    /**     *
     * @param value is the item to search      *
     */
    fun search (value: String){
        inputSearch.sendKeys(value)
        inputSearch.sendKeys(Keys.ENTER)
    }

    fun goToSecondPage(){
        secondPage.click()
    }

    fun selectThirdItem(){
        try{
            Thread.sleep(5000)
        }
        catch(e: Exception){}
        var lt : List<WebElement>  = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(searchItems))))
        lt[2].click()
    }

    fun verifyItemPurchase(): Boolean{
        val ret : Boolean
        return try{
            addToCart.click()

            true
        }catch(e : NoSuchElementException){
            false
        }

    }
}