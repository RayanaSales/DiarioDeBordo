<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
        <title>Cadastrar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="estiloLoginCadastro.css">
        <script type="text/javascript" src="jsLoginCadastro.js" ></script>
    </head>

    <body>
        <img name="slide" src="http://cdn.mntm.me/66/5c/73/Tip-Sheet-Road-Trips-665c733326544377a6335e75b5030d5c.jpg" alt="transportes de viagem"/>

        <div class="container" style="top: 46%;">
            <div id="login-form">
                <fieldset style="width: 106%;">                   

                    <!--<form action="javascript:void(0);" method="get"> -->
                    <form action="/DiarioDeBordo_Web2/CadastrarServlet" method="post">

                        <div><img id="logoNoForm" src="logo.png" alt="logotipo"></div>

                        <p align='center'>Nome</p>
                        <input type="text" name="nome" placeholder="Seu nome"><br>

                        <p align='center'>Email</p>
                        <input type="email" name="email" placeholder="email@exemplo.com"><br>

                        <p align='center'>Senha</p>
                        <input type="password" name="senha" placeholder="********"><br>      

                        <p><span class="info">-</span><a href="/DiarioDeBordo_Web2/Redirecionador?acao=login" style="font-size: 12px;">Já possuo cadastro</a></p>

                        <input type="submit" value="Cadastrar" id="cadastrarBotao">
                    </form>

                </fieldset>
            </div> 
        </div>
    </body>
</html>

