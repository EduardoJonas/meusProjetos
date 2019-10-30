const servidor =
    (process.env.NODE_ENV === 'production')
        ? 'http://pitagoras.dsandrade.info'
        : 'http://10.0.0.4:8080';

function xfetch(endPoint, dados, metodo) {

    const tipo = 'application/json';
    let headers = {
       // headers: new Headers({'Content-Type': tipo}),
        method: metodo
    };

    if (metodo.toUpperCase() !== 'GET') {
        headers.body = JSON.stringify(dados);
    }
    console.log('headers');
    console.log(headers);
    return fetch(servidor + endPoint, headers);
}

export {xfetch, servidor};
