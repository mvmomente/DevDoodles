// Função que calcula quantos salários mínimos cabem no salário informado.
// Usa Math.floor para arredondar para baixo, mostrando salários completos.
// Recebe o salário e permite definir o valor do salário mínimo (com padrão).
function calcular(salario, salarioMinimo = 1293.20) {
    return Math.floor(salario / salarioMinimo)
}

function mostrar() {
    // Captura o elemento input onde o usuário digita o salário
    const num = document.getElementById('txtn')
    // Captura o elemento onde o resultado será exibido
    const res = document.getElementById('res')

    // Converte o valor do input (string) para número
    const n = Number(num.value)

    // Validação da entrada:
    // - Verifica se o campo está vazio
    // - Verifica se o valor não é um número válido
    // - Verifica se o valor é menor ou igual a zero
    // Se alguma dessas condições for verdadeira, exibe alerta e interrompe execução
    if (num.value.length === 0 || isNaN(n) || n <= 0) {
        window.alert('[ERRO] Insira um número válido ou maior que 0.')
        num.value = ''  // limpa o campo para nova entrada
        num.focus()     // foca o campo para facilitar correção do usuário
        return          // para a função aqui, não executa o restante
    }

    // Calcula quantos salários mínimos cabem no salário informado
    const salRes = calcular(n)

    // Exibe o resultado para o usuário, formatado em texto simples
    res.innerText = `Você ganha ${salRes} Salário min.`
}
