    function validarED() {
const tiempo = document.getElementById("tiempoBloque")
const valor = document.getElementById("valorBloque")
const cantidad = document.getElementById("cantidadCancha")
const descripcion = document.getElementById("descripcionRecinto")
const elementoError = document.getElementById("error")
const elementoExito = document.getElementById("exito")
  let valido = true;
  let mensaje = ""
  if (tiempo.value < 15) {
    mensaje += `El tiempo por bloque no puede ser menor a 15 min <br>`
    valido = false;
  }
  else {
    if (tiempo.value > 300) {
      mensaje += `El tiempo por bloque no puede ser mayor a 300 min <br>`
      valido = false;
    }
  }
  if (valor.value < 500) {
    mensaje += `El valor min para un bloque es de $500 pesos <br>`
    valido = false;
  }
  else {
    if (valor.value > 1000000) {
      mensaje += `El valor max para un bloque es de $1000000 de pesos <br>`
      valido = false;
    }
  }
  if (cantidad.value < 1) {
    mensaje += `La cantidad de "canchas" no pueden ser menor a 1 <br>`
    valido = false;
  }
  else {
    if (cantidad.value > 100) {
      mensaje += `La cantidad de "canchas" no pueden ser mayor a 100 <br>`
      valido = false;
    }
  }
  if(descripcion.value.length > 250){
      mensaje += `La descripción no puede superar los 250 caracteres <br>`
      valido = false;
  }
  if (valido) {
    document.getElementById("panelverde").style.display = "";
    document.getElementById("panelrojo").style.display = "none";
    elementoExito.innerHTML = "Registrado con exito"
    //agregar accion();
  }
  else {
    document.getElementById("panelrojo").style.display = "";
    document.getElementById("panelverde").style.display = "none";
    elementoError.innerHTML = mensaje
  }
}