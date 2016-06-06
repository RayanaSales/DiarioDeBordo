<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar foto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="editarFoto.css">
    </head>
    <body>
        <div id="containerDeEdicaoPrincipal">

            <div id="campoDeCor">

                <fieldset>
                    <div id="titulo">
                        <fieldset>
                            <p>Editar Foto</p>
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
                            <fieldset>

                                <textarea rows="5" cols="48">Rebeca e Jesen dançando na praia kk </textarea>

                            </fieldset>
                        </div>

                        <input type="file" id="myFile">
                        <input type="submit" value="Salvar Alterações" id="salvarBotao">
                        <input type="submit" value="Excluir Imagem" id="excluirBotao">

                    </fieldset>
                </div>

            </fieldset>

        </div>

    </body>
</html>
