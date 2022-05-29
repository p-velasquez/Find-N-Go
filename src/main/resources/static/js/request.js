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
  const ed = await request.json();

  let listadoHtml = '';
  for (let ed of eds) {
      let botonDetalle = '<a href="#" onclick="" class="btn btn-info btn-circle btn-sm ml-1"><i class="fas fa-pen"></i></a>';
      let botonAceptar = '<a href="#" onclick="" class="btn btn-info btn-circle btn-sm ml-1"><i class="fas fa-pen"></i></a>';
      let botonEliminar = '<a href="#" onclick="eliminarEd(' + ed.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
      let solicitudHtml = '<tr><td>'+solicitud.fecha+'</td><td>' + solicitud.tipo + '</td><td>' + solicitud.id + '</td><td>' + botonDetalle + botonAceptar + botonRechazar + '</td></tr>';
      listadoHtml += solicitudHtml;
  }

  document.querySelector('#solicitudes tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function eliminarEd(id) {

  if (!confirm('¿Desea rechazar esta solicitud?')) {
    return;
  }

 const request = await fetch('api/eds/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload()
}
