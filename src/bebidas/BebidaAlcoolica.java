package bebidas;


public class BebidaAlcoolica extends Produto {
    private double teorAlcoolico;

    public BebidaAlcoolica(double teorAlcoolico, int id, String nome, double preco, int quantidadeEmEstoque) {
        super(id, nome, preco, quantidadeEmEstoque);
        this.teorAlcoolico = teorAlcoolico;
    }
    
    
    @Override
    public void exibirDetalhes() {
        // Implementação específica
    }
 
}