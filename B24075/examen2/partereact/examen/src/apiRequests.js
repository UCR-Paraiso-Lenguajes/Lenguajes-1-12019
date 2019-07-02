
// Consulta la lista de departamentos
async function getDivisions() {

    var myHeaders = new Headers();
    myHeaders.append("Access-Control-Allow-Origin", "*");
    var headers = { headers: myHeaders };

     let response = await fetch('https://localhost:44369/api/departamento/',headers);
     let json = await response.json();
     console.log(json);
     return json;
}

export {getDivisions}
