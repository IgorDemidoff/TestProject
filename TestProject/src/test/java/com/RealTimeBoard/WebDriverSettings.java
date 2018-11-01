package com.RealTimeBoard;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {

    public ChromeDriver driver;

    @Before // Используем аннотацию before для того, чтобы каждый раз перед запуском теста, использовались наши настройки
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lgorek\\Downloads\\chromedriverwin32\\chromedriver.exe"); // Указываем переменную ChromeDriver и путь до драйвера
        driver = new ChromeDriver(); // Инициализируем драйвер GoogleChrome т.к. тесты будут именно в нём
        driver.manage().window().maximize(); // Открываем окно браузера на полный экран
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Ждём 5 секунд чтобы прогрузились все элементы на странице
    }

    @After // Используем аннотацию after, каждый раз после запуска теста
    public void End() {
        driver.quit(); // Закрываем браузер после успешного выполнения теста
    }

}
