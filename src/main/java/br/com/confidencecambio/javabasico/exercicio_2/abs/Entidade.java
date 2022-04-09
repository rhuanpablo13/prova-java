package br.com.confidencecambio.javabasico.exercicio_2.abs;

public abstract class Entidade {
    
    protected String nome;

    public Entidade(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
