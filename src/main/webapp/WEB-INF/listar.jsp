<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista de Itens</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f7fa;
            margin: 0;
            padding: 20px;
            color: #333;
        }
        h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 30px;
        }
        .cadastrar-link {
            display: inline-block;
            margin-bottom: 20px;
            padding: 10px 20px;
            background-color: #27ae60;
            color: white;
            border-radius: 6px;
            font-weight: bold;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        .cadastrar-link:hover {
            background-color: #1e8449;
        }
        .busca-form {
            text-align: center;
            margin-bottom: 25px;
        }
        .busca-form input[type="text"],
        .busca-form select {
            padding: 10px;
            width: 200px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-right: 10px;
        }
        .busca-form input[type="submit"] {
            padding: 10px 20px;
            border: none;
            background-color: #2980b9;
            color: white;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .busca-form input[type="submit"]:hover {
            background-color: #1f618d;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 1200px;
            margin: auto;
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
        }
        th {
            background: linear-gradient(to right, #2980b9, #6dd5fa);
            color: white;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f2f6fa;
        }
        tr:hover {
            background-color: #d6eaf8;
        }
        .btn {
            padding: 6px 12px;
            background-color: #2980b9;
            color: white;
            border-radius: 5px;
            text-decoration: none;
            font-size: 0.9em;
            margin-right: 5px;
            display: inline-block;
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #1f618d;
        }
        .btn-delete {
            background-color: #c0392b;
        }
        .btn-delete:hover {
            background-color: #922b21;
        }
        .avaliacao {
            white-space: nowrap;
            color: #f1c40f;
            font-size: 1.1em;
        }
    </style>
</head>
<body>

<h1>Itens do Catálogo</h1>

<a href="${pageContext.request.contextPath}/cadastrar" class="cadastrar-link">Cadastrar Novo Item</a>

<form action="${pageContext.request.contextPath}/itensMidia" method="get" class="busca-form">
    <input type="text" name="busca" placeholder="Buscar por título ou autor/diretor" value="${param.busca}">
    <select name="genero">
        <option value="">Todos os gêneros</option>
        <option value="Romance" ${param.genero == 'Romance' ? 'selected' : ''}>Romance</option>
        <option value="Drama" ${param.genero == 'Drama' ? 'selected' : ''}>Drama</option>
        <option value="Comédia" ${param.genero == 'Comédia' ? 'selected' : ''}>Comédia</option>
        <option value="Ficção" ${param.genero == 'Ficção' ? 'selected' : ''}>Ficção</option>
        <option value="Ação" ${param.genero == 'Ação' ? 'selected' : ''}>Ação</option>
        <option value="Aventura" ${param.genero == 'Aventura' ? 'selected' : ''}>Aventura</option>
        <option value="Documentário" ${param.genero == 'Documentário' ? 'selected' : ''}>Documentário</option>
    </select>
    <input type="submit" value="Buscar">
</form>

<table>
    <tr>
        <th>#</th>
        <th>Título</th>
        <th>Autor/Diretor</th>
        <th>Ano</th>
        <th>Gênero</th>
        <th>Tipo</th>
        <th>Sinopse</th>
        <th>Avaliação</th>
        <th>Detalhes</th>
        <th>Ações</th>
    </tr>
    <c:forEach var="item" items="${itens}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${item.titulo}</td>
            <td>${item.autorDiretor}</td>
            <td>${item.anoLancamento}</td>
            <td>${item.genero}</td>
            <td>${item.tipoMidia}</td>
            <td>${item.sinopse}</td>
            <td class="avaliacao">
                <c:forEach begin="1" end="5" var="i">
                    <c:choose>
                        <c:when test="${i <= item.avaliacao}">&#9733;</c:when>
                        <c:otherwise>&#9734;</c:otherwise>
                    </c:choose>
                </c:forEach>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/detalhes?id=${item.id}" class="btn">Ver Detalhes</a>
            </td>
            <td style="display: flex; gap: 5px;">
                <a href="${pageContext.request.contextPath}/editar?id=${item.id}" class="btn">Editar</a>
                <a href="${pageContext.request.contextPath}/excluir?id=${item.id}" class="btn btn-delete">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
