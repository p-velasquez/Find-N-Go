$(document).ready(function() {
    var value = localStorage.getItem("searchRecinto");
    buscar(value);
    console.log(value);
    $('#ed');
});

async function buscar(id) {

 const request = await fetch('api/eds/id?query=' + id, {
    method: 'GET',
    headers: getHeaders()
  });

  const eds = await request.json();

      for (let ed of eds){
          document.getElementById('title').innerHTML = ed.idRecinto.nombre;
          document.getElementById('description').innerHTML = ed.descripcion;
      }

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}
