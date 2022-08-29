console.log("Evviva");
class Prodotto{
    constructor(prodotto,categoria){
        this.prodotto=prodotto;
        this.categoria=categoria;
    }

    toList(){
        return `
                <li> ${this.prodotto}  <button onclick="elimina('${this.prodotto}','${this.categoria}')">X</button></li>
                `;
    }
    toComprati(){
        return `
                <li><del> ${this.prodotto}  </del>  <button onclick="annulla('${this.prodotto}','${this.categoria}')">annulla</button></li>
                `;
    }


}

const prodotti=[];
const comprati=[];
const prodottiCategoria=[];


function renderCategorie(){
    
    ris="";
    for(let categoria in prodottiCategoria){
       
        ris+=`<h3> ${categoria}</h3><ol>`;
        for(let prodotto of prodottiCategoria[categoria]){
           
            ris+=prodotto.toList();
        }

        ris+=`</ol>`;

    }
    document.getElementById('lista').innerHTML = ris;
}
function lunghezza(categoria){
    let i=0;
    for(let p of prodottiCategoria[categoria]){
        i++;
    }
    return i;
}
function getIndex(categoria){
    let i=0;
    for(let k in prodottiCategoria){
        
        if(k==categoria){
            break;
        }
        i++;
    }
    return i;
}

function elimina(nomeProdotto,categoria){
       let i=0;
       console.log(lunghezza(categoria));
       if(lunghezza(categoria)==1){
             comprati.push(prodottiCategoria[categoria][i]);
             delete prodottiCategoria[categoria];
       }else{
             
             for(let prodotto of prodottiCategoria[categoria]){
                if(prodotto.prodotto==nomeProdotto){
                    prodottiCategoria[categoria].splice(i,1);
                    comprati.push(prodotto);
                }
                i++;
            }
        }
      
    renderCategorie();
    renderAcquistati();

}



function renderAcquistati(){
    let ris="";
    for(let prodotto of comprati){
        
        ris+=prodotto.toComprati();
    }

    document.getElementById('acquistati').innerHTML = ris;
}
const categorie=[];

function check(categoria){
    let find=false;
    for(cat of categorie){
        if(cat==categoria){
            return true;            
        }
    }
    return find;
}
function add(categoria){
    if(!check){
        categorie.push(categoria);
    }
}

function len(){
    let i=0;
    for(let key in prodottiCategoria){
        i++;
    }
    return i;
}

function aggiungi(form){
    //add(form.categoria.value);
    let p= new Prodotto(form.prodotto.value,form.categoria.value);
    console.log("Lungheza"+len());
    if(len()==0){
        prodottiCategoria[p.categoria]=new Array();
        prodottiCategoria[p.categoria].push(p);
    }else{ 
        carica(p,p.categoria);
          
            
    }

   
    
       renderCategorie();
}

function carica(prodotto,categoria){
    let find=false;
            for( let key of Object.keys(prodottiCategoria)){
                if(categoria== key){
                
                    find=true;
                    break;
                }
            }
            if(find){
                prodottiCategoria[categoria].push(prodotto);
            }else{
                prodottiCategoria[categoria]=new Array();
                prodottiCategoria[categoria].push(prodotto);
            }
}

function annulla(prodottoNome,categoria){
    let i=0;
    for(let prodotto of comprati){
        if(prodottoNome == prodotto.prodotto){
            comprati.splice(i,1);
            carica(prodotto,categoria);
            
        }
        i++;
    }

    renderCategorie();
    renderAcquistati();
}

