// Função separada para encapsular a lógica de cálculo dos valores vizinhos.
// Isso facilita manutenção futura ou reuso em outros contextos.
function operacao(a) {
    return { 
        antecessor: a - 1, 
        sucessor: a + 1 
    }
}

function aoClicar() {
    // Captura os elementos da interface: o campo de entrada e a área de exibição do resultado.
    // Armazenar essas referências evita chamadas repetidas ao DOM e melhora a clareza.
    const num = document.getElementById('txtn')
    const res = document.getElementById('res')

    // Convertemos o valor do input (sempre recebido como string) para número.
    const n = Number(num.value)

    // Validação: impedimos que o valor inserido seja inválido ou vazio.
    // Isso evita que a função continue com dados incorretos, o que causaria erro ou resultado errado.
    if (isNaN(n) || num.value.length === 0) {
        window.alert('[ERRO] Insira um número válido.')
        return // Sai da função para impedir execução com valor inválido
    }

    // Aplicamos a função pura que calcula antecessor e sucessor, 
    // e usamos desestruturação para extrair os valores diretamente.
    const { antecessor, sucessor } = operacao(n)

    // Atualizamos o conteúdo da página com o resultado formatado.
    // Usamos <br> para forçar quebras de linha na saída visual.
    res.innerHTML = 
        `Número digitado: ${n}` + 
        `<br>Antecessor: ${antecessor}` + 
        `<br>Sucessor: ${sucessor}`
}
