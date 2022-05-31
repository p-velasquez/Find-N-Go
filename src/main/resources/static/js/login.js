function validar() {
    const correo = document.getElementById("txtEmail")
    const pass = document.getElementById("txtPassword")
    const elementoError = document.getElementById("error")
    const elementoExito = document.getElementById("exito")
  let valido = true;
  let mensaje = ""
  let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/
  let regexPassword = /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/
  if (correo.value == "") {
    mensaje += `El correo no puede ser vacio <br>`
    valido = false;
  }
  else{
    if(!regexEmail.test(correo.value)){
      mensaje += `El formato del correo no es valido <br>`
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
    document.getElementById("exito").textContent = "Iniciando sesión...";
    iniciarSesion();
  }
  else {
    document.getElementById("panelrojo").style.display = "";
    document.getElementById("panelverde").style.display = "none";
    elementoError.innerHTML = mensaje
  }
}


async function iniciarSesion() {
  let datos = {};
  datos.correo = document.getElementById('txtEmail').value;
  datos.contrasena = document.getElementById('txtPassword').value;

  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const respuesta = await request.text();
  if (respuesta != 'FAIL') {
    localStorage.token = respuesta;
    localStorage.correo = datos.correo;
    window.location.href = 'search.html'
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }

}