package test;

import core.BaseTest;
import helpers.ContaHelper;
import org.junit.jupiter.api.Test;
import page.SBNHomePage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class SBNHomeTest extends BaseTest {

    SBNHomePage sbnHomePage = new SBNHomePage();

    @Test
    public void deveValidarCriarMovimentacao(){
        realizarLogin();
        sbnHomePage.deveAcessarAbaHome();
        sbnHomePage.atualizaTela();
        String nomeConta = ContaHelper.criarConta();
        String nomeContaMovimentacao = ContaHelper.criarMovimentacao(nomeConta);
        //String nomeContaMovimentacao = sbnHomePage.resultMovimentacaoSelecionada(nomeConta);
        sbnHomePage.deveAcessarAbaHome();
        sbnHomePage.atualizaTela();
        assertTrue(sbnHomePage.deveScrollarAteAcharElemento(nomeConta));
        assertEquals(nomeConta, nomeContaMovimentacao);
        assertEquals("999.00", sbnHomePage.obterValorDaConta(nomeConta));
    }
}
