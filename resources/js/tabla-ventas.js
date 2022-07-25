var Fila = null
function onSubmit() {
        let DataForm = Leer()
        if (Fila == null){
            InsertarDatos(DataForm)
        } else{
            Actualizar(DataForm)
            Vaciar()
    }
}
function Leer() {
    let DataForm = {}
    DataForm["idventa"] = document.getElementById("idventa").value
    DataForm["fecha"] = document.getElementById("fecha").value
    DataForm["idusuario"] = document.getElementById("idusuario").value
    DataForm["idproducto"] = document.getElementById("idproducto").value
    DataForm["cantidad"] = document.getElementById("cantidad").value
    DataForm["valorpagar"] = document.getElementById("valorpagar").value
    DataForm["totalventa"] = document.getElementById("totalventa").value
    return DataForm
}
function InsertarDatos(data) {
    let table = document.getElementById("tabla").getElementsByTagName('tbody')[0]
    let Fila = table.insertRow(table.length)
    columna1 = Fila.insertCell(0).innerHTML = data.idventa
    columna2 = Fila.insertCell(1).innerHTML = data.fecha
    columna3 = Fila.insertCell(2).innerHTML = data.idusuario
    columna4 = Fila.insertCell(3).innerHTML = data.idproducto
    columna5 = Fila.insertCell(4).innerHTML = data.cantidad
    columna6 = Fila.insertCell(5).innerHTML = data.valorpagar
    columna7 = Fila.insertCell(6).innerHTML = data.totalventa
    columna8 = Fila.insertCell(7).innerHTML = `<input class="submit" type="button" onClick="Editarr(this)" value="Editar" >
                                            <input class="submit" type="button" onClick="Borrarr(this)" value="Borrar" >`
    document.getElementById("idventa").focus()
    Vaciar()
}
function Vaciar() {
    document.getElementById("idventa").value = ""
    document.getElementById("fecha").value = ""
    document.getElementById("idusuario").value = ""
    document.getElementById("idproducto").value = ""
    document.getElementById("cantidad").value = ""
    document.getElementById("valorpagar").value = ""
    document.getElementById("totalventa").value = ""
    Fila = null
}
function Editarr(td) {
    Fila = td.parentElement.parentElement
    document.getElementById("idventa").value = Fila.cells[0].innerHTML
    document.getElementById("fecha").value = Fila.cells[1].innerHTML
    document.getElementById("idusuario").value = Fila.cells[2].innerHTML
    document.getElementById("idproducto").value = Fila.cells[2].innerHTML
    document.getElementById("cantidad").value = Fila.cells[2].innerHTML
    document.getElementById("valorpagar").value = Fila.cells[2].innerHTML
    document.getElementById("totalventa").value = Fila.cells[2].innerHTML
}
function Actualizar(DataForm) {
    Fila.cells[0].innerHTML = DataForm.idventa
    Fila.cells[1].innerHTML = DataForm.fecha
    Fila.cells[2].innerHTML = DataForm.idusuario
    Fila.cells[3].innerHTML = DataForm.idproducto
    Fila.cells[4].innerHTML = DataForm.cantidad
    Fila.cells[5].innerHTML = DataForm.valorpagar
    Fila.cells[6].innerHTML = DataForm.totalventa
    document.getElementById("idventa").focus()
}
function Borrarr(td) {
    if (confirm('¿Seguro de borrar este registro?')) {
        row = td.parentElement.parentElement
        document.getElementById("tabla").deleteRow(row.rowIndex)
        Vaciar()
    }
}
