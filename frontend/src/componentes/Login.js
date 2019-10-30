import React from 'react';
import {Redirect, Link} from "react-router-dom";


export default class Login extends React.Component {

    entrar = (e) => {
        e.preventDefault();
        let usuario = {
            nick: 'dsandrade0',
            aniversario: '30/07/1989'
        };
        sessionStorage.setItem('nick', usuario.nick);
        sessionStorage.setItem('niver', usuario.aniversario);
        this.setState({'': ''});
    }

    novo = (e) => {
        e.preventDefault();
        //return (<Redirect to='/principal'/>);
    }

    render() {
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
                                <input type="email" className="form-control" id="exampleInputEmail1"
                                       aria-describedby="emailHelp" placeholder="Nick"/>
                            </div>
                            <div className="form-group">
                                <input type="password" className="form-control" id="exampleInputPassword1"
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
