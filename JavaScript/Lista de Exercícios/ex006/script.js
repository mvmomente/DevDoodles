function reajuste(a) {
    return a * (5 / 100)
}

function mostrar() {
    let num = document.getElementById('txtn')
    let res = document.getElementById('res')

    let n = Number(num.value)

    if (num.value.length === 0 || n === 0 || isNaN(n)) {
        window.alert('[ERRO] Insira um valor válido ou maior que 0.')
        num.value = ''
        num.focus()
        return
    }

    let valorReajuste = reajuste(n)
    let valorNovo = n + valorReajuste

    res.innerText = `O valor de ${n} foi reajustado para 5%.\nNovo valor: ${valorNovo}`
}