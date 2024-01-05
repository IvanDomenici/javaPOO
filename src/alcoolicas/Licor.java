package alcoolicas;


import bebidas.BebidaAlcoolica;

public class Licor extends BebidaAlcoolica {
    private String sabor;
    private String origem; // País ou região de produção

    public Licor(String sabor, String origem, double teorAlcoolico, int id, String nome, double preco, int quantidadeEmEstoque) {
        super(teorAlcoolico, id, nome, preco, quantidadeEmEstoque);
        this.sabor = sabor;
        this.origem = origem;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Sabor: " + sabor);
        System.out.println("Origem: " + origem);
    }

    // Getters e setters para os atributos sabor e origem
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}
