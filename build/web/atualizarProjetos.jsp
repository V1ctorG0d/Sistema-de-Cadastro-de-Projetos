<%-- 
    Document   : erroautenticacao
    Created on : 10/05/2022, 17:34:59
    Author     : proft
--%>

<%@page import="Model.Projetos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/AtualizarProjeto.css"/>
    </head>
    <body>
        <div class="popup_novoProjeto">
            <div class="popup-content">
                <h2>Atualizar Projeto</h2>

                <%
                    Projetos p = (Projetos) request.getAttribute("p");
                %>
                    <form action="controller_projetos" method="GET">
                        
                        <button class="close" onclick="fecharPopupNovoProjeto()">×</button>
                        <!--<input type="hidden" name="action" value="cadastrar">-->

                        <label>Nome:</label>
                        <input type="text" name="nome" value="<%out.print(p.getId());%>" >

                        <label>Descrição:</label>
                        <input type="text" name="descricao" value="<%out.print(p.getDescricao());%>" >

                        <label>Cliente:</label>
                        <input type="text" name="cliente" value="<%out.print(p.getCliente());%>" >

                        <label>Data de Início:</label>
                        <input type="date" name="dataInicio" value="<%out.print(p.getDatainicio());%>" >

                        <label>Data de Fim Prevista:</label>
                        <input type="date" name="dataFim" value="<%out.print(p.getDatafimprevista());%>" >

                        <label>Responsável:</label>
                        <input type="text" name="responsavel" value="<%out.print(p.getResponsavel());%>" >

                        <label>Status:</label>
                        <select name="Status">
                            <option value="<%out.print(p.getStatus());%>"><%out.print(p.getStatus());%></option>
                            <option value="Em Andamento">Em Andamento</option>
                            <option value="Concluido">Concluído</option>
                            <option value="Pausado">Pausado</option>
                        </select>

                        <label>Orçamento:</label>
                        <input type="number" name="orcamento" value="<%out.print(p.getOrcamento());%>" required>

                        <label>Prioridade:</label>
                        <select name="Prioridade">
                            <option value="<%out.print(p.getPrioridade());%>"><%out.print(p.getPrioridade());%></option>
                            <option value="Baixa">Baixa</option>
                            <option value="Média">Média</option>
                            <option value="Alta">Alta</option>
                        </select>

                        <input type="submit" name="op" value="ATUALIZAR" 
                               onclick="return confirm('Tem certeza que deseja atualizar o projeto <%out.print(p.getNome());%>?');">
                        <%
                           String msg = (String) request.getAttribute("message");
                        %>
                        <h3><%out.println(msg);%> realizado com sucesso.</h3>
                    </form>
            </div>
        </div>
    </body>
</html>
