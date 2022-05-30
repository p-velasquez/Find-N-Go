function search() {
    var b = document.getElementById('search').value;
    localStorage.setItem("search", b);
    localStorage.setItem("deporte", '');
    if(b == ''){
        alert('La busqueda no puede estar vacia');
        return;
    }
    window.location.href = 'search-result.html'
}