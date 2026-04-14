package test;

import core.BaseTest;
import helpers.ContaHelper;
import org.junit.jupiter.api.Test;
import page.SBNContasPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SBNContasTest extends BaseTest {

    SBNContasPage sbnContasPage = new SBNContasPage();

    @Test
    public void deveCriarConta(){
        realizarLogin();
        ContaHelper.criarConta();
        assertEquals("Conta adicionada com sucesso", sbnContasPage.resultContaCriadaSucesso());
    }

    @Test
    public void deveExcluirConta(){
        realizarLogin();
        String nomeContaExclusao = ContaHelper.criarConta();
        ContaHelper.excluirConta(nomeContaExclusao);
        assertEquals("Conta excluída com sucesso", sbnContasPage.resultContaExcluidaSucess());
    }
}
