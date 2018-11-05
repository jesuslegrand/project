var w1 = "ciberacoso";
var w2 = "sexo";
var w3 = "sexting";
var w4 = "bullying";
var w5 = "grooming";
var w6 = "fotos";
var w7 = "videos";
var w8 = "nudes";
var w9 = "booty";
var w10 = "senos";
var w11 = "pene";
var w12 = "blowjob";
var w13 = "masturbar";
var w14 = "sexcall";

var input = "";
document.body.addEventListener('keypress',function(ev){
    input += String.fromCharCode(ev.keyCode);
    console.log(input);
    if(input == w1){
        alert('typed ciberacoso');
        input = "";  
    }
    if(input == w2){
        alert('typed sexo');
        input = "";
    }
    if(input == w3){
        alert('typed sexting');
        input = "";
    }
    if(input == w4){
        alert('typed bullying');
        input = "";
    }
    if(input == w5){
        alert('typed grooming');
        input = "";
    }
    if(input == w6){
        alert('typed fotos');
        input = "";
    }
    if(input == w7){
        alert('typed videos');
        input = "";
    }
    if(input == w8){
        alert('typed nudes');
        input = "";
    }
    if(input == w9){
        alert('typed booty');
        input = "";
    }
    if(input == w10){
        alert('typed senos');
        input = "";
    }
    if(input == w11){
        alert('typed pene');
        input = "";
    }
    if(input == w12){
        alert('typed blowjob');
        input = "";
    }
    if(input == w13){
        alert('typed masturbar');
        input = "";
    }
    if(input == w14){
        alert('typed sexcall');
        input = "";
    }
    if(input == w15){
        alert('typed te voy');
        input = "";
    }
});

// reset input when pressing esc
document.body.addEventListener('keyup',function(ev){
    if(ev.keyCode == 27) input = "";
});