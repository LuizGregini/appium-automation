package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SBNResumoPage extends BasePage {

    private final By telaResumo = (AppiumBy.xpath("//android.widget.TextView[@text='Resumo']"));
    private final By btnAtualizar = (AppiumBy.xpath("//android.widget.TextView[@text='ATUALIZAR']"));
    private final By textResult = (AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Movimentação removida com sucesso')]"));

    public void deveClicarEmResumo(){
        clicar(telaResumo);
    }

    public void deveAtualizarResumo(){
        clicar(btnAtualizar);
    }

    public void excluirResumoConta(String nomeConta){
        By byContainer = AppiumBy.xpath("//android.widget.TextView[@text='"+nomeConta+"']/ancestor::android.view.ViewGroup[1]");
        scrollTelaParaBaixoAteEncontrar(byContainer, "down");
        swipePorLocationWithLocator(byContainer, "left");
        clicarPorTexto("Del");
    }

    public String resultMovimentacaoExcluida(){
        return obterTexto(textResult);
    }
}
