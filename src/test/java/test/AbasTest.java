package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.AbasPage;
import page.MenuPage;

public class AbasTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    AbasPage abasPage = new AbasPage();

    @Test
    public void deveInteragirComAbas(){
        menuPage.abrirAbas();
        abasPage.obtemTextoAba1();
        abasPage.clicarNaAba2();
        abasPage.obtemTextoAba2();
    }
}
