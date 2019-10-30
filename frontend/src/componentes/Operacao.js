import React from 'react';
import {xfetch} from "../util/xfetch";

export default class Operacao extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: '',
            fatorA: '',
            fatorB: '',
            resposta: ''
        };
    }

    componentDidMount() {
        let operacao = this.props.operacao;
        if (!operacao) {
            console.lop('Sem operacao');
        }

        let endPoint = '/operacao';
        switch (operacao) {
            case '+':
                endPoint += '/soma';
                break;
            case '-':
                endPoint += '/subtracao';
                break;
            case '*':
                endPoint += '/multiplicacao';
                break;
            case '/':
                endPoint += '/divisao';
                break;
        }
        xfetch(endPoint+'/'+'1', {}, 'get')
            .then(res => res.json())
            .then(dados => this.setState({id: dados.id, fatorA: dados.fatorA, fatorB: dados.fatorB} ));
    }

    render() {
        console.log(this.state)
        const {fatorA, fatorB} = this.state;
        return (
            <div className='row'>
                Operacao de {this.props.operacao}
                <hr/>
                <div className='offset-1 col-10 text-center'>
                    <div>
                    </div>
                    <label> {fatorA} {this.props.operacao} {fatorB} </label>
                </div>

            </div>
        );
    }

}
