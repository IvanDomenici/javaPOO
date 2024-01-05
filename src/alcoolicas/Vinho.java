package alcoolicas;

import bebidas.BebidaAlcoolica;

public class Vinho extends BebidaAlcoolica {
    private String regiao;
    private String uva;

    public Vinho(String regiao, String uva, double teorAlcoolico, int id, String nome, double preco, int quantidadeEmEstoque) {
        super(teorAlcoolico, id, nome, preco, quantidadeEmEstoque);
        this.regiao = regiao;
        this.uva = uva;
    }
    
    

    @Override
    public void exibirDetalhes() {
        // Implementação específica
    }
    // getters e setters
}