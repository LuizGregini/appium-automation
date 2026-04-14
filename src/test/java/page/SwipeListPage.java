package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SwipeListPage extends BasePage {

    private final By textoOpcao1 = (AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"));
    private final By textoOpcao4 = (AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup"));
    private final By textoOpcao5 = (AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup"));
    private final By resultTextoOpcao1 = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Opção 1')]"));
    private final By resultTextoOpcao4 = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Opção 4')]"));
    private final By resultTextoOpcao5 = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Opção 5')]"));

    public void swipeOpcao1(){
        swipePorLocationWithLocator(textoOpcao1, "left");
    }

    public void swipeOpcao4(){
        swipePorLocationWithLocator(textoOpcao4, "left");
    }

    public void swipeOpcao5(){
        swipePorLocationWithLocator(textoOpcao5, "right");
    }

    public void clicarEmMais(){
         clicarPorTexto("(+)");
    }

    public void clicarEmMenos(){
        clicarPorTexto("(-)");
    }

    public String resultOpcao1(){
        return obterTexto(resultTextoOpcao1);
    }

    public String resultOpcao4(){
        return obterTexto(resultTextoOpcao4);
    }

    public String resultOpcao5(){
        return obterTexto(resultTextoOpcao5);
    }

}
