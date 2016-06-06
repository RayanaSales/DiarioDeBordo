<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <form action="/DiarioDeBordo_Web2/AlterarDadosUsuarioServlet" method="post">   

            <!-- DADOS GERAIS -->
            <fieldset>
                <legend>Dados Gerais:</legend >
                <span>Seu nome atual:</span> <span>${ sessionScope['usuario'].nome}</span><br>
                <span>Se desejar alterar, informe o seu novo nome: </span><input type="text" name="nome" placeholder="Seu novo nome"><br><br>

                <span>Sua senha atual:</span> <span>${ sessionScope['usuario'].senha}</span><br>
                <span>Se desejar alterar, informe a sua nova senha: </span><input type="password" name="senha" placeholder="********"><br><br>  
            </fieldset>

            <!-- TELEFONE -->
            <c:choose>
                <c:when test="${ sessionScope['telefone'] != null }">                                    
                    <fieldset>
                        <legend>Telefone</legend>
                        <span>Código do País: </span><span>${ sessionScope['telefone'].codigoPais}</span><br>
                        <span>Se desejar alterar, informe o código do seu país: </span><input type="text" name="cadastra_telefone_codigoDoPais" placeholder="Seu novo código do país"><br>

                        <span>DDD: </span><span>${ sessionScope['telefone'].ddd}</span><br>
                        <span>Se desejar alterar, informe o seu novo DDD: </span><input type="text" name="cadastra_telefone_DDD" placeholder="Seu novo DDD"><br>

                        <span>Número: </span><span>${ sessionScope['telefone'].numero}</span><br>
                        <span>Se desejar alterar, informe o seu novo número: </span><input type="text" name="cadastra_telefone_numero"  placeholder="Seu novo número"><br>
                    </fieldset>
                </c:when>

                <c:otherwise>                                    
                    <fieldset>
                        <legend>Telefone</legend>
                        <span>Código do país: </span><input type="text"  name="cadastra_telefone_codigoDoPais" placeholder="Seu código do país"><br>
                        <span>DDD: </span><input type="text" name="cadastra_telefone_DDD" placeholder="Seu DDD"><br>
                        <span>Número: </span><input type="text" name="cadastra_telefone_numero" placeholder="Seu número"><br>
                    </fieldset>
                </c:otherwise>
            </c:choose>

            <!-- ESCOLARIDADE -->

            <c:choose>
                <c:when test="${ sessionScope['escolaridade'] != null }">
                    <fieldset>
                        <legend>Escolaridade</legend>
                        <span>Escola: </span><span>${ sessionScope['escolaridade'].nomeEscola}</span><br>
                        <span>Se desejar alterar, informe a escola: </span><input type="text" name="cadastra_escolaridade_escola" placeholder="Sua nova escolaridade"><br><br>

                        <span>Nível de Formação: </span><span>${ sessionScope['escolaridade'].nivelFormacao}</span><br>
                        <span>Se desejar alterar, informe o código do seu país: </span><input type="text" name="cadastra_escolaridade_NivelDeFormacao" placeholder="Seu novo Nível de Formação"><br><br>

                        <span>Tempo gasto: </span><span>${ sessionScope['escolaridade'].tempoGastoNaFormacao}</span><br>
                        <span>Se desejar alterar, informe o código do seu país: </span><input type="number" name="cadastra_escolaridade_tempoGasto"><br><br>
                    </fieldset>
                </c:when>
                <c:otherwise>
                    <fieldset>
                        <legend>Escolaridade</legend>
                        <span>Escola: </span><input type="text" name="cadastra_escolaridade_escola" placeholder="Escola"><br>
                        <span>Nível de Formação: </span><input type="text" name="cadastra_escolaridade_NivelDeFormacao" placeholder="Nível de formação"><br>
                        <span>Tempo gasto: </span><input type="number" name="cadastra_escolaridade_tempoGasto"><br>
                    </fieldset>
                </c:otherwise>
            </c:choose>   


            <!-- PROFISSÃO -->
            <c:choose>
                <c:when test="${ sessionScope['profissao'] != null }">
                    <fieldset>
                        <legend>Profissão</legend>
                        <span>Nome: </span><span>${ sessionScope['profissao'].nome }</span><br>
                        <span>Se desejar alterar, informe o nome: </span><input type="text" name="cadastra_profissao_nome" placeholder="Sua novo nome"><br><br>

                        <span>Empresa: </span><span>${ sessionScope['profissao'].empresa }</span><br>
                        <span>Se desejar alterar, informe a empresa: </span><input type="text" name="cadastra_profissao_empresa" placeholder="Sua nova empresa"><br><br>

                        <span>Experiência em anos: </span><span>${ sessionScope['profissao'].getExperiencia() }</span><br>
                        <span>Se desejar alterar, informe a experiência em anos: </span><input type="number" name="cadastra_profissao_experiencia" placeholder="Sua nova experiencia"><br><br>

                    </fieldset>
                </c:when>
                <c:otherwise>
                    <fieldset>
                        <legend>Profissão</legend>
                        <span>Nome: </span><input type="text" name="cadastra_profissao_nome" placeholder="Nome"><br><br>
                        <span>Empresa: </span><input type="text" name="cadastra_profissao_empresa" placeholder="Empresa"><br><br>
                        <span>Experiência em anos: </span><input type="number" name="cadastra_profissao_experiencia"><br><br>
                    </fieldset>
                </c:otherwise>
            </c:choose>

            <!-- COMPANHEIROOS DE VIAGEM --> 

            <c:choose>
                <c:when test="${ sessionScope['companheirosDeViagem'] != null }">                                    
                    <fieldset>
                        <legend>Companheiros de Viagem</legend>
                        <span>Crianças: </span><span>${ sessionScope['companheirosDeViagem'].criancas}</span><br>
                        <span>Se desejar alterar, informe a quantidade de crianças: </span><input type="number" name="cadastrar_Companheiros_qtdCriancas" placeholder="Quantidade de crianças"><br><br>

                        <span>Quantidade de animais de estimação: </span><span>${ sessionScope['companheirosDeViagem'].qtdAnimaisDeEstimacao}</span><br>
                        <span>Se desejar alterar, informe a quantidade de animais de estimação: </span><input type="number" name="cadastrar_Companheiros_qtdAnimais" placeholder="Quantidade de animais de estimação"><br><br>

                        <span>Quantidade de amigos: </span><span>${ sessionScope['companheirosDeViagem'].qtdAmigos}</span><br>
                        <span>Se desejar alterar, informe a quantidade de amigos: </span><input type="number" name="cadastrar_Companheiros_qtdAmigos" placeholder="Quantidade de amigos"><br><br>

                        <span>Pessoas com quem me relaciono: </span>
                        <c:choose>   
                            <c:when test="${ sessionScope['companheirosDeViagem'].pessoaComQuemTenhoRelacionamentoSerio == true }">                                    
                                <span> Sim </span>
                            </c:when>
                            <c:otherwise>
                                <span> Não </span>
                            </c:otherwise>              
                        </c:choose>
                        <br>
                        <span>Se desejar alterar, informe se existe relacionamento com essas pessoas: </span>
                        <input type="radio" name="sex" value="sim" checked> Sim<input type="radio" name="sex" value="nao"> Não                        
                        <br>

                    </fieldset>
                </c:when>
                <c:otherwise>
                    <fieldset>
                        <legend>Companheiros de Viagem</legend>
                        <span>Crianças: </span><input type="number" name="cadastrar_Companheiros_qtdCriancas" placeholder="Quantidade de crianças"><br>
                        <span>Quantidade de animais de estimação: </span><input type="number" name="cadastrar_Companheiros_qtdAnimais" placeholder="Quantidade de animais de estimação"><br>
                        <span>Quantidade de amigos: </span><input type="number" name="cadastrar_Companheiros_qtdAmigos" placeholder="Quantidade de amigos"><br>
                        <span>Pessoa com quem me relaciono: </span>              
                        <input type="radio" name="sex" value="sim"> Sim<input type="radio" name="sex" value="nao"> Não
                        
                        <br>
                    </fieldset>
                </c:otherwise>
            </c:choose>

            <!-- REDES SOCIAIS -->

            <c:choose>
                <c:when test="${ sessionScope['meEncontre_OutrasRedes'] != null }">                                    
                    <fieldset>
                        <legend>Redes Sociais</legend>
                        <span>Facebook: </span><span>${ sessionScope['meEncontre_OutrasRedes'].facebook}</span><br>
                        <span>Se desejar alterar, informe o facebook: </span><input type="text" name="cadastrar_RedesSociais_facebook" placeholder="Facebook"><br><br>

                        <span>Twitter: </span><span>${ sessionScope['meEncontre_OutrasRedes'].twitter}</span><br>
                        <span>Se desejar alterar, informe o twitter: </span><input type="text" name="cadastrar_RedesSociais_twitter" placeholder="Twitter"><br><br>

                        <span>Instagram: </span><span>${ sessionScope['meEncontre_OutrasRedes'].instagram}</span><br>
                        <span>Se desejar alterar, informe o instagram: </span><input type="text" name="cadastrar_RedesSociais_instagram" placeholder="Instagram"><br><br>

                    </fieldset>
                </c:when>

                <c:otherwise>                              
                    <fieldset>
                        <legend>Redes Sociais</legend>
                        <span>Facebook: </span><input type="text" name="cadastrar_RedesSociais_facebook" placeholder="Facebook"><br>
                        <span>Twitter: </span><input type="text" name="cadastrar_RedesSociais_twitter" placeholder="Twitter"><br>
                        <span>Instagram: </span><input type="text" name="cadastrar_RedesSociais_instagram" placeholder="Instagram"><br>
                    </fieldset>
                </c:otherwise>
            </c:choose>



            <input type="submit" value="Concluir" id="alterarUsuario">

            <!-- <a href="/DiarioDeBordo_Web2/Redirecionador?acao=editarFotoPerfil">Alterar foto do perfil</a>-->

        </form>
    </body>
</html>
