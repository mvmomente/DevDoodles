function confirmarBoolean(a, b) {
    return a === b;
}

function btnValidar() {
    let chkN = document.getElementById('chkNetflix')
    let chkP = document.getElementById('chkPrime')
    let res = document.getElementById('res')

    let comparar = confirmarBoolean(chkN.checked, chkP.checked)
    
    if (comparar === true) {
        res.innerText = `Os dois valores são TRUE/FALSE`
    } else {
        res.innerText = `Os dois valores são diferentes`
    }
}