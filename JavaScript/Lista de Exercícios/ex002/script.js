function verificar() {
    //Declara as variaveis NUM, N e RES.
    let num = document.getElementById('txtn')
    let n = Number(num.value)
    let res = document.getElementById('res')
    
    //Verificação para saber se o número digitado é 0. Caso sim, programa não roda.
    if (n == 0) {
        window.alert('Insira um Número válido!')
        
    } else {
        
        //Verificação para saber se o N quando dividido por 2 sobra 0. Assim define se é PAR ou IMPAR
        if (n%2 == 0) {
            res.innerHTML = `O Número ${n} é PAR`
        } else {
            res.innerHTML = `O Número ${n} é IMPAR`
        }
    }

    //Limpa o valor de NUM, logo em seguida direciona o foco para caixa input NUM.
    num.value = ''
    num.focus()
}