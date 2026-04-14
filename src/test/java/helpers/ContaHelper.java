package helpers;

import page.SBNContasPage;
import page.SBNMovimentacoesPage;
import page.SBNResumoPage;

public class ContaHelper {

    public static String criarConta() {
        SBNContasPage sbnContasPage = new SBNContasPage();
        sbnContasPage.selecionaMenuConta();
        SBNMovimentacoesPage sbnMovimentacoesPage = new SBNMovimentacoesPage();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String nomeContaCriada = "Conta_" + timestamp;
        sbnContasPage.criarConta(nomeContaCriada);
        sbnMovimentacoesPage.resultCampoContaSelecionada(nomeContaCriada);
        return nomeContaCriada;
    }

    public static void excluirConta(String nomeConta){
        SBNContasPage sbnContasPage = new SBNContasPage();
        sbnContasPage.excluirConta(nomeConta);
    }

    public static void buscaMovimentacao(String contaMovimentacao){
        SBNMovimentacoesPage sbnMovimentacoesPage = new SBNMovimentacoesPage();
        sbnMovimentacoesPage.buscarMovimentacao(contaMovimentacao);
    }

    public static void criarMovimentacao(String contaMovimentacao){
        SBNMovimentacoesPage sbnMovimentacoesPage = new SBNMovimentacoesPage();
        sbnMovimentacoesPage.criarMovimentacao(contaMovimentacao);
    }

    public static void excluirResumoConta(String nomeConta){
        SBNResumoPage sbnResumoPage = new SBNResumoPage();
        sbnResumoPage.excluirResumoConta(nomeConta);
    }
}
