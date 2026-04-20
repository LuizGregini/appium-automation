package test;

import core.BaseTest;
import helpers.ContaHelper;
import org.junit.jupiter.api.Test;
import page.SBNHomePage;
import page.SBNResumoPage;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;

public class SBNResumoTest extends BaseTest {

    SBNResumoPage sbnResumoPage = new SBNResumoPage();
    SBNHomePage sbnHomePage = new SBNHomePage();

    @Test
    public void deveDeletarResumo(){
        realizarLogin();
        String nomeConta = ContaHelper.criarConta();
        ContaHelper.criarMovimentacao(nomeConta);
        sbnHomePage.deveAcessarAbaHome();
        sbnHomePage.atualizaTela();
        assertTrue(sbnHomePage.deveScrollarAteAcharElemento(nomeConta));
        sbnResumoPage.deveClicarEmResumo();
        sbnResumoPage.deveAtualizarResumo();
        ContaHelper.excluirResumoConta(nomeConta);
        assertEquals("Movimentação removida com sucesso!", sbnResumoPage.resultMovimentacaoExcluida());
        sbnHomePage.deveAcessarAbaHome();
        sbnHomePage.deveScrollarAteAcharElementoParaCima("Conta para movimentacoes");
        sbnHomePage.atualizaTela();
        assertFalse(sbnHomePage.deveScrollarAteAcharElemento(nomeConta));
    }
}
