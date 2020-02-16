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
        try {
            xfetch('/usuarios/ranking', {}, 'get')
                .then(resp => resp.json())
                .then(dados => this.setState({usuarios: dados}));

        } catch (e) {
            console.log(e);
        }
    }

    render() {
        const {usuarios} = this.state
        let semUsuarios = '';
        if (usuarios.length === 0) {
            semUsuarios =
                <div className="col-12">
                    <h5>Falha no servidor</h5>
                </div>;
        }
        return (
            <div className="container">
                <div className="col-12">
                    <div className="text-center">
                        <table className="col-12 table table-stripped table-hover">
                            <thead>
                                <tr>
                                    <th>Nick</th>
                                    <th>Pontos</th>
                                </tr>
                            </thead>
                            <tbody>

                                {usuarios.map((usuario, chave) => {
                                    return (
                                        <tr key={chave}>
                                            <td>{usuario.nick} - ( <b>{usuario.escola.nome} </b>)</td>
                                            <td>{usuario.pontos ? usuario.pontos : 0} pts</td>
                                        </tr>
                                    );
                                })}
                            </tbody>
                        </table>
                        {semUsuarios}
                    </div>
                </div>
            </div>
        );
    }
}

export default Ranking;
