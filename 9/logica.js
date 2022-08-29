const processoriPrezzi={"i3":200,"i5":300,"i7":500,"i9":750,"ryzen3":180,"ryzen5":280,"ryzen7":460,"ryzen9":600};
const ramPrezzi={"ddr3":8,"ddr4":15};
const memoriaPrezzi={"hdd":0.02,"emmc":0.05,"ssd":0.09};
const marcaPrezzi={"ananas":2};

class Pc{
    constructor(nome,marca,processore,ram,tipoRam,memoria,tipoMemoria){
        this.nome=nome;
        this.marca=marca;
        this.processore=processore;
        this.ram=ram;
        this.tipoRam=tipoRam;
        this.memoria=memoria;
        this.tipoMemoria=tipoMemoria;
    }

    checkInput(){
        let find=false;
        console.log("Controllo la validita");
        if(this.ram<=0 || this.memoria<=0){
            console.log("non valido");
            return find;
        }
        for(let cpu in processoriPrezzi){
            if(this.processore.toLowerCase()==cpu){
                find=true;
                
            }
        }
        if(!find){
            return find;
        }

        return find;
    }
    prezzo(){
        let prezzo=processoriPrezzi[this.processore.toLowerCase()];
        prezzo+=this.ram*ramPrezzi[this.tipoRam.toLowerCase()];
        prezzo+=this.memoria*memoriaPrezzi[this.tipoMemoria.toLowerCase()];
        prezzo*=this.marca.toLowerCase()=="ananas" ? 2 : 1;

        return prezzo;
    }
}
const pcs=[];

function lunghezza(vett){
    let i=0
    for(let p of vett){
        i++;
    }
    return i; 
}

function memorizzaPc(form){
   
    let pc=new Pc(form.nome.value,form.marca.value,form.processore.value,parseInt(form.ram.value),form.tipoRam.value,parseInt(form.memoria.value),form.tipoMemoria.value);
    if(pc.checkInput()){
        console.log("pc valido");
        pcs.push(pc);
        renderPcs(); 
    }
    
}

function renderPcs(){
    let ris="";
    let totale=0;
    let media;
    let i=0;
    console.log("render");
    for(let pc of pcs){
        let pr=pc.prezzo();
        totale+=pr;
        ris+=`<li>${pc.nome}: ${pr}$ <button onclick="elimina(${i})">X</button></li>`;
        i++;
    }
    media=totale/lunghezza(pcs);
    document.getElementById('pcs').innerHTML = ris;
    document.getElementById('risultato').innerHTML = `<li> Totale: ${totale}</li><li>Prezzo Medio: ${media}</li>`;
}

function elimina(indice){
    pcs.splice(indice,1);
    renderPcs();
}
const ricercati=[];
function ricerca(form){
    renderPcs();
    
    for(let elem of pcs){
        if(elem.processore==form.processore.value.toLowerCase() && elem.ram>=parseInt(form.ram.value) && elem.memoria >= parseInt(form.memoria.value) ){
            ricercati.push(elem);
        }
    }
    visualizzaRicerca();
}

function visualizzaRicerca(){
    ris="";
    for(let elem of ricercati){
        ris+=`<li>${elem.nome}</li>`;
        
    }
    document.getElementById('resultSearch').innerHTML = ris;
}