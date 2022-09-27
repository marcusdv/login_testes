package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    @FindBy(id = "email")
    public WebElement input_email;

    @FindBy(id = "senha")
    public WebElement input_senha;
    
    @FindBy(id = "btn-entrar")
    public WebElement btn_entrar;
    
    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement span_mensagem;

    /**
     * Construtor padrão para criação de uma nova instancia da pagina de login.
     * @param driver Driver da página de login.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public void preencher_email_senha_e_logar(String email, String senha){
        input_email.clear();
        input_senha.clear();
        input_email.sendKeys(email);
        input_senha.sendKeys(senha);
        efetuar_login();
    }

    // public void digitar(WebElement input, String texto){
    //     input.clear();
    //     input.sendKeys(texto + Keys.TAB);
    // }
    

    public void efetuar_login(){
        btn_entrar.click();
    }

    public String obter_mensagem(){
        return span_mensagem.getText();
    }

    // form>div.alert>span
    // form.form-login>div.alert>span
}
