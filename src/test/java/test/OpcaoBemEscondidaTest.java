package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.MenuPage;
import page.OpcaoBemEscondidaPage;
import static org.junit.jupiter.api.Assertions.*;

public class OpcaoBemEscondidaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    OpcaoBemEscondidaPage opcaoBemEscondidaPage = new OpcaoBemEscondidaPage();

    @Test
    public void deveEncontrarOpcaoBemEscondida(){
        opcaoBemEscondidaPage.scroll();
        menuPage.abrirOpcaoBemEscondida();
        assertEquals("Você achou essa opção", opcaoBemEscondidaPage.resultMensagemDeSucesso());
    }
}
