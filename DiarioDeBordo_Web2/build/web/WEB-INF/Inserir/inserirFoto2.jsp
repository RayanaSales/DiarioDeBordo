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
        <form action="/DiarioDeBordo_Web2/ArmazenaImagem" method="post" enctype="multipart/form-data"> 
            <div id="containerDeEdicaoPrincipal">
                <div id="campoDeCor">
                    <fieldset>
                        <div id="titulo">
                            <fieldset>
                                <p>Inserir foto</p>
                            </fieldset>
                        </div>
                    </fieldset>
                </div>
                <fieldset>
                    <div id="containerDeEdicaoSecundario">
                        <fieldset>
                            <img name="camera" src="http://pocono-motel.com/images/page1-img4.jpg" alt="icone da camera"/>                            
                            <input type="file" id="myFile" multiple="multiple" name="file">
                            <input type="submit" value="Salvar Alterações" id="salvarBotao">                          
                        </fieldset>
                    </div>
                </fieldset>
            </div>  
        </form>
     
    </body>
</html>
