<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inserir foto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="inserirFoto.css">
    </head>

    <body>       
        <form action="/DiarioDeBordo_Web2/CriarImagemServlet" method="post"> 
            <div id="containerDeEdicaoPrincipal">
                <div id="campoDeCor">

                    <fieldset>
                        <div id="titulo">
                            <fieldset>
                                <p>Inserir dados da foto</p>
                            </fieldset>
                        </div>
                    </fieldset>

                </div>
                <fieldset>
                    <div id="containerDeEdicaoSecundario">
                        <fieldset>

                            <img name="camera" src="http://pocono-motel.com/images/page1-img4.jpg" alt="icone da camera"/>
                            <p id="descricao">Descrição  da foto</p>
                            <div id="campoDescricao">
                                <input type="text" name="descricao" size="70"/>
                            </div>
                            <p id="descricao">Nome foto</p>
                            <input type="text" name="nome" size="70"/><br><br>                            
                            <input type="checkbox" name="capaAlbum" value="capa" checked> Capa do capitulo <br>                            
                            <input type="submit" value="Salvar Alterações" id="salvarBotao">                          
                        </fieldset>
                    </div>
                </fieldset>
            </div>  
        </form>     
    </body>
</html>
