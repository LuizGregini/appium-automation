package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AlertasPage extends BasePage {

    private final By campoAlertConfirm = AppiumBy.xpath("//android.widget.Button[@resource-id='idButtonTest3']");
    private final By textoAlertConfirm = AppiumBy.id("android:id/message");
    private final By confirmarAlerta = AppiumBy.id("android:id/button2");
    private final By textoConfirmado = AppiumBy.id("android:id/message");
    private final By campoSair = AppiumBy.id("android:id/button1");
    private final By tituloAlerta = AppiumBy.id("android:id/alertTitle");
    private final By campoAlertaSimples = (AppiumBy.xpath("//android.widget.Button[@resource-id='idButtonTest']"));
    private final By mensagemAlertaSimples = (AppiumBy.id("android:id/message"));
    public void clicarEmAlertConfirm(){
        clicar(campoAlertConfirm);
    }

    public String validaTituloAlerta(){
        return obterTexto(tituloAlerta);
    }

    public String validaMensagemConfirmaOperacao(){
        return obterTexto(textoAlertConfirm);
    }

    public void clicarEmConfirmar(){
        clicar(confirmarAlerta);
    }

    public String validaMensagemConfirmado(){
        return obterTexto(textoConfirmado);
    }

    public void clicarEmSair(){
        clicar(campoSair);
    }

    public void clicarBotaoAlertaSimples(){
        clicar(campoAlertaSimples);
    }

    public void clicaForaDaCaixa(){
        tap(100,150);
    }

    public boolean validaMensagemAlertaSimples(){
        return isElementoVisivel(mensagemAlertaSimples);
    }

}
