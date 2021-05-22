
/* FUNCIÓN QUE HACE QUE AL PINCHAR EN UNO DE LOS TORNEOS O SOCIOS MANDE AL OTRO FORMULARIO LOS IDS Y DEMÁS */
window.onload = function() {
    
    const elements = document.querySelectorAll("#tbody_torneo > tr");
    elements.forEach(element => {
        element.addEventListener("click",sacarAtributosTorneo1)
    });
    const elements1 = document.querySelectorAll("#tbody_socio > tr");
    elements1.forEach(element1 => {
        element1.addEventListener("click",sacarAtributosSocio)
    });
    const elements2 = document.querySelectorAll("#tbody_torneo2 > tr");
    elements2.forEach(element2 => {
        element2.addEventListener("click",sacarAtributosTorneo1)
    });
   
}



function sacarAtributosTorneo1 () {
    document.querySelector("#nombre_torneo_registro").value = this.dataset.nombre;
    document.querySelector("#lugar_torneo_registro").value = this.dataset.lugar;
    document.querySelector("#tipo_partida_torneo_registro").value = this.dataset.tipo_partida;
    document.querySelector("#rating_minimo_torneo_registro").value = this.dataset.rating_minimo;
    document.querySelector("#texto_aclarativo_torneo_registro").value = this.dataset.texto;
    document.querySelector("#id_torneo_registro").value = this.dataset.id;

}
function sacarAtributosSocio() {
    document.querySelector("#imagen_socio_registro").src = this.dataset.imagen;
    document.querySelector("#nombre_socio_registro").value = this.dataset.nombre;
    document.querySelector("#apellido_socio_registro").value = this.dataset.apellido;
    document.querySelector("#standard_socio_registro").value = this.dataset.standard;
    document.querySelector("#blitz_socio_registro").value = this.dataset.blitz;
    document.querySelector("#rapid_socio_registro").value = this.dataset.rapid;
    document.querySelector("#id_socio_registro").value = this.dataset.id;

}

//madebyelMagias :3