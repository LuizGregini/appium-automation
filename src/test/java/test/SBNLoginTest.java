package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.MenuPage;
import page.SBNLoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SBNLoginTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    SBNLoginPage sbnLoginPage = new SBNLoginPage();

    @Test
    public void realizaLoginWithSucess() {
        realizarLogin();
        assertTrue(sbnLoginPage.deveVerificarCampoReset());
    }

    @Test
    public void naoDeveRealizarLoginComSenhaInvalida() {
        menuPage.abrirNativo();
        sbnLoginPage.deveDigitarNome();
        sbnLoginPage.deveDigitarSenhaIncorreta();
        sbnLoginPage.clicarEntrar();
        assertEquals("Usuário ou senha inválido", sbnLoginPage.deveRetornaMensagemLoginInvalido());
    }
}
