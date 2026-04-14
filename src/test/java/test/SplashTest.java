package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.MenuPage;
import page.SplashPage;
import static org.junit.jupiter.api.Assertions.*;

public class SplashTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    SplashPage splashPage = new SplashPage();

    @Test
    public void deveAguardarSplashSumir(){
        menuPage.abrirSplash();
        assertEquals("Splash!", splashPage.splashEmTela());
        assertTrue(splashPage.aguardarsplashSumir());
        assertEquals("Formulário", menuPage.isFormularioVisivel());
    }
}
