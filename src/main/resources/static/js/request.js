// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarEds();
  $('#eds').DataTable();
});

async function cargarEds() {
  const request = await fetch('api/eds', {
    method: 'GET',
    headers: getHeaders()
  });
  const eds = await request.json();

  let listadoHtml = '';
  for (let ed of eds) {
      let botonEditar = '<a href="addEd.html" onclick="" class="btn btn-info btn-circle btn-sm ml-1"><i class="fas fa-pen"></i></a>';
      let botonHorario = '<a href=addEdSchedule.html" onclick="" class="btn btn-info btn-circle btn-sm ml-1"><i class="fas fa-calendar"></i></a>';
      let botonEliminar = '<a href="#" onclick="eliminarEd(' + ed.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
      let edHtml = '<tr><td>'+ed.idDeporte.nombre+'</td><td>' + botonEditar + botonHorario + botonEliminar + '</td></tr>';
      listadoHtml += edHtml;
  }

  document.querySelector('#eds tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json'
   };
}

async function eliminarEd(id) {

  if (!confirm('¿Desea eliminar este espacio deportivo?')) {
    return;
  }

 const request = await fetch('api/eds/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload()
}
