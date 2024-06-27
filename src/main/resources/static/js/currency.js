let currencyDropDown = document.getElementById("currency");
currencyDropDown.addEventListener('change', currencyChange);
function currencyChange() {
    let selectedCurrency = currencyDropDown.value;
    let amountInBGN = document.getElementById('priceInBGN').value;
    let price = document.getElementById('price');
    fetch('/api/convert?' + new URLSearchParams(
        {
            from: 'BGN',
            to: selectedCurrency,
            amount: amountInBGN
        }))
        .then(response => response.json())
        .then(data => {price.textContent = data.result})
        .catch(error => {
            console.log('An error occurred: ' + error)
        })
}
