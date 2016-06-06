<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Criar post</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="editarCapituloCSS.css"/>

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
            
            textarea{
                width: 100%;
                height: 100%;
            }
            h5, span
            {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="card card-5" >

            <div style="margin-top: 0px; width: 100%; height: 15%; background-color: rgb(63,81,181); color: white;">
                <span style="margin: 220px; line-height: 72px; font-size: 16px; font-weight: bold;">Capítulo 1</span>
            </div>

            <form action="#" id="formulario">

                <div class="formulario">

                    <h5>${ sessionScope['capituloDaVez'].nome}</h5>

                  <!--   <textarea rows="40" name="comment" form="formulario" style="height: 250px;">Diga algo sobre esta postagem</textarea> -->

                    <ul>
                        <li><a title="Inserir áudio" class="zmdi zmdi-audio" href="/DiarioDeBordo_Web2/Redirecionador?acao=inserirAudio"></a></li>
                        <li><a title="Inserir foto" class="zmdi zmdi-image" href="/DiarioDeBordo_Web2/Redirecionador?acao=inserirFoto"></a></li>
                        <li><a title="Inserir vídeo" class="zmdi zmdi-movie" href="/DiarioDeBordo_Web2/Redirecionador?acao=inserirVideo"></a></li>
                    </ul>  
                    <!-- 
                    <div>
                        <label for="pegar">Enviar arquivos</label>
                        <input id="pegar" type="file" multiple>
                    </div> -->

                    <input class="btn" type="submit" value="Concluir" style="background-color: rgb(63,81,181);">

                </div>
            </form>
        </div>


    </body>
</html>