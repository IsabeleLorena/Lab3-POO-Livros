# SISTEMA DE LIVROS 📚
## Descrição do Projeto
Este projeto visa oferecer aos usuários a funcionalidade de gerenciar uma biblioteca pessoal, possibilitando a adição, busca, atualização e exclusão de informações relacionadas aos livros. Funciona como uma plataforma de controle de livros, proporcionando uma experiência prática e organizada para o usuário. Projeto desenvolvido para a disciplina de Porgramação Orientada a Objeto, da Universidade São Francisco (USF).



### Funcionalidades Principais ⚙️
- `Inserir Livros:` Permite a inclusão de informações de Notas Fiscais, ampliando o banco de dados durante a execução do servidor.
- `Atualizar informações:` Possibilita a manipulação dos dados armazenados, oferecendo recursos para análise e processamento eficiente.
- `Excluir Livros:` Permite a atualização ou exclusão de informações de Notas Fiscais específicas, conferindo flexibilidade na gestão de dados.
- `Buscar Livros:` Oferece funcionalidade de autenticação para garantir a integridade e segurança das informações armazenadas.

## Desenvolvedores 💻
<a href="https://picasion.com/"><img src="https://i.picasion.com/pic92/546c2307c356cd9f4d6f6f6ac8ac4796.gif" width="150" height="150" border="0" alt="https://picasion.com/" /></a><br />
### Isabele Lorena Moreira e Silva - RA: 202115817

## Tecnologias Empregadas 🖥️
- `Linguagem de Programação:` Java <img align="center" alt="Rafa-Spri" height="50" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" />
- `Framework:` Spring Boot   <img align="center" alt="Rafa-Spri" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" >
- `Banco de Dados:` PostgreSQL <img align="center" alt="Rafa-Spri" height="40" width="60" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" />

## Arquitetura 📝
A arquitetura do projeto segue os princípios da Programação Orientada a Objetos (POO), organizando o código em classes e módulos distintos. A estrutura é composta por controladores, serviços, modelos e classes de exceção, cada um desempenhando um papel específico no funcionamento da aplicação.
### Controlador (SistemaLivrosController):
- `Define operações RESTful para manipulação de livros.`
- `@PostMapping("/inserir"):` Adiciona um novo livro à biblioteca, verificando se o livro já existe antes de salvar.
- `@GetMapping("/todos"):` Retorna todos os livros presentes na biblioteca.
- `@GetMapping("/{id}"):` Retorna as informações de um livro específico com base no ID fornecido.
- `@DeleteMapping("/{id}"):` Exclui um livro com base no ID fornecido.
- `@PutMapping("/{id}"):` Atualiza as informações de um livro com base no ID fornecido.
### Modelo (SistemaLivrosModel):
Entidade JPA que representa a estrutura de dados dos livros na base de dados. Possui campos como ID, nome do livro e autor.
### DTO (SistemaLivrosDTO):
Objeto de transferência de dados (DTO) que contém informações necessárias para criar ou atualizar um livro, como nome do livro e autor.
### Repositório (SistemaLivrosRepository):
- Interface que estende JpaRepository, fornecendo métodos para interagir com a base de dados.
- existeNomeLivro(String nomeLivro): Consulta personalizada para verificar se um livro com o mesmo nome já existe.
### Serviço (SistemaLivroService):
- Gerencia a lógica de negócios para manipulação da biblioteca pessoal.
- save(SistemaLivrosModel sistemaLivrosModel): Salva um novo livro na biblioteca pessoal.
- existeNomeLivro(String nomeLivro): Verifica se um livro com o mesmo nome já faz parte da biblioteca do usuário.
- findAll(): Retorna todos os livros presentes na biblioteca pessoal.
- findById(Long id): Retorna as informações detalhadas de um livro com base no ID fornecido.
- delete(SistemaLivrosModel sistemaLivrosModel): Exclui um livro da biblioteca pessoal do usuário.

### Tratamento de Exceções (IdNotFoundException):
Construtor que recebe uma mensagem como parâmetro, a qual será utilizada para descrever a exceção. Ao ser lançada, esta exceção fornecerá informações contextualizadas sobre o motivo da não localização do ID.

## Funcionalidade ⚙️
### CRUD:
### POST:
- O método `saveLivros` faz a criação de novos livros no sistema, através do endpoint `/inserir`. 
#### JSON: `{"nameLivro": "", "autor": ""}`
### Exemplo de seveLivros
![Alt text](src\main\java\com\api\LivrosPoo\imagens\POST.png)
#### ERRO: Ao tentar adicionar um livro com o mesmo titulo, ele retorna uma exceção.
![Alt text](src\main\java\com\api\LivrosPoo\imagens\livrojaexiste.png)

### GET:
- O metodo `getTodos` e `getUmLivro` retorna a lista já salva de livros adicionados.
    - `/todos:` Retorna todos os livros em uma lista.
  ![Alt text](src\main\java\com\api\LivrosPoo\imagens\gettodos.png)
    - `/{id}:` Retorna o livro de acordo com seu id específico.
  ![Alt text](src\main\java\com\api\LivrosPoo\imagens\get id.png)
#### ERRO: Caso seja pesquisado um id que não existe, ele retorna uma exceção:
![Alt text](src\main\java\com\api\LivrosPoo\imagens\erroid.png)

### PUT:
- O método `updateLivros` faz a atualização de informações caso necessárias.
#### Atualizar Livros
![Alt text](src\main\java\com\api\LivrosPoo\imagens\put.png)
#### Erro: Tentar atualizar um livro com id que não exite:
![Alt text](src\main\java\com\api\LivrosPoo\imagens\putid.png)

#### DELETE:
- O metodo `deleteLivro` faz a exclusão de livros e autores existentes na base de dados.
    - `/{id}:` Exclui com base no id informado.
![Alt text](src\main\java\com\api\LivrosPoo\imagens\delete.png)
#### ERRO: Ao tentar apagar um id não existente, recebe uma exceção:
![Alt text](src\main\java\com\api\LivrosPoo\imagens\errodelte.png)


