package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Classe base para todas as classes testes
public abstract class BaseTest {
    protected static WebDriver driver;
    private static final String URL_BASE = "file:///C:/Users/parai/Documents/QA/controle-de-produtos/sistema/login.html";
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.exe";
    
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterClass
    public static void encerrar(){
        driver.quit();
    }
}
