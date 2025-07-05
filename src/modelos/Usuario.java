/**
 * 
 */
package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.StatusUsuario;
import interfaces.Moderacao;

/**
 * 
 */
public class Usuario implements Moderacao {
	private String nome;
	private String email;
	private StatusUsuario status;
	private List<Avaliacao> avaliacoesFeita = new ArrayList<Avaliacao>();
	/**
	 * @param nome
	 * @param email
	 * @param status
	 * @param avaliacoesFeita
	 */
	public Usuario(String nome, String email, StatusUsuario status, List<Avaliacao> avaliacoesFeita) {
		this.nome = nome;
		this.email = email;
		this.status = status;
		this.avaliacoesFeita = avaliacoesFeita;
	}
	/**
	 * 
	 */
	public Usuario() {
		
	}
	/**
	 * @return the nome
	 */
	public String getNome1() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the status
	 */
	public StatusUsuario getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusUsuario status) {
		this.status = status;
	}
	/**
	 * @return the avaliacoesFeita
	 */
	public List<Avaliacao> getAvaliacoesFeita() {
		return avaliacoesFeita;
	}
	/**
	 * @param avaliacoesFeita the avaliacoesFeita to set
	 */
	public void setAvaliacoesFeita(List<Avaliacao> avaliacoesFeita) {
		this.avaliacoesFeita = avaliacoesFeita;
	}
	
	public void avaliarProduto(Produto produto, int nota, String texto) {
        Avaliacao a = new Avaliacao(nota, texto, this, produto);
		avaliacoesFeitas.add(a);
        produto.adicionarAvaliacao(a);
    }

    @Override
    public void aprovar() {
        this.status = StatusUsuario.ATIVO;
    }

    @Override
    public void rejeitar() {
        this.status = StatusUsuario.BLOQUEADO;
    }

    public List<Avaliacao> getAvaliacoesFeitas() {
        return Collections.unmodifiableList(avaliacoesFeitas);
    }

    public String getNome() {
        return nome;
    }
}
