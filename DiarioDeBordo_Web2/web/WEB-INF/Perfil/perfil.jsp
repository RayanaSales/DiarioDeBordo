<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="beanArquivo" class="bancoDeDados.ArquivoDao" />
<jsp:useBean id="beanCapitulo" class="bancoDeDados.CapituloDAO" />
<jsp:useBean id="beanLocale" class="bancoDeDados.LocalizacaoDao" />

<html>    
    <head>
        <title>Perfil</title>
        <meta charset="UTF-8">
        <!-- Material Design Lite -->
        <script src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
        <link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.indigo-deep_orange.min.css" />
        <!-- Material Design icon font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <!-- card -->
        <!-- Material Design icon font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="estiloPerfilCard.css"/>
        <link rel="stylesheet" href="estiloPerfil.css"/>

        <!-- icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.1.2/css/material-design-iconic-font.min.css">
    </head>
    <body>              
        <!-- Uses a header that scrolls with the text, rather than staying
          locked at the top -->
        <div class="mdl-layout mdl-js-layout">
            <header class="mdl-layout__header mdl-layout__header--fixed">
                <div class="mdl-layout__header-row">
                    <!-- Title -->
                    <span class="mdl-layout-title">${ sessionScope['usuarioNome']}</span> <!-- se fizer ${ sessionScope['usuario'].email} funciona -->
                    <!-- Add spacer, to align navigation to the right -->
                    <div class="mdl-layout-spacer"></div>
                    <!-- Navigation -->
                    <nav class="mdl-navigation">
                        <a class="mdl-navigation__link" href="/DiarioDeBordo_Web2/Redirecionador?acao=linhaDoTempo">Linha do tempo</a>
                        <a class="mdl-navigation__link" href="/DiarioDeBordo_Web2/SetaDadosNaSessao">Perfil</a>
                        <a class="mdl-navigation__link" href="/DiarioDeBordo_Web2/Redirecionador?acao=criarCapitulo">Criar capítulo</a>
                        <a class="mdl-navigation__link" href="/DiarioDeBordo_Web2/logoutServlet">Sair</a>
                    </nav>
                </div>
            </header>
            <div class="mdl-layout__drawer">
                <span class="mdl-layout-title">Meus capítulos</span>
                <c:set var="email" value="${ sessionScope['usuario'].email}"/>
                <nav class="mdl-navigation">
                    <c:forEach var="capitulos" items="${beanCapitulo.buscarCapitulosUsuario(email)}"> 
                        <a class="mdl-navigation__link" href="/DiarioDeBordo_Web2/AlteraCapitulo?nome=${capitulos.nome}">${capitulos.nome}</a>                        

                    </c:forEach>
                </nav>
            </div>

            <main class="mdl-layout__content">
                <div>
                    <div class="page-content"><!-- Your content goes here -->
                        <div id="arquivos">
                            <c:forEach var="arquivoAtual" items="${ sessionScope['capituloDaVez'].getLista()}">  
                                <c:choose>
                                    <c:when test="${arquivoAtual.tipo == 'foto'}">                                    
                                        <div class="img">                                                                                                           
                                            <img src="${arquivoAtual.conteudo}" alt="${arquivoAtual.descricao}" height="189" width="335.297"/>
                                        </div>                                     
                                    </c:when>    
                                    <c:when test="${arquivoAtual.tipo == 'foto capa'}">                                    
                                        <div class="img">                                                                                                           
                                            <img src="${arquivoAtual.conteudo}" alt="${arquivoAtual.descricao}" height="189" width="335.297"/>
                                        </div>                                     
                                    </c:when>  
                                    <c:otherwise>                                    
                                        <div class="img">                                        
                                            <iframe width="335.297" height="189" scrolling="no" frameborder="no" src="${arquivoAtual.conteudo}"></iframe>
                                        </div> 
                                    </c:otherwise>              
                                </c:choose>    
                            </c:forEach>
                        </div>
                    </div>

                    <!-- Fim dos arquivos do albúm selecionado-->  

                    <aside id="profile" style='background-image: url("${ sessionScope['capituloDaVez'].fotoCapa}")'>
                       
                        <img src="${ sessionScope['usuario'].fotoPerfil}" />

                        <h2>${ sessionScope['capituloDaVez'].nome}</h2>
                        <p>${ sessionScope['capituloDaVez'].descricao}</p>
                        
                        <p>${ sessionScope['capituloDaVez'].localizacao.pais}</p>
                        <p>${ sessionScope['capituloDaVez'].localizacao.estado}</p>
                        <p>${ sessionScope['capituloDaVez'].localizacao.cidade}</p>

                        <a class="" href="/DiarioDeBordo_Web2/Redirecionador?acao=editarCapitulo">Editar</a>
                        <a class="" href="/DiarioDeBordo_Web2/Redirecionador?acao=criarPost">Postar</a>
                        <a class="" href="/DiarioDeBordo_Web2/Redirecionador?acao=excluirCapitulo">Excluir</a>

                    </aside>
                </div>
            </main>
        </div>
    </body>
</html>