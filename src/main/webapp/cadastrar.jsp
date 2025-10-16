<%-- 
    Document   : cadastrar
    Created on : 16 de out. de 2025, 15:15:25
    Author     : pedro
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar Item</title>
</head>
<body>
<h2>Cadastro de Item</h2>
<form action="items" method="post">
    Nome: <input type="text" name="nome" required/><br/><br/>
    Descrição: <input type="text" name="descricao" required/><br/><br/>
    <input type="submit" value="Salvar"/>
</form>
<br/>
<a href="items?action=list">Voltar para Lista</a>
</body>
</html>
