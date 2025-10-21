<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detalhes do Item</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <style>
        .detalhes-container {
            max-width: 700px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        .detalhes-container h2 {
            color: #2980b9;
            margin-bottom: 15px;
        }
        .detalhes-container p {
            margin: 8px 0;
        }
        .estrelas {
            color: #f1c40f;
            font-size: 1.2em;
            display: inline-block;
        }
    </style>
</head>
<body>

<h1>Detalhes do Item</h1>

<a href="${pageContext.request.contextPath}/itensMidia" class="cadastrar-link">Voltar para Lista</a>

<div class="detalhes-container">
    <h2>${item.titulo}</h2>
    <p><strong>Autor/Diretor:</strong> ${item.autorDiretor}</p>
    <p><strong>Ano:</strong> ${item.anoLancamento}</p>
    <p><strong>Gênero:</strong> ${item.genero}</p>
    <p><strong>Tipo:</strong> ${item.tipoMidia}</p>
    <p><strong>Sinopse:</strong> ${item.sinopse}</p>
    <p><strong>Avaliação:</strong>
        <span class="estrelas">
            <c:forEach begin="1" end="5" var="i">
                <c:choose>
                    <c:when test="${i <= item.avaliacao}">&#9733;</c:when>
                    <c:otherwise>&#9734;</c:otherwise>
                </c:choose>
            </c:forEach>
        </span>
    </p>
</div>

</body>
</html>
