/* MÉTODO QUE DESPLIEGA EL MENÚ FEO Y LO CONTRAE, FUNCIONA PERO ES CURTE, PERO NO QUERIA HACERLO CON BOOSTRAP */

let boton_menu=document.getElementById('boton_menu_movil');
let menu_desplegable=document.getElementById('menu_desplegable');
let bg=document.getElementById('bg_menu');
let ul_menu=document=document.getElementById('caja_menu');
let ul_submenu=document.getElementById('caja_submenu');

let paquete1=document.getElementById('numero_rating_0');
let paquete2=document.getElementById('numero_rating_1');

boton_menu.addEventListener('click',desplegar_menu);




function desplegar_menu(){
    menu_desplegable.classList.toggle('display_none');
    bg.classList.toggle('bgcolor');
    ul_menu.classList.toggle('menu');
    ul_submenu.classList.toggle('submenu_estetica');
    ul_submenu.parentElement.classList.toggle('white_border');
}