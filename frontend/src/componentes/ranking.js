import React from 'react'
import {xfetch} from "../util/xfetch";

class Ranking extends React.Component<> {
    constructor(props) {
        super(props);
        this.state = {
            usuarios: []
        }
    }

    componentDidMount() {
        xfetch('/usuarios/ranking', {}, 'get')
            .then(resp => resp.json())
            .then(dados => this.setState({usuarios: dados}));
    }

    render() {
        const {usuarios} = this.state
        return (
            <div className="container">
                <div className="offset-4 col-4">
                    <div className="text-center">
                        <ul>
                        {usuarios.map((usuario, chave) => {
                            return (
                                <li key={chave}>
                                    {usuario.nick} - {usuario.pontos ? usuario.pontos : 0} pts
                                </li>
                            );
                        })}
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}

export default Ranking;