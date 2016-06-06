<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <%@page session="false" %>
    <%! Object erro = new String();
        Object email = new String();
    %>

    <%
        erro = request.getAttribute("erro");
        email = request.getAttribute("email");

        if (erro == "SenhaOuLoginErrado")
        {
            out.println("Senha ou login incorreto");
            out.println("O email " + email + " , ou a senha, não estão cadastrados no sistema.");
        }
    %>    
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="estiloLoginCadastro.css"/>
        <script type="text/javascript" src="jsLoginCadastro.js" ></script>
    </head>

    <body>
        <img name="slide" src="http://cdn.mntm.me/66/5c/73/Tip-Sheet-Road-Trips-665c733326544377a6335e75b5030d5c.jpg" alt="transportes de viagem"/>

        <div class="container">
            <div id="login-form">
                <fieldset>                  

                    <!--<form action="javascript:void(0);" method="get"> -->
                    <form action="/DiarioDeBordo_Web2/LoginServlet" method="post">

                        <div><img id="logoNoForm" src="logo.png" alt="logotipo"></div>

                        <p align='center'>Email</p>
                        <input type="email" name="email" placeholder="email@exemplo.com"><br>

                        <p align='center'>Senha</p>
                        <input type="password" name="senha" placeholder="********"><br>

                        <footer class="clearfix">                  
                            <p><span class="info">+</span><a href="/DiarioDeBordo_Web2/Redirecionador?acao=cadastrar">Não possuo cadastro</a></p>
                        </footer>
                        <footer class="clearfix">
                            <p><span class="info">?</span><a href="#">Esqueci a senha</a></p>
                        </footer>
                        <input type="submit" value="Login">                       
                    </form>
                </fieldset>
            </div> 
        </div>
    </body>
</html>




