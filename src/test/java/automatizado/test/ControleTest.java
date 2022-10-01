package automatizado.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.builders.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;
import java.lang.Character;

public class ControleTest extends BaseTest{

    private static ControleDeProdutoPO controle_page;
    private static LoginPO login_page;

    @BeforeClass
    public static void prepararTestes(){
        controle_page = new ControleDeProdutoPO(driver);
        login_page = new LoginPO(driver);
        login_page.preencher_email_senha_e_logar("admin@admin.com", "admin@123");
        login_page.verificar_janela_atual_utilizando_titulo("Controle de Produtos");
    }
    
    @Test
    public void TC001_deve_manter_na_pagina_ao_clicar_na_logo(){
        controle_page.logo.click();
        login_page.verificar_janela_atual_utilizando_titulo("Controle de Produtos");
    }

    @Test
    public void TC002_deve_ir_a_tela_de_login_ao_clicar_em_voltar(){
        controle_page.btn_voltar.click();
        assertEquals(true, login_page.btn_entrar.isDisplayed());
    }

    @Test
    public void TC003_deve_trazer_na_tabela_os_ultimos_produtos_cadastrados(){
        controle_page.lista_de_produtos_ja_cadastrados.isDisplayed();
    }
    /***
     * Pega a tabela de titulos e transforma em uma Array.
     * Itera pela array verificando:
     *      1. Se a primeira palavra de cada elemento está em maiúsculo.
     *      2. Se estão em português verificando os titulos da página com uma array títulos escritos em pt-br na classe ControleDeProdutoPO.java.
     * 
     *  ERROS
     *  Não está capitalizada, náo está padronizada em pt-br.
     */
    @Test
    public void TC004_deve_ter_o_titulo_da_tabela_padronizado_em_pt_br_capitalizadas(){
        String[] titulos = controle_page.tabela_de_titulos.getText().split(" ");
        for(int x = 0; x < titulos.length; x++){
            System.out.print(titulos[x].charAt(0));
            assertEquals(controle_page.titulos_em_pt_br[x], titulos[x]);
            assertTrue(Character.isUpperCase(titulos[x].charAt(0)));
        }
    }
    
    /**
     * Botão criar está bugado. (Precisa dar double click pra funcionar)
     */
    @Test
    public void TC005_deve_abrir_janela_cadastro_ao_clicar__no_btn_criar(){
        controle_page.abrir_janela_de_cadastro_de_produtos();
        controle_page.verifica_se_esta_na_janela_cadastro_produto();
    }

    @Test
    public void TC006_deve_fechar_janela_de_cadastro_ao_clicar_botao_x_fechar(){
        controle_page.fechar_janela_com_botao_escolhido(controle_page.btn_x_fechar);
    }

    @Test
    public void TC007_deve_fechar_janela_de_cadastro_ao_clicar_botao_sair(){
        controle_page.fechar_janela_com_botao_escolhido(controle_page.btn_sair);
    }

    /**
     * Tentei testar com dois métodos, o comentado é com um loop 
     * e o outro é utilizando uma classe builder
     */
    @Test
    public void TC008_deve_mostrar_mensagem_ao_tentar_salvar_produto_sem_preencher_campos(){
        controle_page.abrir_janela_de_cadastro_de_produtos();
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
    
        // Array com valores preenchidos para os campos de cadastro de produtos (Código, Nome, Quantidade, Valor, Data)
        // A cada loop o valor de um elemento do array é substituído por ""
        // Depois é verificada a mensagem de erro por campo vazio, um de cada vez.
        // for(int x = 0; x < 5; x++){
        //     String[] campos_preenchidos = {"29330", "Lápis", "23", "1,00", "30092022"};
        //     campos_preenchidos[x] = "";
        //     controle_page.cadastrar_um_produto(campos_preenchidos);
        //     String alerta = controle_page.pegar_mensagem_de_alerta_janela_produto();
        //     assertEquals("Todos os campos são obrigatórios para o cadastro!", alerta);
        // }

        // Utilizando builder
        ProdutoBuilder sem_codigo = new ProdutoBuilder(controle_page);
        ProdutoBuilder sem_nome = new ProdutoBuilder(controle_page);
        ProdutoBuilder sem_quantidade = new ProdutoBuilder(controle_page);
        ProdutoBuilder sem_valor = new ProdutoBuilder(controle_page);
        ProdutoBuilder sem_data = new ProdutoBuilder(controle_page);
        
        sem_codigo
        .adicionar_codigo("")
        .builder();
        String alerta = controle_page.pegar_mensagem_de_alerta_janela_produto();
        assertEquals(mensagem, alerta);

        sem_nome
        .adicionar_nome("")
        .builder();
        alerta = controle_page.pegar_mensagem_de_alerta_janela_produto();
        assertEquals(mensagem, alerta);

        sem_quantidade
        .adicionar_quantidade(null)
        .builder();
        alerta = controle_page.pegar_mensagem_de_alerta_janela_produto();
        assertEquals(mensagem, alerta);

        sem_valor
        .adicionar_valor(null)
        .builder();
        alerta = controle_page.pegar_mensagem_de_alerta_janela_produto();
        assertEquals(mensagem, alerta);

        sem_data
        .adicionar_data("")
        .builder();
        alerta = controle_page.pegar_mensagem_de_alerta_janela_produto();
        assertEquals(mensagem, alerta);
    }
    /**
     * Erro
     * Botão não está fechando a janela.
     */
    @Test
    public void TC008_deve_fechar_alert_box_ao_clicar__x_da_alert_box(){
        String alerta = controle_page.pegar_mensagem_de_alerta_janela_produto();
        controle_page.btn_x_fechar_da_alert_box.click();
        assertNotEquals("Todos os campos são obrigatórios para o cadastro!", alerta);
    }


}
