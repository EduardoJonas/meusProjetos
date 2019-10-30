import React from 'react';
import Operacao from "./Operacao";

export default class Soma extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                Soma
                <hr/>
                <Operacao operacao={'+'}/>
            </div>
        );
    }
}