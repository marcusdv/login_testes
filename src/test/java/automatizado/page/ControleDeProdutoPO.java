package automatizado.page;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Elementos da página Controle de Produtos e métodos para testes.
public class ControleDeProdutoPO extends BasePO{

    @FindBy(css = ".navbar-brand")
    public WebElement logo;

    @FindBy(css = ".nav-item:first-child")
    public WebElement btn_voltar;

    @FindBy(css = "tr")
    public WebElement tabela_de_titulos;

    @FindBy(css = "#btn-adicionar")
    public WebElement btn_criar;
    
    @FindBy(css = ".modal-title")
    public WebElement titulo_janela_produto;

    @FindBy(css = "#codigo")
    public WebElement input_codigo;

    @FindBy(css = "#nome")
    public WebElement input_nome;

    @FindBy(css = "#quantidade")
    public WebElement input_quantidade;
    
    @FindBy(css = "#valor")
    public WebElement input_valor;

    @FindBy(css = "tbody>tr")
    public WebElement lista_de_produtos_ja_cadastrados;

    @FindBy(css = "#data")
    public WebElement input_data;

    @FindBy(css = "#btn-salvar")
    public WebElement btn_salvar;

    @FindBy(css = "#btn-sair")
    public WebElement btn_sair;

    @FindBy(css = ".alert>#mensagem")
    public WebElement alert_janela_produto;

    @FindBy(css = ".modal-header>.close")
    public WebElement btn_x_fechar;

    @FindBy(css = ".alert>.close")
    public WebElement btn_x_fechar_da_alert_box;

    public String[] titulos_em_pt_br = {"Código", "Nome", "Quantidade", "Valor", "Criar Data"};

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }

    /**
     * Botão criar está bugado. (Precisa dar double click pra funcionar)
     */
    public void abrir_janela_de_cadastro_de_produtos(){
        btn_criar.click();
        btn_criar.click();
    }
   
    public void verifica_se_esta_na_janela_cadastro_produto(){
        String titulo_text = titulo_janela_produto.getText();
        assertEquals("Produto", titulo_text);
    }
    
    // Na janela de ccadastrar produtos há o botão Sair e o "X". Aqui você escolhe 1 para ser clicado.
    public void fechar_janela_com_botao_escolhido(WebElement botao){
        abrir_janela_de_cadastro_de_produtos();
        verifica_se_esta_na_janela_cadastro_produto();
        botao.click();
        verificar_janela_atual_utilizando_titulo("Controle de Produtos");
    }

    public String pegar_mensagem_de_alerta_janela_produto(){
        String alerta = alert_janela_produto.getText();
        return alerta;
    }

}
