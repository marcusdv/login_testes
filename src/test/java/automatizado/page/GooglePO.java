package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{

    @FindBy(name = "q")
    public WebElement input_pesquisa;

    @FindBy(id = "result-stats")
    public WebElement div_resultado_pesquisa;

    /**
     * Construtor para criação da página do google.
     * @param driver
     */
    public GooglePO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    // pesquisa através de texto e da enter.
    public void pesquisar(String texto){
        input_pesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Método que retorna o resultado aproximado da pesquisa.
     * @return retorna o número de pesquisa em String
     */
    public String obter_resultados_pesquisa(){
        return div_resultado_pesquisa.getText();
    }
}
