<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.com.filmes.dao.FilmeDao" %>
<%@page import="br.com.filmes.model.Filme" %>
<%@page import="java.util.Date"%>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Principal</title>
</head>
<html>
<body>

<style>
    th, td {
       padding: 12px;
    }
</style>
                <div>
                <h2>Cadastrar Novo Filme</h2>
                    <form action="filme" method="post">
                        <label>Nome do Filme:</label> <input type="text" name="nomeFilme" placeholder="Nome do Filme" required/><br><br>
                        <label>Gênero:</label> <input type="text" name="genero" placeholder="Gênero" required/><br><br>
                        <label>Duração:</label> <input type="number" name="duracao" placeholder="Duração em minutos" required/><br><br>
                        <label>Data de Cadastro:</label> <input type="date" name="dataCadastro" required/><br><br>
                        <input type="hidden" name="action" value="cadastrar"/>
                        <input type="submit" value="Cadastrar"/>
                    </form>
                </div>

                <h1 align="center">Lista de Filmes</h1>
                    <table border="1" align="center">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome do filme</th>
                            <th>Gênero</th>
                            <th>Duração (em minutos)</th>
                            <th>Data de cadastro</th>
                            <th>Excluir filme</th>
                            <th>Editar filme</th>
                        </tr>
                    </thead>
                        <%
                            List<Filme> filmes = (List<Filme>) request.getAttribute("filmes");
                            if (filmes != null) {
                                for (Filme filme : filmes) {%>
                                <tbody>
                                   <tr>
                                           <td><%= filme.getId() %></td>
                                           <td><%= filme.getNomeFilme() %></td>
                                           <td><%= filme.getGenero() %></td>
                                           <td><%= filme.getDuracao() %></td>
                                           <td><%= filme.getDataCadastro() %></td>

                                        <td>
                                            <form action="filme" method="post" style="display:inline;">
                                                <input type="hidden" name="id" value="<%= filme.getId() %>"/>
                                                <input type="hidden" name="action" value="excluir"/>
                                                <input type="submit" value="Excluir"/>
                                            </form>
                                        </td>

                                           <td>
                                                <form action="filme" method="post" style="display:flex;">
                                                    <input type="hidden" name="id" value="<%= filme.getId() %>"/>
                                                    <input type="text" name="nomeFilme" value="<%= filme.getNomeFilme() %>"/>
                                                    <input type="text" name="genero" value="<%= filme.getGenero() %>"/>
                                                    <input type="number" name="duracao" value="<%= filme.getDuracao() %>"/>
                                                    <input type="hidden" name="action" value="editar"/>
                                                    <input type="submit" value="Editar"/>
                                                </form>
                                          </td>

                                    </tr>
                                   <%
                                }
                            } else {
                                out.println("<p>Não há filmes disponíveis.</p>");
                            }%>
                        </tr>
                        </tbody>
                </table>

</body>
</html>
