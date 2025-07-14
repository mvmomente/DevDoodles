function somar() {

    //Declara as variaveis NUM1, NUM2 e NUM3 já como numeros.
    let num1 = Number(document.getElementById('txtn1').value)
    let num2 = Number(document.getElementById('txtn2').value)
    let num3 = Number(document.getElementById('txtn3').value)
    let res = document.getElementById('res')

    //Verifica se as váriaveis são realmente numeros.
    if (isNaN(num1) || isNaN(num2) || isNaN(num3)) {
        window.alert('[ERRO] Digite um Número válido!') 
    } else {
        //Declara variavel soma dos dois Números.
        let soma = num1 + num2

        //Verifica se a soma das variaveis NUM1 e NUM2 são maior que a variavel NUM3.
        if (soma <= num3) {
            res.innerHTML = `${num1} + ${num2} = ${soma}`
            res.innerHTML += `<br>A soma dos dois numeros é menor que ${num3}`
        } else {
            res.innerHTML = `${num1} + ${num2} = ${soma}`
            res.innerHTML += `<br>A soma dos dois numeros é maior que ${num3}`
        }

    }

}