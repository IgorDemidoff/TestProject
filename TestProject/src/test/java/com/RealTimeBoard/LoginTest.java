package com.RealTimeBoard;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends WebDriverSettings {

    @Test // Используем фреймворк junit'а, чтобы проект понимал что метод будет тестовым
    public void LoginTest() {
        System.out.println("Тест проверки подключения к сайту\n"); // Выводим сообщение о наименовании теста
        driver.get("https://realtimeboard.com/login/"); // Открываем страницу с Log In
        String Logintitle = driver.getTitle(); // Получаем информацию от сайта и его title
        Assert.assertTrue(Logintitle.equals("Log in | RealtimeBoard")); // Сравниваем что мы дейсвтительно получили тот title как на сайте realtimeboard
    }

    @Test
    public void LoginTestButtonWithoutEmailAndPassword() {
        System.out.println("Тест проверки незаполненных форм при нажатии кнопки Log In\n");
        driver.get("https://realtimeboard.com/login/");
        String Logintitle = driver.getTitle();
        Assert.assertTrue(Logintitle.equals("Log in | RealtimeBoard"));
        WebElement LoginButton = driver.findElement(By.xpath("//button[text()='Log In']")); // Ищем элемент кнопки с Log In
        LoginButton.click(); // Нажимаем по кнопке
        String Errortext = driver.findElement(By.cssSelector(".signup__error")).getText(); // Ищем по css оформление текста с ошибкой и берем из него текст
        System.out.println(Errortext); // Выводим текст ошибки
    }

    @Test
    public void LoginTestButtonAndIncorrectEmailAndEmptyPassword() {
        System.out.println("Тест проверки заполненного некоректного email при нажатии кнопки Log In\n");
        driver.get("https://realtimeboard.com/login/");
        String Logintitle = driver.getTitle();
        Assert.assertTrue(Logintitle.equals("Log in | RealtimeBoard"));
        WebElement EmailField = driver.findElement(By.id("email"));
        EmailField.sendKeys("incorrectemail");
        WebElement LoginButton = driver.findElement(By.xpath("//button[text()='Log In']"));
        LoginButton.click();
        String Errortext = driver.findElement(By.cssSelector(".signup__error")).getText();
        System.out.println(Errortext);
    }

    @Test
    public void LoginTestButtonAndCorrectEmailAndEmptyPassword() {
        System.out.println("Тест проверки заполненного коректного email при нажатии кнопки Log In\n");
        driver.get("https://realtimeboard.com/login/");
        String Logintitle = driver.getTitle();
        Assert.assertTrue(Logintitle.equals("Log in | RealtimeBoard"));
        WebElement EmailField = driver.findElement(By.id("email")); // Ищем элемент по id email
        EmailField.sendKeys("bujhm13666@yandex.ru"); // Вписываем в поле email текст
        WebElement LoginButton = driver.findElement(By.xpath("//button[text()='Log In']"));
        LoginButton.click();
        String Errortext = driver.findElement(By.cssSelector(".signup__error")).getText();
        System.out.println(Errortext);
    }

    @Test
    public void LoginTestButtonAndPasswordAndEmptyEmail() {
        System.out.println("Тест проверки заполненного пароля и пустого email при нажатии кнопки Log In\n");
        driver.get("https://realtimeboard.com/login/");
        String Logintitle = driver.getTitle();
        Assert.assertTrue(Logintitle.equals("Log in | RealtimeBoard"));
        WebElement PasswordField = driver.findElement(By.id("password")); // Ищем элемент пароля по его id
        PasswordField.sendKeys("123"); // Вписываем пароль в поле
        WebElement LoginButton = driver.findElement(By.xpath("//button[text()='Log In']"));
        LoginButton.click();
        String Errortext = driver.findElement(By.cssSelector(".signup__error")).getText();
        System.out.println(Errortext);
    }

    @Test
    public void LoginTestButtonCorrectPasswordAndCorrectEmail() {
        System.out.println("Тест проверки корректного email и пароля при нажатии кнопки Log In и входа\n");
        driver.get("https://realtimeboard.com/login/");
        String Logintitle = driver.getTitle();
        Assert.assertTrue(Logintitle.equals("Log in | RealtimeBoard"));
        WebElement EmailField = driver.findElement(By.id("email"));
        EmailField.sendKeys("khachipuryan.anzorik228@yandex.ru");
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("Asdfg123");
        WebElement LoginButton = driver.findElement(By.xpath("//button[text()='Log In']"));
        LoginButton.click();
        String Dashboardtitle = driver.getTitle();
        Assert.assertTrue(Dashboardtitle.equals("RealtimeBoard | Online Whiteboard for Visual Collaboration")); // Проверяем что мы действительно залогинились
    }
}