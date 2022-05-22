/* Call the dataTables jQuery plugin
$(document).ready(function() {
    $('#usuarios').DataTable();
    cargarUsuarios();
    //  actualizarEmailDelUsuario();
});*/
// Sin Jquery
document.onload= cargarUsuarios();
async function cargarUsuarios() {
    const request = await fetch("usuarios",{
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await request.json();
    // Listar usuarios traidos desde el request
    let tablaUsuarios = document.querySelector("#usuarios tbody");
    let listadoUsuarios = "";
    for (let usuario of usuarios){
        let usuarioFila ='<tr>    <th scope="row">'+ usuario.id +'</th> <td>' + usuario.nombre +' '+ usuario.apellido +
            '</td> <td>' + usuario.email +
            '</td> <!--- Acciones --> <td> <a href="" class="btn btn-danger">Eliminar</a>     <a href="" class="btn btn-warning">Modificar</a> </td> </tr>';
        listadoUsuarios += usuarioFila;
    }
    tablaUsuarios.outerHTML = listadoUsuarios;
    console.log(usuarios[0].nombre);
}




