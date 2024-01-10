package bebidas;


import bebidas.Produto;

public class BebidaNaoAlcoolica extends Produto {
    private String sabor;

    public BebidaNaoAlcoolica(String sabor, int id, String nome, double preco, int quantidadeEmEstoque) {
        super(id, nome, preco, quantidadeEmEstoque);
        this.sabor = sabor;
    }
 
    
    
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Sabor: " + sabor);
    }

    @Override
    public boolean descontoAplicavel() {
        return true;
    }




}
