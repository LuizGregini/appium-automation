package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class OpcaoBemEscondidaPage extends BasePage {

    private final By elementoScroll = (AppiumBy.xpath("//android.widget.ScrollView"));
    public final By mensagemDeSucesso = (AppiumBy.id("android:id/message"));

    public void scroll(){
        scrollTelaParaBaixo(elementoScroll);
    }

    public String resultMensagemDeSucesso(){
        return obterTexto(mensagemDeSucesso);
    }
}
