import React from 'react';
import {Redirect, Link} from "react-router-dom";
import $ from 'jquery'
import mask from 'jquery-mask-plugin'
import {servidor} from "../util/xfetch";


export default class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            nick: '',
            nascimento: ''
        }
    }

    entrar = (e) => {
        e.preventDefault();
        const {nick, nascimento} = this.state;
        if (!nick || !nascimento) {
            alert('Insira os dados');
            return;
        }

        let usuario = {
            nick: nick,
            nascimento: nascimento
        };

        $.post(servidor + '/usuarios/login', usuario, function(result, status) {
            if (status == 'success') {
                sessionStorage.setItem('nick', result.nick)
                sessionStorage.setItem('idUsuario', result.id)
                sessionStorage.setItem('escola', result.escola.nome)
                sessionStorage.setItem('nascimento', result.nascimento)
                sessionStorage.setItem('nSoma', result.nivelSoma)
                sessionStorage.setItem('nSub', result.nivelSubtracao)
                sessionStorage.setItem('nMulti', result.nivelMultiplicacao)
                sessionStorage.setItem('nDiv', result.nivelDivisao)

                document.location = '/principal';
            }
        });

        this.setState({'': ''});
    }

    novo = (e) => {
        e.preventDefault();
        //return (<Redirect to='/principal'/>);
    }

    handleChange = (e) => {
        this.setState({[e.target.name]: e.target.value});
    }

    componentDidMount() {
        $('#idNascimento').mask('99/99/9999');
    }

    render() {
        const {nick, nascimento} = this.state;
        if (sessionStorage.getItem('nick')) {
            document.location = '/principal';
            //return (<Redirect to='/principal'/>);
            return;
        }
        return (
            <div className='container'>
                <div className='row prepend-top text-center'>
                    <div className='col-12'>
                        <h1>Pitagoras</h1>
                    </div>
                </div>

                <div className='row text-center'>
                    <div className='offset-1 col-10'>
                        <form className='prepend-top'>
                            <div className="form-group">
                                <input
                                    type="text"
                                    className="form-control"
                                    name="nick"
                                    value={nick}
                                    onChange={this.handleChange}
                                    placeholder="Nick"/>
                            </div>
                            <div className="form-group">
                                <input type="text"
                                       pattern="\d*"
                                       className="form-control"
                                       id="idNascimento"
                                       name="nascimento"
                                       value={nascimento}
                                       onChange={this.handleChange}
                                       placeholder="Data Nascimento"/>
                            </div>
                            <button className="col-12 btn btn-primary" onClick={this.entrar}>
                                Entrar
                            </button>
                            <span className='col-12 prepend-top btn'>
                                <Link to='/novoJogador'>
                                    Novo jogador
                                </Link>
                            </span>
                        </form>

                    </div>
                </div>
            </div>
        );
    }
}
