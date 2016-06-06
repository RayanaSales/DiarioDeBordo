<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Excluir capítulo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="editarCapituloCSS.css"/>

        <script src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
        <link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.indigo-pink.min.css">

        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
        <style>
            h5
            {
                margin-top: 3%;
                text-align: center;               
            }

            h5 + span
            {
                margin-left: 15%;
                margin-top: 3% !important;                
            }

            card
            {
                height: 20px;
            }

            .card 
            {
                margin-top: 10% !important;
                margin-left: 30% !important; 
                width: 500px !important;
                height: 200px !important;                
            }

            .btn
            {
                margin-top: 3% !important;
            }

        </style>
    </head>
    <body>
        <div class="card card-5">

            <div style="margin-top: 0px; width: 100%; height: 28%; background-color: rgb(63,81,181); color: white;">
                <span style="margin: 220px; line-height: 60px; font-size: 16px; font-weight: bold;">Excluir</span>
            </div>

            <form action="/DiarioDeBordo_Web2/ExcluirCapitulo" id="formulario" method="get">
                <div class="formulario">
                    <h5>Capítulo 1</h5>
                    <span>Todos os arquivos do seu capítulo serão excluídos!</span>
                    <input class="btn" type="submit" value="Excluir" style="background-color: rgb(63,81,181);">
                </div>
            </form>
        </div>
    </body>
</html>