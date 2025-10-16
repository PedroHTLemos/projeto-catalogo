<%-- 
    Document   : listar
    Created on : 16 de out. de 2025, 15:14:46
    Author     : pedro
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pedro.catalogo.model.Item" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Lista de Itens</title>
</head>
<body>
<h2>Itens Cadastrados</h2>
<a href="items?action=new">Cadastrar Novo Item</a>
<br/><br/>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
    </tr>
    <%
        List<Item> itens = (List<Item>) request.getAttribute("itens");
        if (itens != null) {
            for (Item item : itens) {
    %>
    <tr>
        <td><%= item.getId() %></td>
        <td><%= item.getNome() %></td>
        <td><%= item.getDescricao() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>

