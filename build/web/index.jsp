<%-- 
    Document   : indexjsp
    Created on : 10/05/2022, 17:21:08
    Author     : proft
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Projetos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/Home.css"/>
    </head>
    <body>
        <header>
            <h2>Projetos da Empresa</h2>
        </header>
        
        <%
            List<Projetos> proj = (List<Projetos>) request.getAttribute("proj");
        %>
        
        <main>
            <div>
                <button id="BtnCadastrar" name="Button" value="CADASTRAR">
                    <img src="images/registrar.svg" alt="Cadastrar Projetos">
                </button>
          
                <div class="search-container">
                    <input name="InputID" type="search" placeholder="Busque pelo ID">
                    <button type="submit" name="op" value="PESQUISARID" title="PesquisarID">
                        <img src="images/pesquisarID.svg" alt="PesquisarID" width="20">
                    </button>
                </div>
               
            </div>
            <table>
                <thead>
                  <tr>
                    <th>id</th>
                    <th>Nome</th>
                    <th>Descricao</th>
                    <th>Cliente</th>
                    <th>Data de Inicio</th>
                    <th>Data de Fim Prevista</th>
                    <th>Responsável</th>
                    <th>Status</th>
                    <th>Orçamento</th>
                    <th>Prioridade</th>
                    <th>Ações</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                        if (proj != null) { 
                           for (Projetos p : proj) {
                    %>
                    <tr>
                      <td><%out.print(p.getId());%></td>
                      <td><%out.print(p.getNome());%></td>
                      <td><%out.print(p.getDescricao());%></td>
                      <td><%out.print(p.getCliente());%></td>
                      <td><%out.print(p.getDatainicio());%></td>
                      <td><%out.print(p.getDatafimprevista());%></td>
                      <td><%out.print(p.getResponsavel());%></td>
                      <td><%out.print(p.getStatus());%></td>
                      <td><%out.print(p.getOrcamento());%></td>
                      <td><%out.print(p.getPrioridade());%></td>
                      <td>
                        <form action="controller_projetos" method="POST" style="display:inline;">
                          
                          <input type="hidden" name="id" value="<%= p.getId() %>">
                          
                          <button id="BtnAtualizar" type="submit" name="Button" value="EDITAR" title="Editar">
                              <img src="images/editar.svg" alt="Editar" width="20">
                          </button>
                          
                          <button type="submit" name="op" value="DELETAR" title="Deletar"
                                  onclick="return confirm('Tem certeza que deseja deletar o projeto <%out.print(p.getNome());%>?');">
                              <img src="images/deletar.svg" alt="Deletar" width="20">
                          </button>
                          
                        </form>
                      </td>
                    </tr>
                    <% 
                           } 
                        } else {
                            
                    %>
                    <tr>
                        <td colspan="10">Nenhum projeto encontrado.</td>
                    </tr>
                    <%
                        } 
                    %>
                  
                </tbody>
            </table>
        </main>
        <footer>
            
        </footer>
                    
        <script src="Script/popup_NovoProjeto.js"></script>
        <script src="Script/popup_AtualizarProjeto.js.js"></script>
        
        
        
        
        
        
        
        
<!--       <h2>Novo Projeto</h2>

            <form action="controller_projetos" method="GET">

                <input type="hidden" name="action" value="cadastrar">

                <label>Nome:</label>
                <input type="text" name="nome" >

                <label>Descrição:</label>
                <input type="text" name="descricao" >

                <label>Cliente:</label>
                <input type="text" name="cliente" >

                <label>Data de Início:</label>
                <input type="date" name="dataInicio" >

                <label>Data de Fim Prevista:</label>
                <input type="date" name="dataFim" >

                <label>Responsável:</label>
                <input type="text" name="responsavel" >

                <label>Status:</label>
                <select name="Status">
                    <option value="nulo">Qual o Status do Projeto?</option>
                    <option value="Em Andamento">Em Andamento</option>
                    <option value="Concluido">Concluído</option>
                    <option value="Pausado">Pausado</option>
                </select>

                <label>Orçamento:</label>
                <input type="number" name="orcamento" required>

                <label>Prioridade:</label>
                <select name="Prioridade">
                    <option value="nulo">Qual a Prioridade do Projeto?</option>
                    <option value="Baixa">Baixa</option>
                    <option value="Média">Média</option>
                    <option value="Alta">Alta</option>
                </select>

                <input type="submit" name="op" value="CADASTRAR">
                <%
                   String msg = (String) request.getAttribute("message");
                %>
                <h3><%out.println(msg);%> realizado com sucesso.</h3>
            </form>-->
        
        
        
        
        
        
        
        
        
        
<!--        <h1>Teste SQL Injection</h1>
        <form action="Controller_Autenticacao" method="post">
            <BR>
            Login......: <input type="text" name="txtlogin"><BR>
            Senha......: <input type="text" name="txtsenha"><BR>
            <BR>
            <input type="submit" name="operacao" value="Login"> 
        </form>-->
    </body>
</html>