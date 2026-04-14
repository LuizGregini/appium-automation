package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MenuPage extends BasePage{

    private final By menuFormulario = (AppiumBy.xpath("//android.widget.TextView[@text='Formulário']"));
    private final By menuSplash = (AppiumBy.xpath("//android.widget.TextView[@text='Splash']"));
    private final By menuAlertas = (AppiumBy.xpath("//android.widget.TextView[@text='Alertas']"));
    private final By menuAbas = (AppiumBy.xpath("//android.widget.TextView[@text='Abas']"));
    private final By menuAccordion = (AppiumBy.xpath("//android.widget.TextView[@text='Accordion']"));
    private final By menuCliques = (AppiumBy.xpath("//android.widget.TextView[@text='Cliques']"));
    private final By menuOpcaoBemEscondida = (AppiumBy.xpath("//android.widget.TextView[@text='Opção bem escondida']"));
    private final By menuSwipe = (AppiumBy.xpath("//android.widget.TextView[@text='Swipe']"));
    private final By menuSwipeList = (AppiumBy.xpath("//android.widget.TextView[@text='Swipe List']"));
    private final By menuDragAndDrop = (AppiumBy.xpath("//android.widget.TextView[@text='Drag and drop']"));
    private final By menuWebViewHibrido = (AppiumBy.xpath("//android.widget.TextView[@text='SeuBarriga Híbrido']"));
    private final By menuNativo = (AppiumBy.xpath("//android.widget.TextView[@text='SeuBarriga Nativo']"));

    public void abrirFormulario(){
        clicar(menuFormulario);
    }

    public void abrirSplash(){
        clicar(menuSplash);
    }

    public void abrirAlertas(){
        clicar(menuAlertas);
    }

    public void abrirAbas(){
        clicar(menuAbas);
    }

    public void abrirAccordion(){
        clicar(menuAccordion);
    }

    public String isFormularioVisivel(){
        return obterTexto(menuFormulario);
    }

    public void abrirCliques(){
        clicar(menuCliques);
    }

    public void abrirOpcaoBemEscondida(){
        clicar(menuOpcaoBemEscondida);
    }

    public void abrirSwipe(){
        clicar(menuSwipe);
    }

    public void abrirSwipeList(){
        clicar(menuSwipeList);
    }

    public void abrirDragAndDrop(){
        clicar(menuDragAndDrop);
    }

    public void abrirMenuViewHibrid(){
        clicar(menuWebViewHibrido);
    }

    public void abrirNativo(){
        clicar(menuNativo);
    }
}
