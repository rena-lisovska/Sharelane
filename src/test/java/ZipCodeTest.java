import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ZipCodeTest {

    /*
    ОР: поле принимает валидные данные, происходит переход на страницу с формой регистрации

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkZipCodeFieldWithFiveDigits() {
        // инициализируем браузер как Chrome
        WebDriver browser = new ChromeDriver();
        // определяем время ожидания элемента
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // переходим на страницу
        browser.get("https://sharelane.com/cgi-bin/register.py");
        // вводим значение 12345 в поле ZIP code
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        // нажимаем кнопку Continue
        browser.findElement(By.cssSelector("[value=Continue]")).click();

        // создаём boolean переменную, которая определяет наличие кнопки Register на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        // проверяем, что кнопка действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

    /*
    ОР: поле Zip code пустое, получаем сообщение "Oops, error on page. ZIP code should have 5 digits"

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Оставить поле Zip code пустым
    3. Нажать кнопку Continue

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkZipCodeFieldIsEmpty() {
        // инициализируем браузер как Chrome
        WebDriver browser = new ChromeDriver();
        // определяем время ожидания элемента
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // переходим на страницу
        browser.get("https://sharelane.com/cgi-bin/register.py");
        // нажимаем кнопку Continue
        browser.findElement(By.cssSelector("[value=Continue]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

    /*
    ОР: поле Zip code принимает невалидные значения (меньше или больше 5),
    получаем сообщение "Oops, error on page. ZIP code should have 5 digits"

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 4-х цифр, например, 1234
    3. Нажать кнопку Continue

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkZipCodeFieldWithFourDigits() {
        // инициализируем браузер как Chrome
        WebDriver browser = new ChromeDriver();
        // определяем время ожидания элемента
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // переходим на страницу
        browser.get("https://sharelane.com/cgi-bin/register.py");
        // вводим значение 1234 в поле ZIP code
        browser.findElement(By.name("zip_code")).sendKeys("1234");
        // нажимаем кнопку Continue
        browser.findElement(By.cssSelector("[value=Continue]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }
}
