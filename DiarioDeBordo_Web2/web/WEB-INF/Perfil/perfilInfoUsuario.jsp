<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil com informacoes</title>
    </head>
    <body>
        <fieldset>
            <legend>Dados Gerais</legend>
            <span>Nome usuário: </span> <span>${ sessionScope['usuario'].nome}</span><br>
            <span>Email: </span> <span>${ sessionScope['usuario'].email}</span><br>
            <span>Senha: </span> <span>${ sessionScope['usuario'].senha}</span><br>
        </fieldset>
        <c:if test="${ sessionScope['telefone'] != null }">                                    
            <fieldset>
                <legend>Telefone</legend>
                <span>Código do País: </span><span>${ sessionScope['telefone'].codigoPais}</span><br>
                <span>DDD: </span><span>${ sessionScope['telefone'].ddd}</span><br>
                <span>Número: </span><span>${ sessionScope['telefone'].numero}</span><br>
            </fieldset>
        </c:if>
        <c:if test="${ sessionScope['escolaridade'] != null }">                                    
            <fieldset>
                <legend>Escolaridade</legend>
                <span>Escola: </span><span>${ sessionScope['escolaridade'].nomeEscola}</span><br>
                <span>Nível de Formação: </span><span>${ sessionScope['escolaridade'].nivelFormacao}</span><br>
                <span>Tempo gasto: </span><span>${ sessionScope['escolaridade'].tempoGastoNaFormacao}</span><br>
            </fieldset>
        </c:if>
        <c:if test="${ sessionScope['profissao'] != null }">                                    
            <fieldset>
                <legend>Profissão</legend>
                <span>Nome: </span><span>${ sessionScope['profissao'].nome }</span><br>
                <span>Empresa: </span><span>${ sessionScope['profissao'].empresa }</span><br>
                <span>Experiência em anos: </span><span>${ sessionScope['profissao'].getExperiencia() }</span><br>
            </fieldset>
        </c:if>
        <c:if test="${ sessionScope['companheirosDeViagem'] != null }">                                    
            <fieldset>
                <legend>Companheiros de Viagem</legend>
                <span>Crianças: </span><span>${ sessionScope['companheirosDeViagem'].criancas}</span><br>
                <span>Quantidade de animais de estimação: </span><span>${ sessionScope['companheirosDeViagem'].qtdAnimaisDeEstimacao}</span><br>
                <span>Quantidade de amigos: </span><span>${ sessionScope['companheirosDeViagem'].qtdAmigos}</span><br>
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

            </fieldset>
        </c:if>
        <c:if test="${ sessionScope['meEncontre_OutrasRedes'] != null }">                                    
            <fieldset>
                <legend>Redes Sociais</legend>
                <span>Facebook: </span><span>${ sessionScope['meEncontre_OutrasRedes'].facebook}</span><br>
                <span>Twitter: </span><span>${ sessionScope['meEncontre_OutrasRedes'].twitter}</span><br>
                <span>Instagram: </span><span>${ sessionScope['meEncontre_OutrasRedes'].instagram}</span><br>
            </fieldset>
        </c:if>

        <br>
        <a href="/DiarioDeBordo_Web2/RemoverCadastroUsuarioServlet">Remover minha conta</a>        
        <a href="/DiarioDeBordo_Web2/Redirecionador?acao=editarDadosUsuario">Editar perfil</a>                        
    </body>
</html>
