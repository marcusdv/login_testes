package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.page.GooglePO;


public class GoogleTest extends BaseTest{

    private static GooglePO google_page;

    @BeforeClass 
    public static void preparar_testes(){
        driver.get("https://www.google.com/");
        google_page = new GooglePO(driver);
    }

    @Test
    public void TCC001_deve_pesquisar_no_google_batata_frita(){
        google_page.pesquisar("batata-frita");
        String resultado = google_page.div_resultado_pesquisa.getText();
        assertTrue(resultado, resultado.contains("Aproximadamente"));
    }

    @Test
    public void TCC002_deve_pesquisar_no_google_DeD(){
        google_page.pesquisar("D&D");
        String resultado = google_page.obter_resultados_pesquisa();
        assertTrue(resultado, resultado.contains("resultados"));
    }

    
}
