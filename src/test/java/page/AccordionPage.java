package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage{

    private final By campoOpcao1 = (AppiumBy.xpath("//android.widget.TextView[@text='Opção 1']"));
    private final By mensagemOpcao1 = (AppiumBy.xpath("//android.widget.TextView[@text='Esta é a descrição da opção 1']"));

    public void clicarOpcao1(){
        clicar(campoOpcao1);
    }

    public String validaMensagemOpcao1(){
        return obterTexto(mensagemOpcao1);
    }
}
