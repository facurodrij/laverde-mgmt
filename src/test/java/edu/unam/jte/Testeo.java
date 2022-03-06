package edu.unam.jte;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testeo {
    public WebDriver driver_para_Chrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        return new ChromeDriver(options);
    }

    public WebDriver driver_para_Firefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        return new FirefoxDriver(options);
    }

    public void interfaz_contiene_encabezado(WebDriver driver) {
        assertEquals(driver.getTitle(), "LaVerdeSA");
        driver.quit();
    }

    public void interfaz_contiene_pie(WebDriver driver) {
        assertEquals(driver.findElement(By.className("main-footer")).getTagName(), "footer");
        driver.quit();
    }

    public void interfaz_contiene_barra_lateral(WebDriver driver) {
        assertEquals(driver.findElement(By.className("main-sidebar")).getTagName(), "aside");
        driver.quit();
    }
}
