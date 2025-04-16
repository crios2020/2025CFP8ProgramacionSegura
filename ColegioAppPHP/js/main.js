function confirmarBorrar() {
    return confirm("Desea borrar un registro?")
}

function getDolar() {
    fetch('https://ipwhois.app/json/')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            const currencyRates = data.currency_rates;
            console.log('Currency Rates:', currencyRates);
            //document.getElementsByName("buscar").text=currencyRates
            //alert(currencyRates.toFixed(0))
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}