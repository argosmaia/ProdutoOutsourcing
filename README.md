# Projeto Final de LP2 (POO)

Plataforma de avaliação de produtos eletrônicos (Celulares e Notebooks), desenvolvida em **Java 21**, utilizando os pilares da **Programação Orientada a Objetos (POO)**. Permite que usuários avaliem produtos e moderem avaliações dentro de um sistema de crowdsourcing.

---

## 🔍 Estrutura do Projeto

```
├── modelo/        // Classes de dominio (Usuario, Produto, Avaliacao, etc)
├── interfaces/    // Interface IModeravel
├── MainSimulada.java      // Execução automática
├── MainInterativa.java    // Execução com Scanner
```

## 🔢 Classes e Componentes

### Enumerações

* `StatusAvaliacao`: PENDENTE, APROVADA, REJEITADA
* `StatusUsuario`: PENDENTE\_APROVACAO, ATIVO, BLOQUEADO

### Interface

* `IModeravel`: define `aprovar()` e `rejeitar()` para entidades moderáveis

### Classe Abstrata

* `Produto`: classe base com nome, marca e lista de avaliações. Implementa `Comparable`

### Subclasses de Produto

* `Celular`: possui `memoriaRAM` e `armazenamento`
* `Notebook`: possui `processador` e `tamanhoTela`

### `Usuario`

* Pode avaliar produtos
* Guarda suas próprias avaliações
* Implementa `IModeravel`

### `Avaliacao`

* Conecta um `Usuario` a um `Produto`
* Possui nota, texto, status e data
* Implementa `Comparable` e `IModeravel`

### `Plataforma`

* Centraliza `usuarios` e `produtos`
* Permite:

  * Adicionar usuários e produtos
  * Buscar produto por nome
  * Listar produtos ordenados
  * Listar e moderar pendências

---

## 🎨 Funcionalidades das Mains

### `MainSimulada`

* Cria produtos, usuários e avalia automaticamente
* Mostra as funcionalidades sem entrada do usuário

### `MainInterativa`

* Permite:

  1. Adicionar/trocar usuário
  2. Adicionar produto
  3. Avaliar produto
  4. Ver pendências
  5. Moderar avaliações pendentes
* Utiliza Scanner para entrada no terminal

---

## 🤷 Relacionamentos entre Classes

* `Produto` <--> `Avaliacao` <--> `Usuario` (N\:N via classe associativa)
* `Plataforma` possui 1\:N com `Produto` e `Usuario`
* `Produto` e `Usuario` compõem suas avaliações

---

## 🔄 Polimorfismo e Interface

* `Produto.exibirDetalhes()` é sobrescrito em `Celular` e `Notebook`
* `IModeravel` é implementado por `Usuario` e `Avaliacao`
* Chamadas polimórficas: `List<IModeravel>` moderadas em lote
