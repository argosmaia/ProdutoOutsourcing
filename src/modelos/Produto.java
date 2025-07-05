/**
 * 
 */
package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import enums.StatusAvaliacao;

/**
 * 
 */
public abstract class Produto implements Comparable<Produto> {
	protected String nome;
    protected String marca;
    protected List<Avaliacao> avaliacoes = new ArrayList<>();
    
    public Produto() {
    	
    }
    
    /**
	 * @param nome
	 * @param marca
	 * @param avaliacoes
	 */
	public Produto(String nome, String marca, List<Avaliacao> avaliacoes) {
		this.nome = nome;
		this.marca = marca;
		this.avaliacoes = avaliacoes;
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

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the avaliacoes
	 */
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	/**
	 * @param avaliacoes the avaliacoes to set
	 */
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public void adicionarAvaliacao(Avaliacao avaliacao) {
    	avaliacoes.add(avaliacao);
    }
    public double calcularNotaMedia() {
        return avaliacoes.stream()
            .filter(avaliacao -> avaliacao.getStatus() == StatusAvaliacao.APROVADA)
            .mapToInt(Avaliacao::getNota)
            .average()
            .orElse(0);
    }

    public abstract String exibirDetalhes();

    @Override
    public int compareTo(Produto outro) {
        return this.nome.compareToIgnoreCase(outro.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto p)) return false;
        return Objects.equals(nome, p.nome) && Objects.equals(marca, p.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, marca);
    }

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", marca=" + marca + ", avaliacoes=" + avaliacoes + "]";
	}

}
