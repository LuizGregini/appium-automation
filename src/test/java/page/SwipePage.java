package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SwipePage extends BasePage {

    private final By botaoDireita = (AppiumBy.xpath("//android.widget.TextView[@text='›']"));
    private final By botaoEsquerda = (AppiumBy.xpath("//android.widget.TextView[@text='‹']"));
    private final By textoEsquerda = (AppiumBy.xpath("//android.widget.TextView[@text='a esquerda']"));
    private final By textoMeio = (AppiumBy.xpath("//android.widget.TextView[@text='E veja se']"));
    private final By textoFim = (AppiumBy.xpath("//android.widget.TextView[@text='Chegar até o fim!']"));

    public void realizaSwipeUmaUnicaVez(){
        swipeUmaVez(botaoDireita);
    }

    public void swipeAteFinal(){
        swipeAteFinalWithPossition(botaoEsquerda, "right");
    }

    public String resultTextoEsquerda(){
        return obterTexto(textoEsquerda);
    }

    public String resultTextoMeio(){
        return obterTexto(textoMeio);
    }

    public String resultTextoMFim(){
        return obterTexto(textoFim);
    }
}
