var i = 0;
var path = new Array();

// LIST OF IMAGES
path[0] = "http://cdn.mntm.me/66/5c/73/Tip-Sheet-Road-Trips-665c733326544377a6335e75b5030d5c.jpg";
path[1] = "http://7-themes.com/data_images/out/41/6908306-cycling-with-nature.jpg";
path[2] = "http://1000awesomethings.com/wp-content/uploads/2011/03/airplane-blue-sky.jpg";
path[3] = "https://hottour.by/images/slide1.jpg";
path[4] = "http://images.alphacoders.com/295/295883.jpg";
path[5] = "http://www.auto-ecolealpha.com/medias/visuels/files/GDNHSFJAW6CZ99CSK5FWEA4DKDEY55.jpeg";

function swapImage()
{
    document.slide.src = path[i];
    if (i < path.length - 1) {
        i++;
    }
    else
        i = 0;
    setTimeout("swapImage()", 8000);
}
//window.onload=swapImage;


function myFunction() {

    document.getElementById('username').style.display = 'block';
    document.getElementById('cadastrarBotao').style.display = 'none';
    document.getElementById('enviarCadastro').style.display = 'block';
}

function evento1() {    
    document.getElementById("cadastrarBotao").addEventListener("click", myFunction, false);
}


function start() {
    evento1();
    swapImage();
}
window.onload = start;