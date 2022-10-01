package automatizado.builders;

import automatizado.page.ControleDeProdutoPO;

// Classe para construir produtos
public class ProdutoBuilder {
    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "30/09/2022";

    private ControleDeProdutoPO controleDeProdutoPO; 
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    public ProdutoBuilder adicionar_codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }
    public ProdutoBuilder adicionar_nome(String nome) {
        this.nome = nome;
        return this;
    }
    public ProdutoBuilder adicionar_quantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }
    public ProdutoBuilder adicionar_valor(Double valor) {
        this.valor = valor;
        return this;
    }
    public ProdutoBuilder adicionar_data(String data) {
        this.data = data;
        return this;
    }

    // Método que cria os produtos
    public void builder(){
        // Limpar inputs
        controleDeProdutoPO.input_codigo.clear();
        controleDeProdutoPO.input_nome.clear();
        controleDeProdutoPO.input_quantidade.clear();
        controleDeProdutoPO.input_valor.clear();
        controleDeProdutoPO.input_data.clear();
        
        // Preencher inputs
        controleDeProdutoPO.input_codigo.sendKeys(codigo);
        controleDeProdutoPO.input_nome.sendKeys(nome);
        controleDeProdutoPO.input_quantidade.sendKeys((quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.input_valor.sendKeys((valor != null) ? valor.toString() : "");
        controleDeProdutoPO.input_data.sendKeys(data);
        
        controleDeProdutoPO.btn_salvar.click();
    }
}
