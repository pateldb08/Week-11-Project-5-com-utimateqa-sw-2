package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before //JUnit Annotation which will run before every Test
    public void setBaseUrl(){
        openBrowser(baseUrl);
    }
    @After    //JUnit Annotation which will run after every Test
    public void tearDown(){
        closeBrowser();
    }
    @Test
    public void varifyuserShouldNavigateToLoginPageSuccessfully(){
        // Find Signin link and click on signin link
        WebElement signinlink = driver.findElement(By.linkText("Sign In"));
        signinlink.click();;
        // Varify the text 'Welcome Back!'
        String expectedMessage = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.className("page__heading"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not redirected to login page" , expectedMessage, actualMessage); // Validating expected and actual message
   }
   @Test
    public void verifyTheErrorMessage(){
       // Find Signin link and click on signin link
       WebElement signinlink = driver.findElement(By.linkText("Sign In"));
       signinlink.click();
       //Find Username Field and type the username
       WebElement userName = driver.findElement(By.id("user[email]"));
       userName.sendKeys("abc@def.com");
       //Find Password Field and type the password
       WebElement password = driver.findElement(By.id("user[password]"));
       password.sendKeys("123456");
       // Find Login button field and click on it
       WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
       loginbtn.click();
       //Verify the error message
       String expectedMessage = "Invalid email or password.";
       WebElement actualTextMessage = driver.findElement(By.className("form-error__list-item"));
       String actualMessage = actualTextMessage.getText();
       Assert.assertEquals("Valid email and password", expectedMessage,actualMessage);


   }





}
