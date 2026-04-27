import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterFormTest {

    /*
    ОР: форма принимает валидные данные, пользователь зарегистрирован в системе, отображается сообщение "Account is created!"

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue
    4. Заполнить обязательные поля валидными данными: First name, Email, Password, Confirm Password
    5. Нажать кнопку Register

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkRegisterFormWithAllRequiredFields() {
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

        // переходим на страницу c формой регистрации и заполняем обязательные поля
        // в поле First name вводим значение, например, Name
        browser.findElement(By.name("first_name")).sendKeys("Name");
        // в поле Email вводим значение, например, email@domain.com
        browser.findElement(By.name("email")).sendKeys("email@domain.com");
        // в поле Password вводим значение, например, qaz123
        browser.findElement(By.name("password1")).sendKeys("qaz123");
        // в поле Confirm Password вводим значение как в Password
        browser.findElement(By.name("password2")).sendKeys("qaz123");
        // нажимаем кнопку Register
        browser.findElement(By.cssSelector("[value=Register]")).click();

        // создаём boolean переменную, которая определяет наличие confirmation_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
        // проверяем, что confirmation_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

    /*
    ОР: форма не заполнена, отображается сообщение "Oops, error on page. ...", регистрация не происходит

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue
    4. Оставить все поля формы регистрации пустыми и нажать кнопку Register

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkRegisterFormWithUnfilledRequiredFields() {
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

        // переходим на страницу c формой регистрации и нажимаем кнопку Register
        browser.findElement(By.cssSelector("[value=Register]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

    /*
    ОР: если поле First Name не заполнено, отображается сообщение "Oops, error on page. ...", регистрация не происходит

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue
    4. Заполнить валидными данными обязательные поля формы, кроме поля First Name
    5. Нажать кнопку Register

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkRegisterFormWithoutFirstName() {
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

        // переходим на страницу c формой регистрации и заполняем обязательные поля, кроме поля First Name
        // в поле Email вводим значение, например, email@domain.com
        browser.findElement(By.name("email")).sendKeys("email@domain.com");
        // в поле Password вводим значение, например, qaz123
        browser.findElement(By.name("password1")).sendKeys("qaz123");
        // в поле Confirm Password вводим значение как в Password
        browser.findElement(By.name("password2")).sendKeys("qaz123");
        // нажимаем кнопку Register
        browser.findElement(By.cssSelector("[value=Register]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

    /*
    ОР: если поле Email не заполнено, отображается сообщение "Oops, error on page. ...", регистрация не происходит

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue
    4. Заполнить валидными данными обязательные поля формы, кроме поля Email
    5. Нажать кнопку Register

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkRegisterFormWithoutEmail() {
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

        // переходим на страницу c формой регистрации и заполняем обязательные поля, кроме поля Email
        // в поле First name вводим значение, например, Name
        browser.findElement(By.name("first_name")).sendKeys("Name");
        // в поле Password вводим значение, например, qaz123
        browser.findElement(By.name("password1")).sendKeys("qaz123");
        // в поле Confirm Password вводим значение как в Password
        browser.findElement(By.name("password2")).sendKeys("qaz123");
        // нажимаем кнопку Register
        browser.findElement(By.cssSelector("[value=Register]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

    /*
    ОР: если поле Password не заполнено, отображается сообщение "Oops, error on page. ...", регистрация не происходит

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue
    4. Заполнить валидными данными обязательные поля формы, кроме поля Password
    5. Нажать кнопку Register

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkRegisterFormWithoutPassword() {
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

        // переходим на страницу c формой регистрации и заполняем обязательные поля, кроме поля Password
        // в поле First name вводим значение, например, Name
        browser.findElement(By.name("first_name")).sendKeys("Name");
        // в поле Email вводим значение, например, email@domain.com
        browser.findElement(By.name("email")).sendKeys("email@domain.com");
        // в поле Confirm Password вводим значение, например, qaz123
        browser.findElement(By.name("password2")).sendKeys("qaz123");
        // нажимаем кнопку Register
        browser.findElement(By.cssSelector("[value=Register]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

    /*
    ОР: если поле Confirm Password не заполнено, отображается сообщение "Oops, error on page. ...", регистрация не происходит

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue
    4. Заполнить валидными данными обязательные поля формы, кроме поля Confirm Password
    5. Нажать кнопку Register

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkRegisterFormWithoutConfirmPassword() {
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

        // переходим на страницу c формой регистрации и заполняем обязательные поля, кроме поля Confirm Password
        // в поле First name вводим значение, например, Name
        browser.findElement(By.name("first_name")).sendKeys("Name");
        // в поле Email вводим значение, например, email@domain.com
        browser.findElement(By.name("email")).sendKeys("email@domain.com");
        // в поле Password вводим значение, например, qaz123
        browser.findElement(By.name("password1")).sendKeys("qaz123");
        // нажимаем кнопку Register
        browser.findElement(By.cssSelector("[value=Register]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

    /*
    ОР: если данные в полях Password и Confirm Password отличаются, отображается сообщение "Oops, error on page. ...", регистрация не происходит

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue
    4. Заполнить валидными данными обязательные поля формы: First Name и Email
    5. В поля Password и Confirm Password ввести разные значения
    5. Нажать кнопку Register

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkRegisterFormWithDifferentPasswords() {
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

        // переходим на страницу c формой регистрации и заполняем обязательные поля
        // в поле First name вводим значение, например, Name
        browser.findElement(By.name("first_name")).sendKeys("Name");
        // в поле Email вводим значение, например, email@domain.com
        browser.findElement(By.name("email")).sendKeys("email@domain.com");
        // в поле Password вводим значение, например, qaz123
        browser.findElement(By.name("password1")).sendKeys("qaz123");
        // в поле Confirm Password вводим отличающееся значение от значение Password, например, wsx456
        browser.findElement(By.name("password1")).sendKeys("wsx456");
        // нажимаем кнопку Register
        browser.findElement(By.cssSelector("[value=Register]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

 /*
    ОР: если Email не содержит @ и доменной области, отображается сообщение "Oops, error on page. ...", регистрация не происходит

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue
    4. Заполнить валидными данными обязательные поля формы: First Name, Password и Confirm Password
    5. В поля Email ввести значение без @, либо без доменной области
    5. Нажать кнопку Register

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkRegisterFormWithIncorrectEmail() {
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

        // переходим на страницу c формой регистрации и заполняем обязательные поля
        // в поле First name вводим значение, например, Name
        browser.findElement(By.name("first_name")).sendKeys("Name");
        // в поле Email вводим некорректное значение без @, либо без доменной области, например, email@
        browser.findElement(By.name("email")).sendKeys("email@");
        // в поле Password вводим значение, например, qaz123
        browser.findElement(By.name("password1")).sendKeys("qaz123");
        // в поле Confirm Password вводим значение как в Password
        browser.findElement(By.name("password2")).sendKeys("qaz123");
        // нажимаем кнопку Register
        browser.findElement(By.cssSelector("[value=Register]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }

    /*
    ОР: если Password состоит менее, чем из 4-х символов, отображается сообщение "Oops, error on page. ...", регистрация не происходит

    Прекондишн: открыть браузер

    Шаги:
    1. Открыть страницу https://sharelane.com/cgi-bin/register.py
    2. Ввести в поле Zip code значение из 5 цифр, например, 12345
    3. Нажать кнопку Continue
    4. Заполнить валидными данными обязательные поля формы: First Name, Email
    5. В полях Password и Confirm Password Email указываем 3 символа, например 123
    5. Нажать кнопку Register

    Посткондишн: закрыть браузер
    */

    @Test
    public void checkRegisterFormWithThreeCharacterPassword() {
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

        // переходим на страницу c формой регистрации и заполняем обязательные поля
        // в поле First name вводим значение, например, Name
        browser.findElement(By.name("first_name")).sendKeys("Name");
        // в поле Email вводим значение, например, email@domain.com
        browser.findElement(By.name("email")).sendKeys("email@domain.com");
        // в поле Password вводим значение из 3-х символов, например, 123
        browser.findElement(By.name("password1")).sendKeys("123");
        // в поле Confirm Password вводим значение как в Password
        browser.findElement(By.name("password2")).sendKeys("123");
        // нажимаем кнопку Register
        browser.findElement(By.cssSelector("[value=Register]")).click();

        // создаём boolean переменную, которая определяет наличие error_message на странице
        boolean isDisplayed = browser.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        // проверяем, что error_message действительно есть
        Assert.assertTrue(isDisplayed);

        browser.close();
    }
}
