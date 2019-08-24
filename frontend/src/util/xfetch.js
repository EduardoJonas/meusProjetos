function xfetch(endPoint, dados, metodo) {

    const servidor = process.env.NODE_ENV === 'production' ? '': 'http://localhost:8080';

    const tipo = 'application/json';
    let headers = {
        headers: new Headers({'Content-Type': tipo}),
        method: metodo
    };

    if (metodo.toUpperCase() !== 'GET') {
        headers.body = JSON.stringify(dados);
    }
    console.log(servidor+endPoint);
    return fetch(servidor + endPoint, headers);
}

export {xfetch};