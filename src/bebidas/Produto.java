package bebidas;


public abstract class Produto {
    protected int id;
    protected String nome;
    protected double preco;
    protected int quantidadeEmEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    
    public void exibirDetalhes(){
        System.out.println("id: " + id);
    }

    public double getPreco() {
        return preco;
    }
  

}