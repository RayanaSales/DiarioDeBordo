<%-- 
    Document   : visualizarVideo
    Created on : 06/10/2015, 18:23:49
    Author     : NataliaAmancio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="beanArquivo" class="bancoDeDados.ArquivoDao" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="visualizarFotoVideoAudio.css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <div class="card card-5" >
            <div style="margin-top: 0px; width: 100%; height: 5%; background-color: rgb(63,81,181); color: white;">
                <span style="margin: 600px; line-height: 30px; font-size: 17px; font-weight: bold;">Vídeo</span>
            </div>

            <form id="arquivo">
                <c:forEach var="arquivoAtual" items="${beanArquivo.listarArquivos()}"> 
                    <div class="arquivoSendoExibido">

                        <iframe width="900" height="550" src="https://www.youtube.com/embed/-Wv8bEMqvtE" frameborder="0" allowfullscreen></iframe>

                        <div class="descricaoArquivo">
                            <h5>Descrição</h5>
                            <textarea readonly name="descricao" rows="50" cols="20" form="arquivo">Dean Winchester' é um personagem fictício protagonista da série dramática/paranormal Supernatural, da rede televisiva The CW, criado por Eric Kripke, é ao lado de seu irmão mais novo Sam Winchester (Jared Padalecki) um dos personagens protagonistas da série. Ele é interpretado pelo ator americano Jensen Ackles, e no Brasil, é dublado por Reginaldo Primo. No penúltimo episódio da segunda temporada, Sam Winchester foi morto por um dos soldados de azazel, o que fez com que Dean fizesse um pacto com o demônio da encruzilhada: um ano de vida pela vida de seu irmão. Dean foi morto por um cão demoníaco guiado por Lilith no último episódio da terceira temporada e foi para o inferno, onde lá permaneceu durante 5 meses onde mais tarde foi salvo por um anjo chamado Castiel, que lhe deu uma missão muito importante.</textarea>

                            <a class="btn" href="/DiarioDeBordo_Web2/Redirecionador?acao=editarFoto">Editar</a>
                        </div>
                    </div>
                    <c:forEach/>
                </form>

            </div>

        </body>
    </html>
