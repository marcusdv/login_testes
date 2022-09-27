package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{
    
    private static LoginPO login_page;

    @BeforeClass
    public static void prepararTestes(){
        login_page = new LoginPO(driver);
    }

    @Test
    public void TC001_nao_deve_efetuar_login_com_email_e_senha_vazios(){
        login_page.preencher_email_senha_e_logar("", "");
        
        String mensagem = login_page.obter_mensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC002_nao_deve_efetuar_login_sem_senha(){
        login_page.preencher_email_senha_e_logar("teste", "");

        String mensagem = login_page.obter_mensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC003_nao_deve_efetuar_login_sem_email(){
        login_page.preencher_email_senha_e_logar("", "teste");
                String mensagem = login_page.obter_mensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC004_nao_deve_efetuar_login_com_email_e_senha_invalidos(){
        login_page.preencher_email_senha_e_logar("teste", "teste");
        
        String mensagem = login_page.obter_mensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC005_nao_deve_efetuar_login_com_email_valido_e_senha_invalida(){
        login_page.preencher_email_senha_e_logar("admin@admin.com", "teste");
        
        String mensagem = login_page.obter_mensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC006_nao_deve_efetuar_login_com_email_invalido_e_senha_valida(){
        login_page.preencher_email_senha_e_logar("teste", "admin");
        
        String mensagem = login_page.obter_mensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }
    
    @Test
    public void TC007_deve_efetuar_login_com_email_e_senha_validas(){
        login_page.preencher_email_senha_e_logar("admin@admin.com", "admin@123");
    }


}
