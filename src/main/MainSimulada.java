package main;

import interfaces.Moderacao;
import modelos.Celular;
import modelos.Notebook;
import modelos.Plataforma;
import modelos.Usuario;

/**
 * Classe principal para demonstrar o funcionamento da plataforma
 */
public class MainSimulada {
    
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();

        // Criar usuários
        Usuario ana = new Usuario("Ana", "ana@email.com");
        Usuario joao = new Usuario("João", "joao@email.com");

        // Aprovar usuários
        ana.aprovar();
        joao.aprovar();

        // Adicionar usuários na plataforma
        plataforma.adicionarUsuario(ana);
        plataforma.adicionarUsuario(joao);

        // Criar produtos
        Celular celular = new Celular("Galaxy S22", "Samsung", 8, 128);
        Notebook notebook = new Notebook("Dell XPS", "Dell", "i7", 15.6);

        // Adicionar produtos à plataforma
        plataforma.adicionarProduto(celular);
        plataforma.adicionarProduto(notebook);

        // Usuários avaliam produtos
        ana.avaliarProduto(celular, 5, "Muito bom!");
        joao.avaliarProduto(celular, 4, "Boa performance.");
        ana.avaliarProduto(notebook, 5, "Máquina excelente.");

        // Aprova avaliações manualmente
        plataforma.listarPendenciasDeModeracao().forEach(Moderacao::aprovar);

        // Listar produtos ordenados e notas
        System.out.println("\nProdutos na plataforma:");
        plataforma.listarProdutosOrdenadosPorNome();

        System.out.println("\nNota média do celular: " + celular.calcularNotaMedia());
        System.out.println("Nota média do notebook: " + notebook.calcularNotaMedia());
    }
}