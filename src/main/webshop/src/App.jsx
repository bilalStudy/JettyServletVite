import { useState, useEffect } from 'react'
import './App.css'

function CartItemList() {
    const [loading, setLoading] = useState(true);
    const [cartItems, setCartItems] = useState([]);

    useEffect(() => {
        (async () => {
            const res = await fetch("/api/cart");
            setCartItems(await res.json());
            setLoading(false);
        })();
    }, [])

    if (loading) {
        return <div>Loading...</div>
    }

    return <ul>{cartItems.map(c => <div>{c.itemName}</div>)}</ul>;
}

function App() {

  return (
    <div className="App">
    <h1>Webshop</h1>
        < CartItemList/>
    </div>
  )
}

export default App
