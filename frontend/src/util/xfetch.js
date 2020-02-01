const servidor =
    (process.env.NODE_ENV === 'production')
        ? 'http://pitagoras.dsandrade.info/api'
        : 'http://192.168.10.109:8080/api';

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
