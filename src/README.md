# Sistema de Biblioteca - Mini Projeto

## Descrição do Projeto

Este projeto é um sistema de gerenciamento de uma biblioteca simples, desenvolvido em Java.  
Ele permite cadastrar livros e usuários, emprestar e devolver livros, pesquisar livros por autor ou faixa de preço,
listar livros disponíveis e identificar o livro mais barato.  
Os dados são persistidos em arquivo para manter as informações entre execuções.

O sistema segue o padrão MVC:

- **Biblioteca**: classe que implementa a interface `BibliotecaGerenciador` e contém toda a lógica principal.
- **Controllers**: classes que conectam a GUI às operações da Biblioteca.
- **GUI (Java Swing)**: interface gráfica com menu e botões que permitem acessar todas as funcionalidades do sistema.

---

## Funcionalidades Implementadas

1. **Cadastrar livro** – adiciona um novo livro à biblioteca (com verificação de código duplicado).
2. **Remover livro** – remove um livro existente pelo código.
3. **Pesquisar livros por autor** – retorna todos os livros de um determinado autor.
4. **Listar livros disponíveis** – exibe todos os livros que não estão emprestados.
5. **Livro mais barato** – retorna o livro com menor preço na biblioteca.
6. **Emprestar livro** – registra o empréstimo de um livro para um usuário.
7. **Devolver livro** – devolve um livro que estava emprestado.
8. **Cadastrar usuário** – adiciona novos usuários à biblioteca (com verificação de duplicidade).
9. **Buscar livros por faixa de preço** – retorna livros cujo preço esteja entre valores mínimo e máximo.
10. **Salvar dados** – persiste todos os livros, usuários e empréstimos em arquivo.

> Obs.: A persistência também permite que os dados sejam carregados posteriormente com o método `carregarDados()` (ainda
> em implementação).

---

## Funcionalidades Futuras / Melhorias

- Implementar **carregar dados** automaticamente ao iniciar o sistema.
- Adicionar **validação de entradas** na GUI (evitar campos vazios ou valores inválidos).
- Melhorar a interface gráfica com **tabelas** para exibir listas de livros e empréstimos.
- Implementar **relatórios**, como livros mais emprestados ou usuários com mais empréstimos.
- Permitir **remover usuários** da biblioteca e validar se possuem livros emprestados.
- Adicionar **busca avançada** por título ou parte do nome do autor.
- Refatorar métodos longos na classe `Biblioteca` para aumentar a coesão e reduzir acoplamento.

---

## Tecnologias e Conceitos Utilizados

- Linguagem Java 17+
- Java Swing para interface gráfica
- Expressões Lambda e Streams para manipulação de coleções
- Persistência de dados com `ObjectOutputStream` e `ObjectInputStream`
- Padrão de projeto MVC (Model-View-Controller)
- Testes automatizados com JUnit 4/5

---

## Estrutura do Projeto
