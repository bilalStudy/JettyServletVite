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

    return <ul>{cartItems.map(c => <div>{c.itemName}{c.itemPrice}</div>)}</ul>;
}

function AddCartItem(){
    const [title, setTitle] = useState("");
    const [author, setAuthor] = useState("");

    async function handleSubmit(e) {
        e.preventDefault();
        await fetch("/api/cart", {
            method: "post",
            body: JSON.stringify({itemName, itemPrice}),
            headers: {
                "Content-Type": "application/json"
            }
        });
    }

    return <div>
        <form onSubmit={handleSubmit}>
            <div><label>Title: <input type="text" value={title} onChange={e => setTitle(e.target.value)} /></label></div>
            <div><label>Author: <input type="text" value={author} onChange={e => setAuthor(e.target.value)} /></label></div>
            <div>
                <button>Submit</button>
            </div>
        </form>
    </div>;
}

function App() {

  return (
    <div className="App">
    <h1>Webshop</h1>
        < CartItemList/>
        < AddCartItem/>
    </div>
  )
}

export default App
