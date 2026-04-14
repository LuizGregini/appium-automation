package test;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.CliquesPage;
import page.MenuPage;
import static org.junit.jupiter.api.Assertions.*;

public class CliquesTest extends BaseTest {

    MenuPage menu = new MenuPage();
    CliquesPage cliquesPage = new CliquesPage();

    @BeforeEach
    public void setup(){
        menu.abrirCliques();
    }

    @Test
    public void deveRealizarCliqueLongo(){
        cliquesPage.cliqueLongo();
        assertEquals("Clique Longo", cliquesPage.resultCliqueLongo());

    }
}
