function cargarReloj(){
    momentoActual = new Date()
    hora = momentoActual.getHours().toString().padStart(2,"0")
    minuto = momentoActual.getMinutes().toString().padStart(2,"0")
    segundo = momentoActual.getSeconds().toString().padStart(2,"0")

    horaImprimible = hora + " : " + minuto + " : " + segundo

    document.getElementById("reloj").innerText = horaImprimible

    setTimeout("cargarReloj()",1000)
}