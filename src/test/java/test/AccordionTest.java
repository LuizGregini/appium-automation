package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.AccordionPage;
import page.MenuPage;
import static org.junit.jupiter.api.Assertions.*;

public class AccordionTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    AccordionPage accordionPage = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(){
        menuPage.abrirAccordion();
        accordionPage.clicarOpcao1();
        assertEquals("Esta é a descrição da opção 1", accordionPage.validaMensagemOpcao1());
    }
}
