function decrescente(a, b, c) {
    let num = [a, b, c]
    return num.sort((x, y) => y - x)
}

function btnValidar() {
    let num1 = document.getElementById('txtn1')
    let num2 = document.getElementById('txtn2')
    let num3 = document.getElementById('txtn3')
    let res = document.getElementById('res')

    let n1 = Number(num1.value)
    let n2 = Number(num2.value)
    let n3 = Number(num3.value)

    if (num1.value.length === 0 || num2.value.length === 0 || num3.value.length === 0) {
        window.alert('[ERRO] Insira um número válido.')
        num1.value = ''
        num2.value = ''
        num3.value = ''
        num1.focus()
        return
    }

    let opDecrescente = decrescente(n1, n2, n3)

    res.innerText = `Os numeros em ordem dcrescente são: ${opDecrescente}`
}