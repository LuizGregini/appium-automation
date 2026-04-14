package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SBNContasPage extends BasePage {

    private final By contaAdicionadaSucesso = (AppiumBy.xpath("//*[contains(@text,'Conta adicionada com sucesso')]"));
    private final By campoConta = (AppiumBy.xpath("//android.widget.EditText[@text='Conta']"));
    private final By campoSalvar = (AppiumBy.xpath("//android.widget.TextView[@text='SALVAR']"));
    private final By campoExcluir = (AppiumBy.xpath("//android.widget.TextView[@text='EXCLUIR']"));
    private final By telaConta = (AppiumBy.xpath("//android.widget.TextView[@text='Contas']"));
    private final By contaExcluidaSucesso = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Conta excluída')]"));


    public String resultContaCriadaSucesso(){
        return obterTexto(contaAdicionadaSucesso);
    }

    public void criarConta(String nomeConta){
        escrever(campoConta, nomeConta);
        clicar(campoSalvar);
    }

    public void excluirConta(String nomeContaExclusao){
        By elementExclusao = (By.xpath("//android.widget.TextView[@text='" + nomeContaExclusao + "']"));
        scrollTelaParaBaixoAteEncontrar(elementExclusao, "down");
        longPress(elementExclusao, 3000);
        clicar(campoExcluir);
    }

    public void selecionaMenuConta(){
        clicar(telaConta);
    }

    public String resultContaExcluidaSucess(){
        return obterTexto(contaExcluidaSucesso);
    }
}
