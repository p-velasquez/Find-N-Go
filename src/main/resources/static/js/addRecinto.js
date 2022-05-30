async function agregarED() {
    const request = await fetch('api/eds', {
        method: 'POST',
        headers: getHeaders()
    });

    const ed = await request.json();
}
function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}