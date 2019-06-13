function Mensaje() {
    var mensaje = document.getElementById('mensaje').innerText;
    var titulo = document.getElementById('alert').innerText;
                var dialogId = 'my-dialog-1';
                var dialog = new BootstrapDialog({
                    id: dialogId,
                    title: titulo,
                    message: mensaje
                });
                dialog.open();
            };