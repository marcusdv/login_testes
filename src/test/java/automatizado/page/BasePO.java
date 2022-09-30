package automatizado.page;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe para criação das novas PageObjects
 * Todas as pages devem ser herdadas dessa classe
 */
public abstract class BasePO {

    // Driver base que será usado pelas pages
    protected WebDriver driver;


    /**
     * Construtor base para criação da PageFactory
     * @param driver
     */
    protected BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verificar_janela_atual_utilizando_titulo(String titulo){
        assertEquals(driver.getTitle(), titulo);
    }
}
