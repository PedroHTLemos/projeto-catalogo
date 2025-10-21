<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Editar Item</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>Editar Item</h1>
<a href="${pageContext.request.contextPath}/itensMidia" class="cadastrar-link">Voltar para Lista</a>

<form action="${pageContext.request.contextPath}/editar" method="post" style="max-width:600px;margin:auto;">
    <input type="hidden" name="id" value="${item.id}">
    <input type="text" name="titulo" value="${item.titulo}" placeholder="Título" required><br><br>
    <input type="text" name="autorDiretor" value="${item.autorDiretor}" placeholder="Autor/Diretor" required><br><br>
    <input type="number" name="anoLancamento" value="${item.anoLancamento}" placeholder="Ano de Lançamento" required><br><br>
    <input type="text" name="genero" value="${item.genero}" placeholder="Gênero" required><br><br>
    <input type="text" name="tipoMidia" value="${item.tipoMidia}" placeholder="Tipo de Mídia" required><br><br>
    <textarea name="sinopse" placeholder="Sinopse" rows="4" style="width:100%;padding:10px;border-radius:5px;border:1px solid #ccc;">${item.sinopse}</textarea><br><br>

    <label>Avaliação:</label>
    <select name="avaliacao" required>
        <option value="1" ${item.avaliacao == 1 ? 'selected' : ''}>1 estrela</option>
        <option value="2" ${item.avaliacao == 2 ? 'selected' : ''}>2 estrelas</option>
        <option value="3" ${item.avaliacao == 3 ? 'selected' : ''}>3 estrelas</option>
        <option value="4" ${item.avaliacao == 4 ? 'selected' : ''}>4 estrelas</option>
        <option value="5" ${item.avaliacao == 5 ? 'selected' : ''}>5 estrelas</option>
    </select><br><br>

    <input type="submit" value="Salvar Alterações">
</form>
</body>
</html>
