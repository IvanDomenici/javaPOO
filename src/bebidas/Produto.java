package bebidas;


public abstract class Produto implements Descontos {
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
        System.out.println("ID: " + id);
        System.out.println("Nome: "+nome);
        System.out.println("Preço: "+preco);
        System.out.println("Quantidade: "+quantidadeEmEstoque);

    }

    public double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
   
    private boolean disponibilidade(int quantidade){
        return this.quantidadeEmEstoque >= quantidade;
    }
    
    public void diminuiQuantidade(int quant){
        if (this.disponibilidade(quant)){
            this.quantidadeEmEstoque = this.quantidadeEmEstoque - quant;
        }else{
            throw new IllegalArgumentException("O produto não possui essa disponibilidae. Temos "+this.quantidadeEmEstoque+" em estoque.");
        }
    }
    
    
  

}