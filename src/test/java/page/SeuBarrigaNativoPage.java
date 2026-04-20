package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SeuBarrigaNativoPage extends BasePage {
    public final String nomeDescricaoConta = "teste1";
    public final String nomeInteressado = "ney";
    public final String valor = "999";
    private final By telaConta = (AppiumBy.xpath("//android.widget.TextView[@text='Contas']"));
    private final By contaAdicionadaSucesso = (AppiumBy.xpath("//*[contains(@text,'Conta adicionada com sucesso')]"));
    private final By contaExcluidaSucesso = (AppiumBy.xpath("//*[contains(@text,'Conta excluída com sucesso')]"));
    private final By telaMovimentacao = (AppiumBy.xpath("//android.widget.TextView[@text='Mov...']"));
    private final By campoSalvarMovimentacao = (AppiumBy.xpath("//android.widget.TextView[@text='SALVAR']"));
    private final By mensagemCampoDescricaoObrigatorio = (AppiumBy.xpath("//android.widget.TextView[@text='Descrição é um campo obrigatório']"));
    private final By campoDescricao = (AppiumBy.xpath("//android.widget.EditText[@text='Descrição']"));
    private final By campoInteressado = (AppiumBy.xpath("//android.widget.EditText[@text='Interessado']"));
    private final By campoValor = (AppiumBy.xpath("//android.widget.EditText[@text='Valor']"));
    private final By campoSelecaoConta = (AppiumBy.xpath("//android.widget.TextView[@text='Selecione uma conta...']"));
    private final By mensagemCampoInteressadoObrigatorio = (AppiumBy.xpath("//android.widget.TextView[@text='Interessado é um campo obrigatório']"));
    private final By mensagemCampoValorObrigatorio = (AppiumBy.xpath("//android.widget.TextView[@text='Valor é um campo obrigatório']"));
    private final By mensagemCampoContaObrigatorio = (AppiumBy.xpath("//android.widget.TextView[@text='Conta é um campo obrigatório']"));
    private final By  mensagemMovimentacaoSucesso = (AppiumBy.xpath("//android.widget.TextView[@text='Movimentação cadastrada com sucesso']"));
    private final By spinnerOpcoesLancamento = (AppiumBy.xpath("//android.widget.Spinner[1]"));
    private final By lancamentoOpcaoReceita = (AppiumBy.xpath("//android.widget.CheckedTextView[@text='Receita']"));
    private final By campoSwitchDesativado = (AppiumBy.xpath("//android.widget.Switch[@text='DESATIVADO']"));
    private final By campoSwitchAtivido = (AppiumBy.xpath("//android.widget.Switch[@text='ATIVADO']"));
    private final By campoSwitch = (AppiumBy.xpath("//android.widget.Switch[1]"));

    public void selecionaTipoLancamentoReceita(){
        clicar(spinnerOpcoesLancamento);
        clicar(lancamentoOpcaoReceita);
    }

    public boolean isSwithDesmarcado(){
        return isMarcado(campoSwitchDesativado);
    }

    public boolean isSwithMarcado(){
        return isMarcado(campoSwitchAtivido);
    }

    public void clicarSwitch(){
        clicar(campoSwitch);
    }

    public void selecionaMenuConta(){
        clicar(telaConta);
    }

    public void selecionaMenuMovimentacao(){
        clicar(telaMovimentacao);
    }

    public String resultContaCriadaSucesso(){
        return obterTexto(contaAdicionadaSucesso);
    }

    public String resultContaExcluidaSucess(){
        return obterTexto(contaExcluidaSucesso);
    }

    public void deveScrollarParaBaixo(){
        scrollTelaParaBaixoAteEncontrar(contaAdicionadaSucesso, "down");
    }

    public void salvaMovimentacao(){
        clicar(campoSalvarMovimentacao);
    }

    public String mensagemCampoObrigatorioDescricao(){
        return obterTexto(mensagemCampoDescricaoObrigatorio);
    }

    public String mensagemCampoObrigatorioInteressado(){
        return obterTexto(mensagemCampoInteressadoObrigatorio);
    }

    public String mensagemCampoObrigatorioValor(){
        return obterTexto(mensagemCampoValorObrigatorio);
    }

    public String mensagemContaObrigatorioValor(){
        return obterTexto(mensagemCampoContaObrigatorio);
    }

    public String mensagemMovimentacaoCadastrada(){
        return obterTexto(mensagemMovimentacaoSucesso);
    }

    public void descricaoMovimentacao(){
        escrever(campoDescricao, nomeDescricaoConta);
    }

    public void interessadoMovimentacao(){
        escrever(campoInteressado, nomeInteressado);
    }

    public void valorMovimentacao(){
        escrever(campoValor, valor);
    }

    public void opcoesConta(){
        clicar(campoSelecaoConta);
    }

    public String resultCampoDescricao(){
        By novaDescricao = (By.xpath("//android.widget.EditText[@text='" + nomeDescricaoConta + "']"));
        return obterTexto(novaDescricao);
    }

    public String resultCampoInteressado(){
        By novoInteressado = (By.xpath("//android.widget.EditText[@text='" + nomeInteressado + "']"));
        return obterTexto(novoInteressado);
    }

    public String resultCampoContaSelecionada(String retornoNomeConta){
        By contaQueFoiSelecionada = (AppiumBy.xpath("//*[contains(@text,'"+retornoNomeConta+"')]"));
        return obterTexto(contaQueFoiSelecionada);
    }

    public String resultCampoValor(){
        By newValor = (By.xpath("//android.widget.EditText[@text='" + valor + "']"));
        return obterTexto(newValor);
    }












}
