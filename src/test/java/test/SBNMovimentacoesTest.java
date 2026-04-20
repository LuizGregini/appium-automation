package test;

import core.BaseTest;
import helpers.ContaHelper;
import org.junit.jupiter.api.Test;
import page.SBNMovimentacoesPage;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Disabled;

public class SBNMovimentacoesTest extends BaseTest {

    SBNMovimentacoesPage sbnMovimentacoesPage = new SBNMovimentacoesPage();

    @Test
    public void deveRealizarMovimentacao(){
        realizarLogin();
        String nomeContaCriadaParaMov = ContaHelper.criarConta();
        sbnMovimentacoesPage.selecionaMenuMovimentacao();
        sbnMovimentacoesPage.selecionaTipoLancamentoReceita();
        assertFalse(sbnMovimentacoesPage.isSwithDesmarcado());
        sbnMovimentacoesPage.clicarSwitch();
        assertTrue(sbnMovimentacoesPage.isSwithMarcado());
        sbnMovimentacoesPage.salvaMovimentacao();
        assertEquals("Descrição é um campo obrigatório", sbnMovimentacoesPage.mensagemCampoObrigatorioDescricao());
        sbnMovimentacoesPage.descricaoMovimentacao();
        assertEquals("teste1", sbnMovimentacoesPage.resultCampoDescricao());
        sbnMovimentacoesPage.salvaMovimentacao();
        assertEquals("Interessado é um campo obrigatório", sbnMovimentacoesPage.mensagemCampoObrigatorioInteressado());
        sbnMovimentacoesPage.interessadoMovimentacao();
        assertEquals("ney", sbnMovimentacoesPage.resultCampoInteressado());
        sbnMovimentacoesPage.salvaMovimentacao();
        assertEquals("Valor é um campo obrigatório", sbnMovimentacoesPage.mensagemCampoObrigatorioValor());
        sbnMovimentacoesPage.valorMovimentacao();
        assertEquals("999", sbnMovimentacoesPage.resultCampoValor());
        sbnMovimentacoesPage.salvaMovimentacao();
        assertEquals("Conta é um campo obrigatório", sbnMovimentacoesPage.mensagemContaObrigatorioValor());
        sbnMovimentacoesPage.opcoesConta();
        sbnMovimentacoesPage.deveScrollarParaBaixo();
        ContaHelper.buscaMovimentacao(nomeContaCriadaParaMov);
        String nomeNaTela = sbnMovimentacoesPage.resultCampoContaSelecionada(nomeContaCriadaParaMov);
        assertEquals(nomeContaCriadaParaMov, nomeNaTela);
        sbnMovimentacoesPage.salvaMovimentacao();
        assertEquals("Movimentação cadastrada com sucesso", sbnMovimentacoesPage.mensagemMovimentacaoCadastrada());
    }

    @Test
    public void deveRealizarMovimentacaoComReceita(){
        realizarLogin();
        String nomeContaCriadaParaMov = ContaHelper.criarConta();
        sbnMovimentacoesPage.selecionaMenuMovimentacao();
        assertFalse(sbnMovimentacoesPage.isSwithDesmarcado());
        sbnMovimentacoesPage.clicarSwitch();
        assertTrue(sbnMovimentacoesPage.isSwithMarcado());
        String nomeNaTela = ContaHelper.criarMovimentacao(nomeContaCriadaParaMov);
        //String nomeNaTela = sbnMovimentacoesPage.resultCampoContaSelecionada(nomeContaCriadaParaMov);
        assertEquals(nomeContaCriadaParaMov, nomeNaTela);
        assertEquals("Movimentação cadastrada com sucesso", sbnMovimentacoesPage.mensagemMovimentacaoCadastrada());
    }
}
