/**
 * 
 */
package modelos;

import java.util.ArrayList;
import java.util.List;

import enums.StatusAvaliacao;
import interfaces.Moderacao;

/**
 * 
 */
public class Plataforma {
    private List<Produto> produtos = new ArrayList<Produto>();
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public void adicionarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtos.stream()
            .filter(p -> p.nome.equalsIgnoreCase(nome))
            .findFirst()
            .orElse(null);
    }

    public void listarProdutosOrdenadosPorNome() {
        produtos.stream()
            .sorted()
            .forEach(p -> System.out.println(p.exibirDetalhes()));
    }

    public List<Moderacao> listarPendenciasDeModeracao() {
        List<Moderacao> pendentes = new ArrayList<>();

        for (Usuario u : usuarios) {
            if (u.getAvaliacoesFeita().stream().anyMatch(a -> a.getStatus() == StatusAvaliacao.PENDENTE)) {
                pendentes.add(u);
            }
        }

        for (Produto p : produtos) {
            pendentes.addAll(p.avaliacoes.stream().filter(a -> a.getStatus() == StatusAvaliacao.PENDENTE).toList());
        }

        return pendentes;
    }
}
