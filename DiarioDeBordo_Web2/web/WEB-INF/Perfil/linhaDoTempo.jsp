<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="beanArquivo" class="bancoDeDados.ArquivoDao" />
<jsp:useBean id="beanCapitulo" class="bancoDeDados.CapituloDAO" />

<html lang="pt-br">
    <head>
        <!-- mobile port
        ================================================== -->
        <meta content="width=device-width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0" name="viewport">

        <!-- styles
        ================================================== -->
        <link href="http://rockinrio.com/aovivo/layout/css/font-awesome.css" rel="stylesheet" type="text/css" /> <!-- Arquivo estiloLinhaDoTempo1.js -->  
        <link href="http://rockinrio.com/aovivo/layout/css/typography.css" rel="stylesheet" type="text/css" /> <!-- Arquivo estiloLinhaDoTempo2.js --> 
        <link href="http://rockinrio.com/aovivo/layout/css/fancybox.css" rel="stylesheet" type="text/css" /> <!-- Arquivo estiloLinhaDoTempo3.js --> 
        <link href="http://rockinrio.com/aovivo/layout/css/main.css" rel="stylesheet" type="text/css" /> <!-- Arquivo estiloLinhaDoTempo4.js --> 
        <link href="http://rockinrio.com/aovivo/layout/css/loaders.min.css" rel="stylesheet" type="text/css" /> <!-- Arquivo estiloLinhaDoTempo5.js --> 

        <link href='http://rockinrio.com/aovivo/layout/loader/nprogress.css' rel='stylesheet' /> <!-- Arquivo estiloLinhaDoTempo6.js --> 
        <link href="http://rockinrio.com/aovivo/layout/css/additional.css?v=20151008210826" rel="stylesheet" type="text/css" /> <!-- Arquivo estiloLinhaDoTempo7.js --> 
        <link href="http://rockinrio.com/aovivo/layout/css/additional-silvana.css?v=20151008210826" rel="stylesheet" type="text/css" /> <!-- Arquivo estiloLinhaDoTempo8.js --> 
        <link href="http://rockinrio.com/aovivo/layout/css/media_queries.css" rel="stylesheet" type="text/css" /> <!-- Arquivo estiloLinhaDoTempo9.js --> 

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.1.2/css/material-design-iconic-font.min.css"> <!-- Arquivo estiloLinhaDoTempo10.js --> 

        <!-- Modernizar
        ================================================== -->
        <script src="http://rockinrio.com/aovivo/layout/js/jquery.modernizr.js"></script> <!-- Arquivo mordernizar.js --> 

        <!-- Common jquery.min
        ================================================== -->
        <script src="http://rockinrio.com/aovivo/layout/js/jquery-1.7.2.min.js"></script> <!-- Arquivo jquery.js --> 

        <style>
            .content-main {
                background-image: url("http://s2.favim.com/orig/33/background-backgrounds-pattern-tumblr-background-wood-Favim.com-260514.jpg") !important;
                background-repeat: repeat !important;
            }
        </style>
    </head>
    <body>
        <header></header>    
        <section class="content-main">
            <section class="container">
                <div class="timeline-cont">
                    <div class="article-bg">
                        <div class="divider-bg"></div>
                        <div id="main" role="main">
                            <div class="tiles parentTile1">
                                <c:set var="email" value="${ sessionScope['usuario'].email}"/>
                                <c:forEach var="capitulos" items="${beanCapitulo.buscarCapitulosUsuario(email)}">

                                    <article class="">         
                                        <div class="top-line-bg">
                                            <div class="top-line">                                            
                                              <!--  <div class="time">${capitulos.inicio}</div> -->
                                                <div class="time"><fmt:formatDate value="${capitulos.inicio}" pattern="yyyy-MM-dd" /></div>
                                            </div>
                                        </div>
                                        <div class="boxbg">
                                            <div class="box facebook">                                                                                      

                                                <div class="badge-container">
                                                   <img src="${capitulos.fotoCapa}" alt="${capitulos.descricao}" height="189" width="335.297"/>
                                                </div>

                                                <div><span>${capitulos.nome}</span></div>                                     
                                                <div class="box-content utf8"><p class="topbar">${capitulos.descricao}</p></div>

                                            </div>
                                        </div>
                                        <div class="bottom-line">
                                            <ul>
                                                <li><a href=""><i title="Outra coisa" class="zmdi zmdi-pin-help"></i></a></li>
                                                <li><a href=""><i title="Inserir foto" class="zmdi zmdi-camera"></i></a></li>
                                                <li><a href=""><i title="Inserir video" class="zmdi zmdi-movie-alt"></i></a></li>
                                                <li><span>Atualizar capitulo</span></li>
                                            </ul>
                                        </div>
                                    </article>

                                </c:forEach>

                                <!--       <article class="">         
                                           <div class="top-line-bg">
                                               <div class="top-line">                                            
                                                   <div class="time">2013</div>
                                               </div>
                                           </div>
                                           <div class="boxbg">
                                               <div class="box facebook">                                                                                      
       
                                                   <div class="badge-container">
                                                       <iframe width="100%" height="450" scrolling="no" frameborder="no" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/28261394&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true"></iframe>
                                                   </div>
       
                                                   <div><span>Nome capitulo</span></div>                                     
                                                   <div class="box-content utf8"><p class="topbar">As luzes do Palco Mundo j&aacute; se apagaram. Mas no Palco Eletr&ocirc;nico ainda tem muita festa pra rolar. Carl Craig na &aacute;rea ;) #rockinrio</p></div>
       
                                               </div>
                                           </div>
                                           <div class="bottom-line">
                                               <ul>
                                                   <li><a href=""><i title="Outra coisa" class="zmdi zmdi-pin-help"></i></a></li>
                                                   <li><a href=""><i title="Inserir foto" class="zmdi zmdi-camera"></i></a></li>
                                                   <li><a href=""><i title="Inserir video" class="zmdi zmdi-movie-alt"></i></a></li>
                                                   <li><span>Atualizar capitulo</span></li>
                                               </ul>
                                           </div>
                                       </article>
       
                                       <article class=""> 
                                           <div class="top-line-bg">
                                               <div class="top-line">                                            
                                                   <div class="time">2011</div>
                                               </div>
                                           </div>
                                           <div class="boxbg">
                                               <div class="box facebook">                                                                                      
                                                   <figure><img src="http://www2.pictures.zimbio.com/gi/Serj+Tankian+Daron+Malakian+25th+Annual+KROQ+gRIReKBscrbl.jpg"/></figure>
                                                   <div><span>Nome capitulo</span></div>
                                                   <div class="box-content utf8"><p class="topbar">As luzes do Palco Mundo j&aacute; se apagaram. Mas no Palco Eletr&ocirc;nico ainda tem muita festa pra rolar. Carl Craig na &aacute;rea ;) #rockinrio</p></div>
       
                                               </div>
                                           </div>
                                           <div class="bottom-line">
                                               <ul>
                                                   <li><a href=""><i title="Outra coisa" class="zmdi zmdi-pin-help"></i></a></li>
                                                   <li><a href=""><i title="Inserir foto" class="zmdi zmdi-camera"></i></a></li>
                                                   <li><a href=""><i title="Inserir video" class="zmdi zmdi-movie-alt"></i></a></li>
                                                   <li><span>Atualizar capitulo</span></li>
                                               </ul>
                                           </div>
                                       </article>
                                       
                                       <article class="">         
                                           <div class="top-line-bg">
                                               <div class="top-line">                                            
                                                   <div class="time">2009</div>
                                               </div>
                                           </div>
                                           <div class="boxbg">
                                               <div class="box facebook">                                                                                      
       
                                                   <div><span>Nome capitulo</span></div>                                     
                                                   <div class="box-content utf8"><p class="topbar">As luzes do Palco Mundo j&aacute; se apagaram. Mas no Palco Eletr&ocirc;nico ainda tem muita festa pra rolar. Carl Craig na &aacute;rea ;) #rockinrio</p></div>
       
                                               </div>
                                           </div>
                                           <div class="bottom-line">
                                               <ul>
                                                   <li><a href=""><i title="Outra coisa" class="zmdi zmdi-pin-help"></i></a></li>
                                                   <li><a href=""><i title="Inserir foto" class="zmdi zmdi-camera"></i></a></li>
                                                   <li><a href=""><i title="Inserir video" class="zmdi zmdi-movie-alt"></i></a></li>
                                                   <li><span>Atualizar capitulo</span></li>
                                               </ul>
                                           </div>
                                       </article>
                                -->
                            </div><!-- /#tiles -->
                        </div><!-- /#main -->
                    </div> <!-- /.article-bg -->
                </div> <!-- /.timeline-cont -->
            </section>
        </section>

        <!-- Necessario para carregar -->        
        <script src="http://rockinrio.com/aovivo/layout/js/wookmark.js"></script> <!-- Arquivo carregarLinhaDoTempo.js -->        
        <script src="http://rockinrio.com/aovivo/layout/loader/nprogress.js"></script>    <!-- Arquivo carregarLinhaDoTempo2.js -->   
        <script src="http://rockinrio.com/aovivo/layout/js/jquery.scrolldepth.js"></script> <!-- Arquivo carregarLinhaDoTempo3.js --> 
        <script src="http://rockinrio.com/aovivo/layout/js/scripts.js?v=20151008210827"></script> <!-- Arquivo carregarLinhaDoTempo4.js --> 
    </body>
</html>