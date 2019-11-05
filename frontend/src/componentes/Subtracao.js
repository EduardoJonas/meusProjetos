import React from 'react';
import Operacao from "./Operacao";
import Topo from "./Topo";

export default class Subtracao extends React.Component {

    render() {
        return (
            <div>
                <Topo/>
                Subtracao
                <hr/>
                <Operacao operacao={'-'}/>
            </div>
        );
    }
}
