$(document).ready(function() {
    var value = localStorage.getItem("searchResult");
    cargarED(value);
    $('#ed');
});

async function buscar(id) {

 const request = await fetch('api/eds/search?query=' + id, {
    method: 'GET',
    headers: getHeaders()
  });

  const eds = await request.json();
      let listadoHtml = '';

      //Se agrega loop para recorrer todos los espacios deportivos e insertar cada vez un div con en el html.
      for (let ed of eds){

          let edHtml = 'aca los ed.info';
              listadoHtml += edHtml;
      }

      document.querySelector('#ed').outerHTML = listadoHtml;
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}
