function CargarPDFCanvas() {
    var viewer;

    viewer = new PDFViewer($('#viewer'));

    var clickP;


    clickP = document.getElementById('direccion').getAttribute('value');
    if (clickP != null)
        document.getElementById('apendB').click();

}
$(window).load(CargarPDFCanvas());

function archivo() {
    var archbinar = document.getElementById('direccion').getAttribute('value');
    var blob = new Blob([archbinar], { type: "application/pdf;base64" });
    var url = URL.createObjectURL(blob);
    document.getElementById('viewer').setAttribute(['data-url'], url);
    document.getElementById('apendB').click();

}
function alertMe() {
    var archbinar = document.getElementById('direccion').getAttribute('value');
    document.getElementById('viewer').setAttribute(['data-url'], archbinar);

}

