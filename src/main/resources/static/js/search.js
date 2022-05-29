function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function buscar(nombre) {

 const request = await fetch('api/eds/' + nombre, {
    method: 'GET',
    headers: getHeaders()
  });

  const ed = await request.json();

      let edHTML = '';

      //Se agrega loop para recorrer todos los espacios deportivos e insertar cada vez un div con en el html.
      for (let ed of eds){
          let edHTML =
              '<div class="p-4 col-12 col-sm-12 col-md-6" id="recintos">' +
              '<div class="card border-0">' +
              '<div class="row g-0">' +
              '<div class="col-sm-6" style="background: #868e96;">' +
              '<img src="img/recintox.jpeg" class="card-img-top h-100" alt="...">' +
              '</div>' +
              '<div class="col-sm-6">' +
              '<div class="card-body">' +
              '<h6>Futbol</h6>' +
              '<h3 class="card-title">+recinto.nombre+</h3>' +
              '<h6>Direccion falsa</h6>' +
              '<h6>Providencia</h6>' +
              '</div>' +
              '</div>' +
              '</div>' +
              '</div>';
      }

      document.querySelector('#ed').outerHTML = edHTML;

  location.reload()
}