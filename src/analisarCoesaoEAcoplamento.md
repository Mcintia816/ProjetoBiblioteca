# Análise de Coesão e Acoplamento do Sistema Biblioteca

## 1. Coesão das classes

- **Livro:**
    - Alta coesão. Guarda apenas informações do livro: código, título, autor, preço e status de empréstimo.
    - Métodos: `getCodigo`, `getTitulo`, `getAutor`, `getPreco`, `isEmprestado`, `setEmprestado`.

- **Usuario:**
    - Alta coesão. Guarda apenas informações do usuário: id e nome.
    - Métodos: `getId`, `getNome`, `setId`, `setNome`.

- **Emprestimo:**
    - Média coesão. Guarda dados de empréstimos (`codigo`, `livro`, `usuario`, datas), mas não controla lógica de empréstimo/devolução.
    - Métodos: `getLivro`, `getDataEmprestimo`, `getDataDevolucao`, `setDataDevolucao`.

- **GravadorDeDados:**
    - Alta coesão. Faz apenas persistência de dados (`gravarDados`, `recuperarDados`).

- **Biblioteca:**
    - Média-baixa coesão. Tem múltiplas responsabilidades:
        - Gerenciar livros (`cadastrarLivro`, `removerLivro`, `pesquisarLivrosDoAutor`, `livrosDisponiveis`, `livroMaisBarato`, `buscarPorPreco`)
        - Gerenciar usuários (`cadastrarUsuario`)
        - Gerenciar empréstimos (`emprestarLivro`, `devolverLivro`)
        - Persistência (`salvarDados`, `carregarDados`)
    - Possível melhoria: separar responsabilidades em subcomponentes (ex: `GerenciadorLivros`, `GerenciadorUsuarios`, `GerenciadorEmprestimos`).

---

## 2. Acoplamento das classes

- **Biblioteca ↔ Livro / Usuario / Emprestimo / GravadorDeDados:**
    - Acoplamento moderado, pois depende diretamente dessas classes.
    - Alterações nessas classes podem impactar `Biblioteca`.

- **GravadorDeDados ↔ Biblioteca:**
    - Baixo acoplamento; apenas persiste objetos.

- **Uso de interface `BibliotecaGerenciador`:**
    - Reduz acoplamento. Permite trocar a implementação da biblioteca sem afetar código cliente.

- **Dependência entre métodos:**
    - `emprestarLivro` e `devolverLivro` acessam diretamente atributos de `Livro` e `Usuario`, aumentando acoplamento entre objetos.
    - `salvarDados` e `carregarDados` dependem de `GravadorDeDados`.

---

## 3. Possíveis melhorias (Bad Smells)

- **God Class:** `Biblioteca` faz muitas funções. Dividir responsabilidades aumenta a manutenibilidade.
- **Feature Envy:** métodos que manipulam atributos de outras classes (`emprestarLivro`) podem ter parte da lógica movida para `Emprestimo` ou sub-gerenciadores.
- **Long Method / Long Class:** métodos que crescerem podem se tornar difíceis de manter.
- **Integração de persistência:** `carregarDados()` ainda não está implementado; isso aumenta o acoplamento com `GravadorDeDados` se não for bem encapsulado.

---

## 4. Conclusão

- O sistema funciona e atende parte significativa dos requisitos do projeto.
- Classes de entidades (`Livro`, `Usuario`) têm alta coesão e baixo acoplamento.
- A classe `Biblioteca` funciona como fachada, mas possui múltiplas responsabilidades; melhorar coesão e reduzir acoplamento aumentaria manutenibilidade.
- Implementar interface gráfica e completar persistência (`carregarDados`) são próximos passos importantes.