/* MÉTODO SUPER FEO QUE AÑADE Y QUITA LOS INPUTS DE RATING */
let botonadd=document.getElementById('addRating');
let botonrem=document.getElementById('removeRating');


botonadd.addEventListener('click',addRaiting);
botonrem.addEventListener('click',removeRating);

let contadorFormulario=0;


function addRaiting (){
    
    if(contadorFormulario==0)
    {
        paquete1.classList.remove('display_none');
        contadorFormulario++;
    }
    else if(contadorFormulario==1)
    {
        paquete2.classList.remove('display_none');
        contadorFormulario++;
    }
    
}
function removeRating(){
	if(contadorFormulario!=0){
		 let paquete=document.getElementById('numero_rating_'+(contadorFormulario-1))
    paquete.classList.add('display_none')
    contadorFormulario--;
	}
   
}
