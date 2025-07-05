/**
 * 
 */
package modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public abstract class Produto implements Comparable<Produto> {
	protected String nome;
    protected String marca;
    protected List<Avaliacao> avaliacoes = new ArrayList<>();
}
