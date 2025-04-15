# Library - CRUD de Livros com Servlets Individuais (JAVA)

## Descrição

O projeto **Library** é um CRUD (Create, Read, Update, Delete) de livros, desenvolvido com Servlets em Java, que permite a gestão de livros em uma aplicação web simples. O sistema oferece funcionalidades básicas de cadastro, listagem, edição e exclusão de livros. Este projeto é uma introdução ao uso de Servlets para manipulação de dados em aplicações web.

## Funcionalidades

- **Cadastro de Livro**: Permite adicionar novos livros ao banco de dados.
- **Listagem de Livros**: Exibe todos os livros cadastrados.
- **Edição de Livro**: Permite a edição dos detalhes de um livro existente.
- **Exclusão de Livro**: Remove um livro do banco de dados.

## Tecnologias

- **Java**: Linguagem principal utilizada.
- **Servlets**: Para a implementação das funcionalidades do backend.
- **JSP (JavaServer Pages)**: Para a criação das páginas web dinâmicas.
- **Bootstrap**: Framework CSS para estilização das páginas.
- **Eclipse**: IDE utilizada para o desenvolvimento do projeto.


## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
/src/main
  /java/br/edu/ifdp/books        // Contém os Servlets que processam as requisições e a classe Livro
/webapp
  /index.html                  // Página principal da aplicação
  /WEB-INF
    /web.xml                    // Arquivo de configuração do servlet e do mapeamento de URL
```

## Como Rodar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/library-crud.git
   ```

2. Importe o projeto no Eclipse.

3. Certifique-se de que o Apache Tomcat está configurado no Eclipse.

4. Execute o servidor no Eclipse e acesse a aplicação via navegador no endereço:
   ```text
   http://localhost:8080/library-crud
   ```

5. Agora você pode acessar as funcionalidades de **Cadastro**, **Listagem**, **Edição** e **Exclusão** de livros.

## Como Contribuir

1. Faça o fork do repositório.
2. Crie uma branch para a sua feature (ex: `git checkout -b minha-feature`).
3. Commit suas mudanças (`git commit -am 'Adicionando minha feature'`).
4. Push para a branch (`git push origin minha-feature`).
5. Abra um Pull Request.
