$(document).ready(function() {
  comunas();
  deportes();
  $('#ed');
  var value = localStorage.getItem("search");
  buscar(value);
  document.getElementById('search').value = value;
});

function search() {
    var a = document.getElementById('search').value;
    if(a != ''){
        localStorage.setItem("search", a);
    }
    var b = document.getElementById('deporte').value;
    localStorage.setItem("deporte", b);
    window.location.href = 'search-result.html'
}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function buscar(nombre) {
  var deporte = localStorage.getItem("deporte");

 const request = await fetch('api/eds/search?query=' + nombre, {
    method: 'GET',
    headers: getHeaders()
  });

  const eds = await request.json();
  var filtrados = eds.filter(x => x.idDeporte.id == deporte);
  if(deporte == '-1' || deporte == ''){
    filtrados = eds;
  }
      let listadoHtml = '';

      //Se agrega loop para recorrer todos los espacios deportivos e insertar cada vez un div con en el html.
      for (let ed of filtrados){

          let edHtml =
          '<div class="p-4 col-12 col-sm-12 col-md-6">' +
                      '<div onclick="cargarRecinto('+ ed.id +');" style="cursor: pointer;" class="card border-0">' +
                      '<div class="row g-0">' +
                      '<div class="col-sm-6" style="background: #868e96;">' +
                      '<img src="img/recintox.jpeg" class="card-img-top h-100">' +
                      '</div>' +
                      '<div class="col-sm-6">' +
                      '<div class="card-body">' +
                      '<h6>'+ed.idDeporte.nombre+'</h6>' +
                      '<h3 class="card-title">'+ ed.idRecinto.nombre +'</h3>' +
                      '<h6>'+ ed.idRecinto.idDireccion.calle + ' ' + ed.idRecinto.idDireccion.numero +'</h6>' +
                      '<h6>'+ ed.idRecinto.idDireccion.idComuna.nombre +'</h6>' +
                      '</div>' +
                      '</div>' +
                      '</div>' +
                      '</div>' +
                      '</div>';
              listadoHtml += edHtml;
      }

      document.querySelector('#ed').outerHTML = listadoHtml;
}

async function comunas() {

 const request = await fetch('api/comunas', {
    method: 'GET',
    headers: getHeaders()
  });

  const comunas = await request.json();

      let listadoHtml = '';
      for (let comuna of comunas){
          let comunaHtml = '<option value="'+ comuna.id +'">'+ comuna.nombre +'</option>';
              listadoHtml += comunaHtml;
      }

      document.querySelector('#comunas').outerHTML = listadoHtml;
}

async function deportes() {

 const request = await fetch('api/deportes', {
    method: 'GET',
    headers: getHeaders()
  });

  const deportes = await request.json();

      let listadoHtml = '';
      for (let deporte of deportes){
          let deporteHtml = '<option value="'+ deporte.id +'">'+ deporte.nombre +'</option>';
              listadoHtml += deporteHtml;
      }

      document.querySelector('#deportes').outerHTML = listadoHtml;
}

function cargarRecinto(id){
    localStorage.setItem("searchRecinto", id);
    window.location.href = 'ed.html'
}