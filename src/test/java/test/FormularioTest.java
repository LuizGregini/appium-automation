package test;

import core.BaseTest;
import core.DSL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.FormularioPage;
import page.MenuPage;
import static org.junit.jupiter.api.Assertions.*;

public class FormularioTest extends BaseTest {
    private final MenuPage menu = new MenuPage();
    private final FormularioPage formPage = new FormularioPage();
    private DSL dsl = new DSL();

    @BeforeEach
    public void clicarFormulario(){
        menu.abrirFormulario();
    }

    @Test
    public void devePreencherEValidarFormulario(){
        dsl.preencherFormulario("Zeferina Baldaia", "PS4");
        assertEquals("Zeferina Baldaia", formPage.nomePreenchido());
        assertEquals("PS4", formPage.consolePreenchido());
        formPage.utilizarSeekBar();
        assertFalse(formPage.isCheckMarcado());
        assertTrue(formPage.isSwitchMarcado());
        formPage.clicarCheckBox();
        formPage.clicarSwitch();
        assertTrue(formPage.isCheckMarcado());
        assertFalse(formPage.isSwitchMarcado());
        formPage.clicarNaData();
        formPage.clicaParaAbrirYears();
        formPage.selecionarYear2003();
        formPage.selecionaDia();
        formPage.clicarCalendarioOK();
        formPage.clicarNaHora();
        formPage.selecionaHora();
        formPage.selecionaMinuto();
        formPage.clicarOkDataEHora();
        formPage.clicarSalvarFormulario();
        assertEquals(formPage.nomePreenchido(), formPage.resultNomePreenchido());
        assertEquals(formPage.nomePreenchido(), formPage.resultNomePreenchido());
        assertEquals(formPage.resultConsolePreenchido().toUpperCase(), formPage.consolePreenchido().toUpperCase());
        assertEquals("Marcado", formPage.resultCheckBoxPreenchido());
        assertEquals("Off", formPage.resulSwitchPreenchido());
        assertEquals("25/01/2003", formPage.resultDataPreenchida());
        assertEquals("19:35", formPage.resultDataHoraPreenchido());
    }

    @Test
    public void devePreencherEValidarFormularioDemorado(){
        formPage.escreverNome("Zeferina Baldaia");
        formPage.clicarSalvarDemorado();
        assertEquals(formPage.nomePreenchido(), formPage.resultNomePreenchido());
    }

    @Test
    public void deveInteragirComSeekBar(){
        formPage.utilizarSeekBar();
        formPage.clicarSalvarFormulario();
    }
}
