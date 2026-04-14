package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.AlertasPage;
import page.MenuPage;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertasTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    AlertasPage alertasPage = new AlertasPage();

    @Test
    public void deveConfirmaAlerta(){
        menuPage.abrirAlertas();
        alertasPage.clicarEmAlertConfirm();
        assertEquals("Info", alertasPage.validaTituloAlerta());
        assertEquals("Confirma a operação?", alertasPage.validaMensagemConfirmaOperacao());
        alertasPage.clicarEmConfirmar();
        assertEquals("Confirmado", alertasPage.validaMensagemConfirmado());
        alertasPage.clicarEmSair();
    }

    @Test
    public void deveClicarForaAlerta(){
        menuPage.abrirAlertas();
        alertasPage.clicarBotaoAlertaSimples();
        assertTrue(alertasPage.validaMensagemAlertaSimples());
        alertasPage.clicaForaDaCaixa();
        assertFalse(alertasPage.validaMensagemAlertaSimples());
    }
}
