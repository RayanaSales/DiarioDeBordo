<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inserir áudio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="inserirAudio.css">
    </head>
    <body>
        <form action="/DiarioDeBordo_Web2/CriarArquivoServlet?paginaQueCria=audio" method="post"> 
            <div id="containerDeEdicaoPrincipal">

                <div id="campoDeCor">

                    <fieldset>
                        <div id="titulo">
                            <fieldset>
                                <p>Inserir Áudio</p>
                            </fieldset>

                        </div>
                    </fieldset>

                </div>

                <fieldset>

                    <div id="containerDeEdicaoSecundario">
                        <fieldset>

                            <img name="audio" src="http://researchradio.org/wp-content/uploads/2015/06/audio-icon.png" alt="icone de audio"/>
                            <p id="descricao">Descrição  do áudio</p>
                            <div id="campoDescricao">
                                <input type="text" name="descricao" size=70/>
                            </div>

                            <p id="campoLink">Link do Sound cloud</p>
                            <input type="text" name="conteudo" id="linkYoutube" size=70/>

                            <input type="submit" value="Salvar Alterações" id="salvarBotao">
                            <input type="button" value="Descartar" id="descartarBotao">

                        </fieldset>
                    </div>

                </fieldset>

            </div>
        </form>
    </body>
</html>
