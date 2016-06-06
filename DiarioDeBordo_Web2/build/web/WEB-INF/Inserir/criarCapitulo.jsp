<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Criar capitulo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="estiloCriarCapitulo.css"/>          

        <script src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
        <link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.indigo-pink.min.css">      

        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">

        <!-- icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.1.2/css/material-design-iconic-font.min.css">

        <style>
            ul{
                margin-top: 3%;
                margin-left: 25%;
                list-style-type: none;
            }

            ul li{
                float: left;
                display: inline;
                width: 5%;
                height: 5%;
                margin-right: 25%;
            }

            ul li a{
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="card card-5" >

            <div style="margin-top: 0px; width: 100%; height: 15%; background-color: rgb(63,81,181); color: white;">
                <span style="margin: 193px; line-height: 72px; font-size: 17px; font-weight: bold;">Criar capítulo</span>
            </div>           

            <form action="/DiarioDeBordo_Web2/CriarCapituloServlet" id="formulario" method="post">

                <div class="formulario">

                    <div class="input">                    

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input name="nome" class="mdl-textfield__input" type="text" id="sample3" style="color: #000066;"/>
                            <label class="mdl-textfield__label" for="sample3" style="color: #000066;">Nome do capítulo</label>
                        </div>

                    </div>

                    <textarea rows="6" name="descricao" form="formulario" style="height: 70px;">Descrição...</textarea>

                    <div>
                        <label for="inicio" style="color: #000066;">Início</label>
                        <input name="inicio" id="inicio" type="date">
                    </div>
                    <div>
                        <label for="fim" style="color: #000066;">Fim</label>
                        <input name="fim" id="fim" type="date">
                    </div>
                    
                    <!-- Localizacao -->
                    <div>
                        <label for="pais" style="color: #000066;">Pais</label>
                        <input name="pais" id="pais" type="text">
                    </div>
                    <div>
                        <label for="estado" style="color: #000066;">Estado</label>
                        <input name="estado" id="estado" type="text">
                    </div>
                    <div>
                        <label for="cidade" style="color: #000066;">Cidade</label>
                        <input name="cidade" id="cidade" type="text">
                    </div>

                    <input class="btn" type="submit" value="Criar" style="background-color: rgb(63,81,181);">

                </div>
            </form>
        </div>


    </body>
</html>
