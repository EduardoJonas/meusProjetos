import React from 'react';
import Operacao from "./Operacao";

export default class Subtracao extends React.Component {

    render() {
        return (
            <div>
                Subtracao
                <hr/>
                <Operacao operacao={'-'}/>
            </div>
        );
    }
}
