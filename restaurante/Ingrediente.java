package restaurante;

public class Ingrediente {
    
    private String nome;
    private double peso;
    private int quantidade;
    private String fabricante;
    private boolean glutem;

    public Ingrediente(String nome, double peso, String fabricante) {
        this.nome = nome;
        this.peso = peso;
        this.fabricante = fabricante;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public boolean isGlutem() {
        return glutem;
    }

    public void setGlutem(boolean glutem) {
        this.glutem = glutem;
    }
    
    
    
    
}
