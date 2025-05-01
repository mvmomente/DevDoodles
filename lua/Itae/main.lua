contas = {}
proximoId = 1

--Cria uma variavel local do banco.txt
local arquivo = io.open("banco.txt", "r")

if arquivo then

    --Ler dados de banco.txt
    for linha in arquivo:lines() do
        local id, nome, saldo = string.match(linha, "(%d+);([^;]+);([%d%.]+)")
        id = tonumber(id)
        saldo = tonumber(saldo)
        table.insert(contas, {
            id = id,
            nome = string.upper(nome),
            saldo = saldo
        })
        proximoId = proximoId + 1
    end
    arquivo:close()
else
    print("O arquivo banco.txt não existe.")
end

--Função para cadastrar contas
function cadastrarConta()
    io.write("Digite seu nome: ")
    local nome = io.read()
    table.insert(contas, {
        id = proximoId,
        nome = string.upper(nome),
        saldo = 0
    })
    proximoId = proximoId + 1
end

--Função para listar contas criadas
function listarContas()
    for _, conta in ipairs(contas) do
        print("|ID: "..conta.id.." |Nome: "..conta.nome.." |Saldo: R$"..conta.saldo)
    end
end

--Função de saque
function saque(idConta, valor)
    for _, conta in ipairs(contas) do
        
        --Valida se existe o id da conta
        if conta.id == idConta then
            
            --Segunda validação, para saber se saldo é maior que o valor de saque
            if conta.saldo >= valor then
                conta.saldo = conta.saldo - valor
                print("Saque de valor R$"..valor.." realizado com sucesso")
                print("Novo saldo: R$"..conta.saldo)
            else 
                print("Saldo insuficiente.")
            end
            return
        end
    end
    print("Conta não encontrada.")
end

--Função deposito
function deposito(idConta, valor)
    for _, conta in ipairs(contas) do
        
        --Valida se existe o id da conta
        if conta.id == idConta then
            conta.saldo = conta.saldo + valor
            print("Deposito no valor de R$"..valor.." realizado com sucesso.")
            print("Novo saldo: R$"..conta.saldo)
            return
        end
    end
    print("Conta não encontrada.")
end

--Utiliza as funções.
cadastrarConta()
cadastrarConta()
deposito(1, 100)
deposito(2, 150)
saque(1, 291)
saque(1, 30)
saque(2, 91)
listarContas()

--Abrindo banco.txt para gravação
local arquivo = io.open("banco.txt", "w")

--Verificação se o arquivo banco.txt foi aberto
if not arquivo then
    print("Erro ao abrir banco.txt para gravar dados.")
    return
end

--Loop para gravar dados em banco.txt
for _, conta in ipairs(contas) do
    local linha = conta.id .. ";" .. string.upper(conta.nome) .. ";" .. string.format("%.2f", conta.saldo) .. "\n"
    arquivo:write(linha)    
end

--Fecha o arquivo banco.txt
arquivo:close()

print("Dados exportados para o Banco.txt.")