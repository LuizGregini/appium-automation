package test;

import core.BaseTest;
import helpers.ContaHelper;
import org.junit.jupiter.api.Test;
import page.SBNHomePage;
import static org.junit.jupiter.api.Assertions.*;

public class SBNHomeTest extends BaseTest {

    SBNHomePage sbnHomePage = new SBNHomePage();

    @Test
    public void deveExcluirMovimentacao(){
        realizarLogin();
        sbnHomePage.deveAcessarAbaHome();
        sbnHomePage.atualizaTela();
        String nomeConta = ContaHelper.criarConta();
        ContaHelper.criarMovimentacao(nomeConta);
        String nomeContaMovimentacao = sbnHomePage.resultMovimentacaoSelecionada(nomeConta);
        sbnHomePage.deveAcessarAbaHome();
        sbnHomePage.atualizaTela();
        assertFalse(sbnHomePage.deveScrollarAteAcharElemento(nomeConta));
        assertEquals(nomeConta, nomeContaMovimentacao);
        assertEquals("999.00", sbnHomePage.obterValorDaConta(nomeConta));
    }
}
