package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.MenuPage;
import page.WebViewPage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class WebViewTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    WebViewPage webViewPage = new WebViewPage();

    @Disabled
    @Test
    public void deveFazerLogin(){
        menuPage.abrirMenuViewHibrid();
        webViewPage.deveChamarWebView();
        webViewPage.deveDigitarEmail();
        webViewPage.deveDigitarPassword();
        webViewPage.deveClicarEmEntrar();
        assertEquals("Bem vindo, Biro lilo!", webViewPage.verificaLoginSucess());
    }
}
