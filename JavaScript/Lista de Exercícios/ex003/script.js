// Função responsável por aplicar a regra de negócio: 
// se os números forem iguais, soma; caso contrário, multiplica.
// Criada separadamente para facilitar reuso e manter a função principal mais limpa.
function calcular(a, b){
    return a===b ? a + b : a * b
}

function aoClicar() {
    // Armazenei os inputs e o elemento de resultado para evitar chamadas repetidas ao DOM
    const num1 = document.getElementById('txtn1')
    const num2 = document.getElementById('txtn2')
    const res = document.getElementById('res')

    // Convertendo os valores de string para número,
    // pois os campos de input sempre retornam texto, mesmo com type="number"
    const n1 = Number(num1.value)
    const n2 = Number(num2.value)

    // Validação essencial: evita que campos vazios ou não numéricos passem adiante.
    // Isso melhora a robustez do sistema e evita NaN nos cálculos.
    if (isNaN(n1) || isNaN(n2) || n1 <= 0 || n2 <= 0) {
        window.alert('[ERRO] Insira dois números válidos e diferentes de 0.')
        return // Encerra a função aqui para não continuar com valores inválidos
    }

    // Chama a função que aplica a lógica principal.
    // Separar essa parte facilita futuros testes ou alterações na regra.
    const c = calcular(n1, n2)

    // Defini o símbolo com base na regra para exibição visual do cálculo.
    // Usei ternário por ser uma escolha simples e expressiva.
    const sinal = n1 === n2 ? '+' : '×'

    // Exibi o resultado final formatado para o usuário.
    // Usei template string para tornar a concatenação mais legível.
    res.innerHTML = `${n1} ${sinal} ${n2} = ${c}`
}