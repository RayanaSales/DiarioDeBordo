<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inserir vídeo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="inserirVideo.css">
    </head>
    <body>  
        <form action="/DiarioDeBordo_Web2/CriarArquivoServlet?paginaQueCria=video" method="post"> 

            <div id="containerDeEdicaoPrincipal">
                <div id="campoDeCor">

                    <fieldset>
                        <div id="titulo">
                            <fieldset>
                                <p>Inserir Vídeo</p>
                            </fieldset>
                        </div>
                    </fieldset>

                </div>

                <fieldset>
                    <div id="containerDeEdicaoSecundario">
                        <fieldset>

                            <img name="video" src="https://deznartq8.files.wordpress.com/2014/01/cropped-cropped-video-play-icon.png" alt="icone de video"/>
                            <p id="descricao">Descrição  do vídeo</p>
                            <div id="campoDescricao">
                                <input type="text" name="descricao" size="70"/>
                            </div>

                            <p id="campoLink">Link do YouTube</p>
                            <input type="text" name="conteudo" id="linkYoutube" size="70"/>
                            
                            <input type="submit" value="Salvar Alterações" id="salvarBotao">
                            <input type="button" value="Descartar" id="descartarBotao">
                        </fieldset>
                    </div>
                </fieldset>
            </div>  
        </form>
    </body>
</html>
