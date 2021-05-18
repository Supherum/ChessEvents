/* FORMULARIO*/
let botonadd=document.getElementById('addRating');
let botonrem=document.getElementById('removeRating');
/*MENU EN MOVIL */
let boton_menu=document.getElementById('boton_menu_movil');
let menu_desplegable=document.getElementById('menu_desplegable');
let bg=document.getElementById('bg_menu');
let ul_menu=document=document.getElementById('caja_menu');
let ul_submenu=document.getElementById('caja_submenu');

let paquete1=document.getElementById('numero_rating_0');
let paquete2=document.getElementById('numero_rating_1');

boton_menu.addEventListener('click',desplegar_menu);

/* FORMULARIO*/
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
/*MENU EN MOVIL */


function desplegar_menu(){
    menu_desplegable.classList.toggle('display_none');
    bg.classList.toggle('bgcolor');
    ul_menu.classList.toggle('menu');
    ul_submenu.classList.toggle('submenu_estetica');
    ul_submenu.parentElement.classList.toggle('white_border');
}