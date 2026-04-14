package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class FormularioPage extends BasePage {
    private final By campoNome = (AppiumBy.accessibilityId("nome"));
    private final By campoConsole = (AppiumBy.accessibilityId("console"));
    private final By resultConsole = (AppiumBy.xpath("//android.widget.Spinner[@content-desc='console']//android.widget.TextView[@resource-id='android:id/text1']"));
    private final By campoCheckBox = (AppiumBy.accessibilityId("check"));
    private final By campoSwitch = (AppiumBy.accessibilityId("switch"));
    private final By campoSalvar = (AppiumBy.accessibilityId("save"));
    private final By campoSalvarDemorado = (AppiumBy.xpath("(//android.widget.Button[@resource-id='idButtonTest'])[2]"));
    private final By resultCampoNome = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    private final By resultCampoConsole = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    private final By resultCampoSwitch = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    private final By resultCampoCheckBox = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    private final By campoData = (AppiumBy.xpath("//android.widget.TextView[@text='01/01/2000']"));
    private final By campoExpandirYears = (AppiumBy.id("android:id/date_picker_header_year"));
    private final By clicarYear2003 = (AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='2003']"));
    private final By diaSelecionado = (AppiumBy.accessibilityId("25 janeiro 2003"));
    private final By campoCalendarioOK = (AppiumBy.id("android:id/button1"));
    private final By resultData = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Data:')]"));
    private final By campoHora = (AppiumBy.xpath("//android.widget.TextView[@text='09:00']"));
    private final By campoHoraSelecionada = AppiumBy.accessibilityId("19");
    private final By campoMinutoSelecionado = (AppiumBy.accessibilityId("35"));
    private final By selecionaOkHora = (AppiumBy.id("android:id/button1"));
    private final By resultDataHora = (AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Hora:')]"));
    private final By campoSeekBar = (AppiumBy.accessibilityId("slid"));

    public void escreverNome(String nome){
        escrever(campoNome, nome);
    }

    public String nomePreenchido(){
        return obterTexto(campoNome);
    }

    public void clicarConsole(){
        clicar(campoConsole);
    }

    public void selecionarOpcaoConsole(String console){
        By opcoesConsole = (AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='" + console + "']"));
        clicar(opcoesConsole);
    }

    public String consolePreenchido(){
        return obterTexto(resultConsole);
    }

    public boolean isCheckMarcado(){
        return isMarcado(campoCheckBox);
    }

    public boolean isSwitchMarcado(){
        return isMarcado(campoSwitch);
    }

    public void clicarCheckBox(){
        clicar(campoCheckBox);
    }

    public void clicarSwitch(){
        clicar(campoSwitch);
    }

    public void clicarSalvarFormulario(){
        clicar(campoSalvar);
    }

    public void clicarSalvarDemorado(){
        clicar(campoSalvarDemorado);
    }

    public String resultNomePreenchido(){
        return obterTextoComReplace(resultCampoNome, "Nome: ", "");
    }

    public String resultConsolePreenchido(){
        return obterTextoComReplace(resultCampoConsole, "Console: ", "");
    }

    public String resulSwitchPreenchido(){
        return obterTextoComReplace(resultCampoSwitch, "Switch: ", "");
    }

    public String resultCheckBoxPreenchido(){
        return obterTextoComReplace(resultCampoCheckBox, "Checkbox: ", "");
    }

    public void clicarNaData(){
        clicar(campoData);
    }

    public void clicaParaAbrirYears(){
        clicar(campoExpandirYears);
    }

    public void selecionarYear2003(){
        clicar(clicarYear2003);
    }

    public void selecionaDia(){
        clicar(diaSelecionado);
    }

    public void clicarCalendarioOK(){
        clicar(campoCalendarioOK);
    }

    public String resultDataPreenchida(){
        return obterTextoComReplace(resultData, "Data: ", "");
    }

    public void clicarNaHora(){
        clicar(campoHora);
    }

    public void selecionaHora(){
        clicar(campoHoraSelecionada);
    }

    public void selecionaMinuto(){
        clicar(campoMinutoSelecionado);
    }

    public void clicarOkDataEHora(){
        clicar(selecionaOkHora);
    }

    public String resultDataHoraPreenchido(){
        return obterTextoComReplace(resultDataHora, "Hora: ", "");
    }

    public void utilizarSeekBar(){
        clicarSeekBar(campoSeekBar, 0.60);
    }



}
