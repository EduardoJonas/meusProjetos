import React from 'react';
import Operacao from "./Operacao";

export default class Divisao extends React.Component {

    render() {
        return (
            <div>
                Divisao
                <hr/>
                <Operacao operacao='/'/>
            </div>
        );
    }
}