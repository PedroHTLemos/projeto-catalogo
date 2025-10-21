<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cadastrar Item</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>Cadastrar Novo Item</h1>
<a href="${pageContext.request.contextPath}/itensMidia" class="cadastrar-link">Voltar para Lista</a>

<form action="${pageContext.request.contextPath}/cadastrar" method="post" style="max-width:600px;margin:auto;">
    <input type="text" name="titulo" placeholder="Título" required><br><br>
    <input type="text" name="autorDiretor" placeholder="Autor/Diretor" required><br><br>
    <input type="number" name="anoLancamento" placeholder="Ano de Lançamento" required><br><br>
    <input type="text" name="genero" placeholder="Gênero" required><br><br>
    <input type="text" name="tipoMidia" placeholder="Tipo de Mídia" required><br><br>
    <textarea name="sinopse" placeholder="Sinopse" rows="4" style="width:100%;padding:10px;border-radius:5px;border:1px solid #ccc;"></textarea><br><br>

    <label>Avaliação:</label>
    <select name="avaliacao" required>
        <option value="1">1 estrela</option>
        <option value="2">2 estrelas</option>
        <option value="3">3 estrelas</option>
        <option value="4">4 estrelas</option>
        <option value="5">5 estrelas</option>
    </select><br><br>

    <input type="submit" value="Cadastrar">
</form>
</body>
</html>
