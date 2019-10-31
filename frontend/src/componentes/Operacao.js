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
        let nivel = '';
        switch (operacao) {
            case '+':
                endPoint += '/soma';
                nivel = sessionStorage.getItem('nSoma');
                break;
            case '-':
                endPoint += '/subtracao';
                nivel = sessionStorage.getItem('nSub');
                break;
            case '*':
                endPoint += '/multiplicacao';
                nivel = sessionStorage.getItem('nMulti');
                break;
            case '/':
                endPoint += '/divisao';
                nivel = sessionStorage.getItem('nDiv');
                break;
        }
        xfetch(endPoint + '/' + nivel, {}, 'get')
            .then(res => res.json())
            .then(dados => this.setState({id: dados.id, fatorA: dados.fatorA, fatorB: dados.fatorB} ));
    }

    render() {
        console.log(this.state)
        const {fatorA, fatorB} = this.state;
        let op = this.props.operacao;
        if (op == '/') {
            op = '÷';
        }

        if (op == '*') {
            op = 'x';
        }
        return (
            <div className='row'>
                <div className='col-12'>
                    <div className='col-12'>
                        <div className="card">
                            <div className="card-body row text-center"  style={{paddingBottom: "15px"}}>
                                <div className='offset-2 col-8'>
                                    <h2 className='col-12'>{fatorA}</h2>
                                    <h2 className='col-12'>{fatorB}</h2>
                                </div>
                                <div className='col-1'>
                                    <h2 style={{marginTop: '15px'}}>
                                        {/*{this.props.operacao === '*' ? "x" : this.props.operacao}*/}
                                        {op}
                                    </h2>
                                </div>
                            </div>
                            <div className="offset-2 col-8 offset-lg-2 col-lg-8" style={{marginTop: "-30px"}}>
                                <hr style={{borderStyle: "5px", border: "1px solid red"}}/>
                            </div>
                            <div className="offset-2 col-8 prepend-top"  style={{marginBottom: "15px"}}>
                                <div className="col-12">
                                    <input
                                        placeholder="Resultado"
                                        className="form-control"
                                        type="number"
                                        pattern="\d*"
                                    />
                                </div>
                                <button className="col-12 btn btn-success prepend-top">
                                    Enviar
                                </button>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        );
    }

}
