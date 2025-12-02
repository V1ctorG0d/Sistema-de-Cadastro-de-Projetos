# Sistema de Cadastro de Projetos (SQLInjection)

Projeto simples em Java EE (JSP/Servlets) para gerenciar projetos de uma empresa — CRUD básico com acesso a banco MySQL.

> Observação: Este projeto contém código educacional. Considere as seções de segurança para mitigar vulnerabilidades (ex.: SQL Injection).

## Estrutura do projeto

- `src/java/Model/Projetos.java` — Classe que representa a entidade `Projetos`.
- `src/java/DAO/ProjetosDAO.java` — Camada de acesso a dados com operações CRUD.
- `src/java/Controller/controller_projetos.java` — Servlet para controlar requisições (cadastrar, deletar, editar, atualizar, buscar por ID e listar).
- `src/java/util/ConexaoBanco.java` — Classe utilitária para obter conexão MySQL.
- `web/` — Páginas JSP e recursos estáticos (CSS/JS/Imagens).

## Funcionalidades

- Listar todos os projetos
- Cadastrar novo projeto
- Editar/atualizar projeto
- Deletar projeto
- Pesquisar por ID

## Requisitos

- Java 8+ (recomendado 11+)
- Maven ou Ant (o projeto parece construído com Ant/NB)
- MySQL Server
- IDE (NetBeans, Eclipse, IntelliJ) com suporte a JSP/Servlets

## Configuração do banco de dados

- Banco: MySQL
- Nome do banco (por padrão na aplicação): `db_projetos`
- Usuário padrão na configuração: `root` com senha vazia. (Veja `src/java/util/ConexaoBanco.java`)

Exemplo de tabela SQL (crie-o no `db_projetos`):

```
CREATE TABLE projetos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao TEXT,
    cliente VARCHAR(255),
    datainicio DATE,
    datafimprevista DATE,
    responsavel VARCHAR(255),
    status VARCHAR(50),
    orcamento DECIMAL(10,2),
    prioridade VARCHAR(50)
);
```

## Como executar

1. Ajuste a configuração de conexão em `src/java/util/ConexaoBanco.java` conforme seu ambiente (URL, usuário, senha).
2. Importe o projeto em sua IDE Java (NetBeans, Eclipse ou IntelliJ) como um projeto web.
3. Compile e rode em um servidor compatível (Tomcat, GlassFish, etc.).
4. Abra no navegador: `http://localhost:8080/<context-root>/index.jsp`

> Dica: `context-root` depende das configurações do seu servidor/IDE. Em NetBeans, normalmente é o nome do projeto.

## Observações de Segurança ⚠️

- O projeto utiliza `PreparedStatement` na camada DAO, o que ajuda a proteger contra SQL Injection, mas verifique se todas as entradas são tratadas corretamente.
- Dicas de melhorias:
  - Validar e sanitizar entradas no servidor (ex.: checar tamanho, tipos, padrões de dados).
  - Usar autenticação e controle de acesso para as operações (logins, roles).
  - Configurar credenciais do banco com usuário com permissões mínimas.
  - Não deixe `root` sem senha em produção. Utilize variáveis de ambiente ou um arquivo de configuração protegido para credenciais.
  - Implementar mensagens de erro amigáveis ao usuário sem expor informações sensíveis do sistema.

## Melhorias sugeridas 💡

- Migrar para um framework MVC moderno (Spring Boot + Thymeleaf ou Spring MVC) para facilitar manutenção.
- Utilizar JPA/Hibernate para abstração do acesso a dados.
- Implementar testes automatizados (unidade e integração).
- Adicionar tratamento melhor de erros e logs.
