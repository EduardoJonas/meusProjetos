import React from 'react'
import {Link, Redirect} from 'react-router-dom'
import $ from 'jquery'
import mask from 'jquery-mask-plugin'
import axios from 'axios';
import {servidor, xfetch} from "../util/xfetch";


class NovoJogador extends React.Component<> {
    constructor(props) {
        super(props);
        this.state = {
            nome: '',
            escola: '',
            nick: '',
            data: '',
            escolas: [],
            aguarde: false,
        };
    }

    componentWillMount() {

    }
    componentDidMount() {
        $('#idData').mask('99/99/9999');
        this.setState({aguarde: true});
        xfetch('/escolas/todas', {}, 'get')
            .then(res => res.json())
            .then(dados => this.setState({escolas: dados, aguarde: false} ) )
    }

    handleChange = (e) => {
        this.setState({[e.target.name]: e.target.value});
    }

    novo = (e) => {
        e.preventDefault();
        //TODO enviar os dados para o servidor
        const {nome, escola, nick, data} = this.state;
        let dados = {
            'nome': nome,
            'nick': nick,
            'escola': escola,
            'data': data
        };
        console.log(dados);
        let that = this;
        $.post(servidor + '/usuarios/novo', dados, function(res) {
            that.setState({nome: '', escola: '', nick: '', data: ''})
        });
    }

    render() {
        const {nome, escola, nick, data, aguarde, escolas} = this.state;
        let comboEscolas = escolas.map((v, k) => {
            return <option key={k} value={v.id}> {v.nome} </option>;
        });
        let carregando = '';
        if (aguarde) {
            carregando = <div> Carregando... </div>;
        }
        return (
            <div className='container'>
                <div className='row prepend-top text-center'>
                    <div className='col-12'>
                        <h1>Pitagoras</h1>
                    </div>
                </div>

                <div className='row text-center'>
                    {carregando}
                    <div className='offset-1 col-10'>
                        <form className='prepend-top'>
                            <div className="form-group">
                                <input
                                    type="text"
                                    name='nome'
                                    value={nome}
                                    onChange={this.handleChange}
                                    className="form-control"
                                    placeholder="Nome"/>
                            </div>
                            <div className="form-group">
                                <input type="text" name='nick'
                                       className="form-control"
                                       onChange={this.handleChange}
                                       value={nick.toLowerCase()}
                                       placeholder="Nick"/>
                                <small id="passwordHelpBlock"
                                       className="form-text text-muted">
                                    Ex: {nome.replace(' ', '').toLowerCase()+'0'}
                                </small>
                            </div>
                            <div className="form-group">
                                <select
                                    onChange={this.handleChange}
                                    name='escola'
                                    className='form-control'>
                                    <option>Selecione a escola</option>
                                    {comboEscolas}
                                </select>
                            </div>
                            <div className="form-group">
                                <input
                                    onChange={this.handleChange}
                                    type="text" className="form-control"
                                    id='idData'
                                    name='data'
                                    pattern="\d*"
                                    value={data}
                                    placeholder="Data Nascimento"/>
                            </div>
                            <button id='idCadastrar' onClick={this.novo}
                                    className=' col-12 prepend-top btn btn-success'>
                                Cadastrar
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default NovoJogador;
