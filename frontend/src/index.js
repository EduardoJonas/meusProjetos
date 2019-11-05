import React from 'react';
import ReactDOM from 'react-dom';
import Ranking from "./componentes/Ranking";
import Erro404 from "./componentes/Erro404";
import * as serviceWorker from './serviceWorker';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {Container} from "semantic-ui-react";
import Home from "./componentes/Home";
import Topo from './componentes/Topo'
import Soma from './componentes/Soma'
import Subtracao from "./componentes/Subtracao";
import Multiplicacao from "./componentes/Multiplicacao";
import Divisao from "./componentes/Divisao";
import Login from "./componentes/Login";
import NovoJogador from "./componentes/NovoJogador"
import {ToastContainer} from "react-toastify";

ReactDOM.render(
    <BrowserRouter>
        <Container>
            <Switch>
                <Route path="/" exact={true} component={Login} />
                <Route path="/principal" exact={true} component={Home}/>
                <Route path="/soma" exact={true} component={Soma}/>
                <Route path="/subtracao" exact={true} component={Subtracao}/>
                <Route path="/multiplicacao" exact={true} component={Multiplicacao}/>
                <Route path="/divisao" exact={true} component={Divisao}/>
                <Route path="/ranking" exact={true} component={Ranking}/>
                <Route path="/novoJogador" exact={true} component={NovoJogador}/>
                <Route component={Erro404}/>
            </Switch>
        </Container>
    </BrowserRouter>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
