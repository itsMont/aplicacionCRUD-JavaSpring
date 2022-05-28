/* Call the dataTables jQuery plugin
$(document).ready(function() {
    $('#usuarios').DataTable();
    cargarUsuarios();
    //  actualizarEmailDelUsuario();
});*/
// Sin Jquery
document.onload= cargarUsuarios();
function actualizarEmailDelUsuario(nombre){
    document.getElementById("emailUsuario").innerHTML = "   Perfil: <u>" + localStorage.email + "</u>";
}
async function cargarUsuarios() {
    const request = await fetch("api/usuarios",{
        method: 'GET',
        headers: getHeaders()
    });
    const usuarios = await request.json();
    // Listar usuarios traidos desde el request
    let tablaUsuarios = document.querySelector("#usuarios tbody");
    let listadoUsuarios = "";
    for (let usuario of usuarios){
        let botonEliminar = '<a href="" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger">Eliminar</a>';
        let usuarioFila ='<tr>    <th scope="row">'+ usuario.id +'</th> <td>' + usuario.nombre +' '+ usuario.apellido +
            '</td> <td>' + usuario.email +
            '</td> <!--- Acciones --> <td>' + botonEliminar +'<a href="" class="btn btn-warning">Modificar</a> </td> </tr>';
        listadoUsuarios += usuarioFila;
    }
    tablaUsuarios.outerHTML = listadoUsuarios;
    actualizarEmailDelUsuario();
}
// DRY
function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    }
}

function eliminarUsuario(id){
    if (!confirm("¿Desea eliminar el usuario?")){
        return;
    }
    // Hacemos request ahora al api/usuarios/{id}
    // Por algún motivo no sirve en Firefox esta parte en la página usuarios.html.
    // en usuarios1.html sí sirve
    const request = fetch("api/usuarios/" + id,{
        method: 'DELETE',
        headers: getHeaders()
    });
    window.location.reload();
}

