<%-- 
    Document   : sucessoautenticacao
    Created on : 10/05/2022, 17:34:38
    Author     : proft
--%>

<%@page import="Model.Projetos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/NovoProjeto.css"/>
    </head>
    <body>
        <div class="popup_novoProjeto">
            <div class="popup-content">
                <h2>Novo Projeto</h2>

                    <form action="controller_projetos" method="GET">
                        
                        <button class="close" onclick="fecharPopupNovoProjeto()">×</button>

                        

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
                    </form>
            </div>
        </div>
    </body>
</html>
