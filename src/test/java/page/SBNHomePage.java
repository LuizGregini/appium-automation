package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SBNHomePage extends BasePage {

    private final By telaHome = (AppiumBy.xpath("//android.widget.TextView[@text='Home']"));
    private final By elementParaScrollar = (AppiumBy.xpath("//android.widget.ScrollView"));

    public void deveAcessarAbaHome(){
        clicar(telaHome);
    }

    public void atualizaTela(){
        swipePorLocationWithLocator(elementParaScrollar, "down");
    }

    public boolean deveScrollarAteAcharElemento(String buscaConta){
        By busca = (AppiumBy.xpath("//android.widget.TextView[@text='"+buscaConta+"']"));
        return scrollTelaParaBaixoAteEncontrar(busca, "down");
    }

    public boolean deveScrollarAteAcharElementoParaCima(String buscaConta){
        By busca = (AppiumBy.xpath("//android.widget.TextView[@text='"+buscaConta+"']"));
        return scrollTelaParaBaixoAteEncontrar(busca, "up");
    }

    public String resultMovimentacaoSelecionada(String retornoNomeMovimentacao){
        By movimentacao = (AppiumBy.xpath("//*[contains(@text,'" + retornoNomeMovimentacao + "')]"));
        return obterTexto(movimentacao);
    }

    public String obterValorDaConta(String nomeConta) {
        By contaParaPegarValor = By.xpath("//android.widget.TextView[@text='"+nomeConta+"']/following-sibling::android.widget.TextView");
        return obterTexto(contaParaPegarValor);
    }


}
