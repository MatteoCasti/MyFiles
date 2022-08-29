console.log("javascript")
function converti(form){

    let valoreDaConvertire=parseFloat(form.temperatura1.value);
    console.log(valoreDaConvertire);
    let scalaInput=form.scala1.value;
    let scalaOutput=form.scala2.value;
    scalaIngresso(valoreDaConvertire,scalaInput,scalaOutput);
}

function scalaIngresso(valoreDaConvertire,scalaInput,scalaOutput){
    console.log("calcolo");
    ris="";
    switch(scalaInput){
        case "celsius":
            switch(scalaOutput){
                case "celsius":
                    ris+=valoreDaConvertire;
                    break;
                case "fahreneit":
                    ris+=((valoreDaConvertire*1.8)+32);
                    break;
                case "kelvin":
                    ris+=valoreDaConvertire+273.15;
                    break;
            }
            break;
        case "fahreneit":
            switch(scalaOutput){
                case "celsius":
                    ris+=((valoreDaConvertire/1.8)-32);
                    break;
                case "fahreneit":
                    ris+=valoreDaConvertire;
                    break;
                case "kelvin":
                    ris+=((valoreDaConvertire/1.8)-32+273.15);
                    break;
            }
            break;
        case "kelvin":
            switch(scalaOutput){
                case "celsius":
                    ris+=valoreDaConvertire-273.15;
                    break;
                case "fahreneit":
                    ris+=(((valoreDaConvertire-273.15)*1.8)+32);
                    break;
                case "kelvin":
                    ris+=valoreDaConvertire;
                    break;
            }
            break;
    }
    console.log("Il risultato è: "+ris);
    document.getElementById('risultato').value = ris;
}

const vett={"euro":{"dollaro": 1,"sterlina":1.18,"esd":10,"rmb":11.5,"yen":0.00732}};

function conversioneMoneta(form){
    
    let valore=parseFloat(form.moneta.value);
    ris="";
   
   
   ris+=valore*vett["euro"][form.valute.value];
    document.getElementById('out').value = ris;
}









