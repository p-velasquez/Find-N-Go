const nombreRecinto = document.getElementById("txtNombreRecinto")
const correo = document.getElementById("txtEmail")
const direccion = document.getElementById("txtDireccion")
const nombrePersona = document.getElementById("txtNombrePersona")
const pass = document.getElementById("txtPassword")
const elementoError = document.getElementById("error")
const elementoExito = document.getElementById("exito")

function validarRD() {
  let valido = true;
  let mensaje = ""
  let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/
  let regexPassword = /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/
  let regexNombre = /^[a-zA-Z ]{2,254}$/
  if (nombreRecinto.value == "") {
    mensaje += `El nombre del recinto no puede ser vacio <br>`
    valido = false;
  }
  else {
    if (!regexNombre.test(nombreRecinto.value)) {
      mensaje += `Formato de nombre incorrecto: <br>`
      mensaje += `2-252 caracteres y solo letras de la A-Z <br>`
      valido = false;
    }
  }
  if (correo.value == "") {
    mensaje += `El correo no puede ser vacio <br>`
    valido = false;
  }
  else {
    if (!regexEmail.test(correo.value)) {
      mensaje += `El formato del correo no es valido <br>`
      valido = false;
    }
  }
  if (direccion.value == "") {
    mensaje += `La dirección no puede ser vacia <br>`
    valido = false;
  }
  else{
    if(direccion.value.length > 250){
      mensaje += `El nombre de la dirección no puede ser tan extenso <br>`
      valido = false;
    }
  }
  if (nombrePersona.value == "") {
    mensaje += `El nombre del solicitante no puede ser vacio <br>`
    valido = false;
  }
  else {
    if (!regexNombre.test(nombrePersona.value)) {
      mensaje += `Formato de nombre incorrecto: <br>`
      mensaje += `2-252 caracteres y solo letras de la A-Z <br>`
      valido = false;
    }
  }
  if (pass.value == "") {
    mensaje += `La contraseña no puede ser vacia <br>`
    valido = false;
  }
  else {
    if (!regexPassword.test(pass.value)) {
      mensaje += `El formato de la contraseña no es valida <br>`
      valido = false;
    }
  }
  if (valido) {
    document.getElementById("panelverde").style.display = "";
    document.getElementById("panelrojo").style.display = "none";
    elementoExito.innerHTML = "Registrado con exito"
    registrarUsuario();
  }
  else {
    document.getElementById("panelrojo").style.display = "";
    document.getElementById("panelverde").style.display = "none";
    elementoError.innerHTML = mensaje
  }
}

async function registrarUsuario() {
  let datos = {};
  datos.correo = document.getElementById('txtEmail').value;
  datos.contrasena = document.getElementById('txtPassword').value;

  let repetirEmail = document.getElementById('txtRepetirEmail').value;
  let repetirPassword = document.getElementById('txtRepetirPassword').value;

  if (repetirEmail != datos.correo) {
    alert('El Email no coincide.');
    return;
  }

  if (repetirPassword != datos.contrasena) {
    alert('La contraseña no coincide.');
    return;
  }

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("La cuenta fue creada con exito!");
  window.location.href = 'login.html'

}