import React from 'react';
import Operacao from "./Operacao";

export default class Multiplicacao extends React.Component {

    render() {
        return (
            <div>
                Multiplicação
                <hr/>
                <Operacao operacao={'*'}/>
            </div>
        );
    }

}
