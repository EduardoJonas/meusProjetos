import React from 'react';
import {Link, Redirect} from 'react-router-dom'

export default class Topo extends React.Component<> {
    constructor(props) {
        super(props);
        this.state = {
            nick: '',
        };
    }

    componentWillMount() {
        let nick = sessionStorage.getItem('nick');
        this.setState({nick: nick});
    }

    sair = (e) => {
        e.preventDefault();
        sessionStorage.clear();
        this.setState({nick: ''});
    }

    render() {
        const {nick} = this.state;
        if (!nick) {
            return (<Redirect to='/'/>);
        }
        return (
            <div className="row">
                <nav className="prepend-top col-12 navbar navbar-expand-lg navbar-light">
                    <span className="navbar-brand" href="#">
                        <Link to='/principal'>Pitagoras</Link>
                    </span>
                    <div className='offset-8 col-4 '>
                        <label> Ola {nick}</label>
                        <span style={{marginRight: '5px'}}/>
                        <button onClick={this.sair}>sair</button>
                    </div>
                </nav>
            </div>
        );
    }
}
