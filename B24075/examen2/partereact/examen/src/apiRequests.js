
// Consulta la lista de departamentos
async function getDivisions() {
    // Por el momento retorna los datos quemados, el api debe devolver un JSON con este formato
    // Borrar cuando el api este implementada  
    // Descomentar cuando el api este implementada
     let response = await fetch('https://localhost:44369/api/departamento/');
     let json = await response.json();
     console.log(json);
     return json;
}

export {getDivisions}