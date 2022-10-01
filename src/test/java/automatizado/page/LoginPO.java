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
        btn_entrar.click();
    }
    
    // Obtém o titúlo apartir do documento. Cuidado!
    public String obter_titulo_da_pagina(){
        return driver.getTitle();
    }

    public String obter_mensagem(){
        return span_mensagem.getText();
    }
}
