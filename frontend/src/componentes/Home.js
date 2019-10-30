import React from 'react';
import {Link, Redirect} from 'react-router-dom';
import Ranking from "./Ranking";

class Home extends React.Component<> {

    componentWillMount() {

    }

    render() {

        return (
            <div className="container">
                <div className="row prepend-top text-center">
                    <div className="col-12">
                        <h2 className=" text-center">Escolha a operação</h2>
                    </div>

                </div>
                <div className="row">
                    <div className="col prepend-top">
                        <div className="card">
                            <div className="card-body text-center">
                                <h5 className="card-title">Somar</h5>
                                <p className="card-text">Acerte a questão e ganhe 2 pontos.</p>
                                <Link to='/soma' className="btn btn-primary">Responder</Link>
                            </div>
                        </div>
                    </div>

                    <div className="col prepend-top">
                        <div className="card">
                            <div className="card-body text-center">
                                <h5 className="card-title">Diminuir</h5>
                                <p className="card-text">Acerte a questão e ganhe 2 pontos.</p>
                                <a href="/subtracao" className="btn btn-primary">Responder</a>
                            </div>
                        </div>
                    </div>

                    <div className="col prepend-top">
                        <div className="card">
                            <div className="card-body text-center">
                                <h5 className="card-title">Multiplicar</h5>
                                <p className="card-text">Acerte a questão e ganhe 3 pontos.</p>
                                <a href="/multiplicacao" className="btn btn-primary">Responder</a>
                            </div>
                        </div>
                    </div>

                    <div className="col prepend-top">
                        <div className="card">
                            <div className="card-body text-center">
                                <h5 className="card-title">Dividir</h5>
                                <p className="card-text">Acerte a questão e ganhe 3 pontos.</p>
                                <a href="/divisao" className="btn btn-primary">Responder</a>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div className="row">
                    <div className="col-12 text-center">
                        <h5>Ranking</h5>
                    </div>

                    <Ranking/>
                </div>
            </div>
        );
    }
}

export default Home;