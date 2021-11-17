import React, { Component } from 'react';
import StockService from '../services/StockService';
import ButtonEditDelete from './ButtonComponent';
import Button from '@mui/material/Button';

class ListStockComponent extends Component {
    constructor(props) {
        super(props)
        
        this.state = {
            stocks : []
        }
    }

    componentDidMount() {
        StockService.getStocks().then((res) => {
            this.setState({ stocks : res.data });
        });
    }
    render() {
        return (
            <div> <br />
                <h1 className="text-center">Stock List</h1> <br />
                <div style={{marginBottom: "10px"}}>
                <Button variant="contained" 
                onClick={() => {
                    alert('clicked');
                }} size="medium">Add</Button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Stock Name</th>
                                <th>Stock Quantity</th>
                                <th>Stock Price</th>
                                <th>Stock Description</th>
                                <th>Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                            this.state.stocks.map(
                                stock =>
                                <tr key={ stock.id }>
                                    <td>{ stock.id }</td>
                                    <td>{ stock.name }</td>
                                    <td>{ stock.quantity }</td>
                                    <td>{ stock.price }</td>
                                    <td>{ stock.description }</td>
                                    <td>
                                        <ButtonEditDelete/>
                                    </td>
                                </tr>
                            )
                            }
                        </tbody>

                    </table>
                </div>
            </div>
        );
    }
}

export default ListStockComponent;