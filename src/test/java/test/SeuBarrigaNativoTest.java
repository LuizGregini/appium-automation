package test;

import core.BaseTest;
import helpers.ContaHelper;
import org.junit.jupiter.api.Test;
import page.SeuBarrigaNativoPage;
import static org.junit.jupiter.api.Assertions.*;

public class SeuBarrigaNativoTest extends BaseTest {
    SeuBarrigaNativoPage seuBarrigaNativoPage = new SeuBarrigaNativoPage();

    @Test
    public void deveCriarConta(){
        realizarLogin();
        ContaHelper.criarConta();
        assertEquals("Conta adicionada com sucesso", seuBarrigaNativoPage.resultContaCriadaSucesso());
    }

    @Test
    public void deveExcluirConta(){
        seuBarrigaNativoPage.selecionaMenuConta();
        String nomeContaExclusao = ContaHelper.criarConta();
        ContaHelper.excluirConta(nomeContaExclusao);
        assertEquals("Conta excluída com sucesso", seuBarrigaNativoPage.resultContaExcluidaSucess());
    }

    @Test
    public void deveRealizarMovimentacao(){
        String nomeContaCriadaParaMov = ContaHelper.criarConta();
        seuBarrigaNativoPage.selecionaMenuMovimentacao();
        seuBarrigaNativoPage.selecionaTipoLancamentoReceita();
        assertFalse(seuBarrigaNativoPage.isSwithDesmarcado());
        seuBarrigaNativoPage.clicarSwitch();
        assertTrue(seuBarrigaNativoPage.isSwithMarcado());
        seuBarrigaNativoPage.salvaMovimentacao();
        assertEquals("Descrição é um campo obrigatório", seuBarrigaNativoPage.mensagemCampoObrigatorioDescricao());
        seuBarrigaNativoPage.descricaoMovimentacao();
        assertEquals("teste1", seuBarrigaNativoPage.resultCampoDescricao());
        seuBarrigaNativoPage.salvaMovimentacao();
        assertEquals("Interessado é um campo obrigatório", seuBarrigaNativoPage.mensagemCampoObrigatorioInteressado());
        seuBarrigaNativoPage.interessadoMovimentacao();
        assertEquals("ney", seuBarrigaNativoPage.resultCampoInteressado());
        seuBarrigaNativoPage.salvaMovimentacao();
        assertEquals("Valor é um campo obrigatório", seuBarrigaNativoPage.mensagemCampoObrigatorioValor());
        seuBarrigaNativoPage.valorMovimentacao();
        assertEquals("999", seuBarrigaNativoPage.resultCampoValor());
        seuBarrigaNativoPage.salvaMovimentacao();
        assertEquals("Conta é um campo obrigatório", seuBarrigaNativoPage.mensagemContaObrigatorioValor());
        seuBarrigaNativoPage.opcoesConta();
        seuBarrigaNativoPage.deveScrollarParaBaixo();
        ContaHelper.buscaMovimentacao(nomeContaCriadaParaMov);
        String nomeNaTela = seuBarrigaNativoPage.resultCampoContaSelecionada(nomeContaCriadaParaMov);
        assertEquals(nomeContaCriadaParaMov, nomeNaTela);
        seuBarrigaNativoPage.salvaMovimentacao();
        assertEquals("Movimentação cadastrada com sucesso", seuBarrigaNativoPage.mensagemMovimentacaoCadastrada());
    }
}
