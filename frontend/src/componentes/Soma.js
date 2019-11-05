import React from 'react';
import Operacao from "./Operacao";
import Topo from "./Topo";

export default class Soma extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Topo/>
                Soma
                <hr/>
                <Operacao operacao={'+'}/>
            </div>
        );
    }
}
