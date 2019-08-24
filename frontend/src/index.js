import React from 'react';
import ReactDOM from 'react-dom';
import Ranking from "./componentes/ranking";
import Erro404 from "./componentes/Erro404";
import * as serviceWorker from './serviceWorker';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {Container} from "semantic-ui-react";

ReactDOM.render(<BrowserRouter>
    <Container>
        <Switch>
            {/*<Route path="/" exact={true} component={Login} /> */}
            <Route path="/" exact={true} component={Ranking} />
            <Route component={Erro404} />
        </Switch>
    </Container>
</BrowserRouter>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
