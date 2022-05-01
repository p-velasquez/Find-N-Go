$(document).ready(function() {
   // on ready
});


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