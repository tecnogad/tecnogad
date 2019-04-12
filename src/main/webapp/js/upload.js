var feedback = function(res) {
    if (res.success === true) {
        var get_link = res.data.link.replace(/^http:\/\//i, 'https://');
        document.querySelector('.status').classList.add('bg-success');
        document.querySelector('.status').innerHTML =
            'Image : ' + '<br><input class="image-url" value=\"' + get_link + '\"/>' + '<img class="img" alt="Imgur-Upload" src=\"' + get_link + '\"/>';
    }
};

new Imgur({
    clientid: '4409588f10776f7', //
    callback: feedback
});
//Nuestro mail: tecnogad.aiss.g4@gmail.com
//Clave: juacarpepraf
//https://www.youtube.com/watch?v=qmNbZmBOaGM
//Nuestro mail: tecnogad.aiss.g4@gmail.com
//https://api.imgur.com/oauth2/addclient
//clien secret 82b29541fd49807335ef9877e09c4e41059b096e
//a12345 imgur