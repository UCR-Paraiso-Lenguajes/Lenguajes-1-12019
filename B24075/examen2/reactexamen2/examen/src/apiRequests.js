
// Consulta la lista de departamentos
async function getDivisions() {
    // Por el momento retorna los datos quemados, el api debe devolver un JSON con este formato
    // Borrar cuando el api este implementada  
    return {
        divisions: [
            {
                id: '1',
                nombre: 'Asamblea de Socios',
                jefatura: '-',
                marcado: true
            },
            {
                id: '2',
                nombre: 'Gerente General',
                jefatura: 'Asamblea de Socios',
                marcado: true
            },
            {
                id: '3',
                nombre: 'Departamento Administrativo',
                jefatura: 'Gerente General',
                marcado: false
            },
            {
                id: '4',
                nombre: 'Departamento Comercial',
                jefatura: 'Gerente General',
                marcado: false
            }
        ]
    };
    // Descomentar cuando el api este implementada
    // let response = await fetch('api_url');
    // let json = await response.json();
    // return json;
}

export {getDivisions}