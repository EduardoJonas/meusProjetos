import React from 'react';
import Operacao from "./Operacao";
import Topo from "./Topo";

export default class Divisao extends React.Component {

    render() {
        return (
            <div>
                <Topo/>
                Divisao
                <hr/>
                <Operacao operacao='/'/>
            </div>
        );
    }
}
