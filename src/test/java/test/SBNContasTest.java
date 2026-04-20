package test;

import core.BaseTest;
import helpers.ContaHelper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import page.SBNContasPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.qameta.allure.*;

public class SBNContasTest extends BaseTest {

    SBNContasPage sbnContasPage = new SBNContasPage();

    @Epic("Conta")
    @Feature("Criação de Conta")
    @Story("Usuário cria conta com sucesso")
    @Test
    public void deveCriarConta(){
        realizarLogin();
        ContaHelper.criarConta();
        assertEquals("Conta adicionada com sucesso", sbnContasPage.resultContaCriadaSucesso());
    }

    @Epic("Conta")
    @Feature("Deleção de uma conta existente")
    @Story("Usuário deleta uma conta com sucesso")
    @Test
    public void deveExcluirConta(){
        realizarLogin();
        String nomeContaExclusao = ContaHelper.criarConta();
        ContaHelper.excluirConta(nomeContaExclusao);
        assertEquals("Conta excluída com sucesso", sbnContasPage.resultContaExcluidaSucess());
    }
}
