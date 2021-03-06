function validarR() {
    const correo1 = document.getElementById("txtEmail")
    const correo2 = document.getElementById("txtRepetirEmail")
    const pass1 = document.getElementById("txtPassword")
    const pass2 = document.getElementById("txtRepetirPassword")
    const elementoError = document.getElementById("error")
    const elementoExito = document.getElementById("exito")
  let valido = true;
  let mensaje = ""
  let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/
  let regexPassword = /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/
  if (correo1.value == "") {
    mensaje += `El correo(1) no puede ser vacio <br>`
    valido = false;
  }
  else {
    if (!regexEmail.test(correo1.value)) {
      mensaje += `El formato del correo(1) no es valido <br>`
      valido = false;
    }
  }
  if (correo2.value == "") {
    mensaje += `El correo(2) no puede ser vacio <br>`
    valido = false;
  }
  else {
    if (!regexEmail.test(correo2.value)) {
      mensaje += `El formato del correo(2) no es valido <br>`
      valido = false;
    }
  }
  if (correo1.value != correo2.value) {
    mensaje += `Los correos deben ser iguales <br>`
    valido = false;
  }
  if (pass1.value == "") {
    mensaje += `La contraseña(1) no puede ser vacia <br>`
    valido = false;
  }
  else {
    if (!regexPassword.test(pass1.value)) {
      mensaje += `El formato de la contraseña(1) no es valida <br>`
      valido = false;
    }
  }
  if (pass2.value == "") {
    mensaje += `La contraseña(2) no puede ser vacia <br>`
    valido = false;
  }
  else {
    if (!regexPassword.test(pass2.value)) {
      mensaje += `El formato de la contraseña(2) no es valida <br>`
      valido = false;
    }
  }
  if (pass1.value != pass2.value) {
    mensaje += `Las contraseñas deben ser iguales <br>`
    valido = false;
  }

  if (valido) {
    document.getElementById("panelverde").style.display = "";
    document.getElementById("panelrojo").style.display = "none";
    elementoExito.innerHTML = "Registrado con exito"
    registrarUsuario();
  }
  else{
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