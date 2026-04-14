package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SBNMovimentacoesPage extends BasePage {

    public final String nomeDescricaoConta = "teste1";
    public final String nomeInteressado = "ney";
    public final String valor = "999";
    private final By telaMovimentacao = (AppiumBy.xpath("//android.widget.TextView[@text='Mov...']"));
    private final By spinnerOpcoesLancamento = (AppiumBy.xpath("//android.widget.Spinner[1]"));
    private final By lancamentoOpcaoReceita = (AppiumBy.xpath("//android.widget.CheckedTextView[@text='Receita']"));
    private final By campoSwitchDesativado = (AppiumBy.xpath("//android.widget.Switch[@text='DESATIVADO']"));
    private final By campoSwitchAtivido = (AppiumBy.xpath("//android.widget.Switch[@text='ATIVADO']"));
    private final By campoSwitch = (AppiumBy.xpath("//android.widget.Switch[1]"));
    private final By campoSalvarMovimentacao = (AppiumBy.xpath("//android.widget.TextView[@text='SALVAR']"));
    private final By campoDescricao = (AppiumBy.xpath("//android.widget.EditText[@text='Descrição']"));
    private final By mensagemCampoDescricaoObrigatorio = (AppiumBy.xpath("//android.widget.TextView[@text='Descrição é um campo obrigatório']"));
    private final By mensagemCampoInteressadoObrigatorio = (AppiumBy.xpath("//android.widget.TextView[@text='Interessado é um campo obrigatório']"));
    private final By campoInteressado = (AppiumBy.xpath("//android.widget.EditText[@text='Interessado']"));
    private final By mensagemCampoValorObrigatorio = (AppiumBy.xpath("//android.widget.TextView[@text='Valor é um campo obrigatório']"));
    private final By campoValor = (AppiumBy.xpath("//android.widget.EditText[@text='Valor']"));
    private final By mensagemCampoContaObrigatorio = (AppiumBy.xpath("//android.widget.TextView[@text='Conta é um campo obrigatório']"));
    private final By campoSelecaoConta = (AppiumBy.xpath("//android.widget.TextView[@text='Selecione uma conta...']"));
    private final By campoBuscaContaCadastrada = (AppiumBy.xpath("//android.widget.Switch[2]"));
    private final By  mensagemMovimentacaoSucesso = (AppiumBy.xpath("//android.widget.TextView[@text='Movimentação cadastrada com sucesso']"));

    public void selecionaMenuMovimentacao(){
        clicar(telaMovimentacao);
    }

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

    public void salvaMovimentacao(){
        clicar(campoSalvarMovimentacao);
    }

    public void descricaoMovimentacao(){
        escrever(campoDescricao, nomeDescricaoConta);
    }

    public String mensagemCampoObrigatorioDescricao(){
        return obterTexto(mensagemCampoDescricaoObrigatorio);
    }

    public String resultCampoDescricao(){
        By novaDescricao = (By.xpath("//android.widget.EditText[@text='" + nomeDescricaoConta + "']"));
        return obterTexto(novaDescricao);
    }

    public String mensagemCampoObrigatorioInteressado(){
        return obterTexto(mensagemCampoInteressadoObrigatorio);
    }

    public void interessadoMovimentacao(){
        escrever(campoInteressado, nomeInteressado);
    }

    public String resultCampoInteressado(){
        By novoInteressado = (By.xpath("//android.widget.EditText[@text='" + nomeInteressado + "']"));
        return obterTexto(novoInteressado);
    }

    public String mensagemCampoObrigatorioValor(){
        return obterTexto(mensagemCampoValorObrigatorio);
    }

    public void valorMovimentacao(){
        escrever(campoValor, valor);
    }

    public String resultCampoValor(){
        By newValor = (By.xpath("//android.widget.EditText[@text='" + valor + "']"));
        return obterTexto(newValor);
    }

    public String mensagemContaObrigatorioValor(){
        return obterTexto(mensagemCampoContaObrigatorio);
    }

    public void opcoesConta(){
        clicar(campoSelecaoConta);
    }

    public void deveScrollarParaBaixo(){
        scrollTelaParaBaixoAteEncontrar(campoBuscaContaCadastrada, "down");
    }

    public String resultCampoContaSelecionada(String retornoNomeConta){
        By contaQueFoiSelecionada = (AppiumBy.xpath("//*[contains(@text,'" + retornoNomeConta + "')]"));
        return obterTexto(contaQueFoiSelecionada);
    }

    public String mensagemMovimentacaoCadastrada(){
        return obterTexto(mensagemMovimentacaoSucesso);
    }

    public void buscarMovimentacao(String contaMovimentacao){
        By elementMovimentacao = (By.xpath("//android.widget.CheckedTextView[@text='" + contaMovimentacao + "']"));
        clicar(elementMovimentacao);
    }

    public void criarMovimentacao(String contaMovimentacao){
        selecionaMenuMovimentacao();
        selecionaTipoLancamentoReceita();
        clicarSwitch();
        salvaMovimentacao();
        descricaoMovimentacao();
        salvaMovimentacao();
        interessadoMovimentacao();
        salvaMovimentacao();
        valorMovimentacao();
        salvaMovimentacao();
        opcoesConta();
        deveScrollarParaBaixo();
        By elementMovimentacao = (By.xpath("//android.widget.CheckedTextView[@text='" + contaMovimentacao + "']"));
        clicar(elementMovimentacao);
        salvaMovimentacao();
    }
}
