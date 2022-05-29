$(document).ready(function() {
    cargarED();
    $('#ed');
});

async function cargarED(id) {
    const request = await fetch('api/eds/' + id, {
        method: 'GET',
        headers: getHeaders()
    });

    const ed = await request.json();

    //Se agrega la informacion del ed clickeado

    let edHTML = '';

    document.querySelector('#ed').outerHTML = edHTML;
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}
