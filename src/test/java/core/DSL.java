package core;

import page.FormularioPage;

public class DSL {
    FormularioPage formPage = new FormularioPage();
    public void preencherFormulario(String nome, String console){
        formPage.escreverNome(nome);
        formPage.clicarConsole();
        formPage.selecionarOpcaoConsole(console);
    }
}
