package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AbasPage extends BasePage {

    private final By validaMensagemAba1 = (AppiumBy.xpath("//android.widget.TextView[@text='Este é o conteúdo da Aba 1']"));
    private final By validaMensagemAba2 = (AppiumBy.xpath("//android.widget.TextView[@text='Este é o conteúdo da Aba 2']"));
    private final By aba2 = (AppiumBy.xpath("//android.widget.TextView[@text='Aba 2']"));

    public String obtemTextoAba1(){
        return obterTexto(validaMensagemAba1);
    }

    public String obtemTextoAba2(){
        return obterTexto(validaMensagemAba2);
    }

    public void clicarNaAba2(){
        clicar(aba2);
    }
}
