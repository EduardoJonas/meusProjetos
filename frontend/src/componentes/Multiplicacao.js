import React from 'react';
import Operacao from "./Operacao";
import Topo from "./Topo";

export default class Multiplicacao extends React.Component {

    render() {
        return (
            <div>
                <Topo/>
                Multiplicação
                <hr/>
                <Operacao operacao={'*'}/>
            </div>
        );
    }

}
