-- Tabela que armazenará os canais criados
canais = {}

-- Função para criar um novo canal
function criarCanal()
    io.write("Nome do canal: ")
    local nomeCanal = io.read()  -- Lê o nome do canal

    -- Verifica se o canal já existe
    for _, canal in ipairs(canais) do
        if canal.nome == nomeCanal then
            print("Canal ja existente!")  -- Se já existir, informa o usuário
            return
        end
    end

    -- Cria um novo canal com o nome fornecido e uma lista de vídeos vazia
    local novoCanal = {
        nome = nomeCanal,
        videos = {}
    }

    -- Adiciona o novo canal na tabela de canais
    table.insert(canais, novoCanal)
    print("Canal criado com sucesso.")
end

-- Função para fazer upload de um vídeo para um canal existente
function uploadVideo()
    io.write("Nome do canal para upload: ")
    local nomeCanal = io.read()  -- Lê o nome do canal

    -- Verifica se o canal existe
    for _, canal in ipairs(canais) do
        if canal.nome == nomeCanal then
            io.write("Titulo do video: ")
            local tituloVideo = io.read()  -- Lê o título do vídeo

            io.write("Descricao do video: ")
            local descricaoVideo = io.read()  -- Lê a descrição do vídeo

            -- Adiciona o novo vídeo à lista de vídeos do canal
            table.insert(canal.videos, {
                titulo = tituloVideo,
                descricao = descricaoVideo,
                views = 0,
                curtidas = 0
            })

            print("Video enviado com sucesso.")
            return
        end
    end

    print("Canal nao encontrado.")  -- Se o canal não for encontrado, exibe a mensagem
end

-- Função para listar todos os canais e o total de views de seus vídeos
function listarCanais()
    for _, canal in ipairs(canais) do
        local totalViews = 0
        -- Calcula o total de views de todos os vídeos do canal
        for _, video in ipairs(canal.videos) do 
            totalViews = totalViews + video.views
        end
        print("Canal: " .. canal.nome .. " | Views: " .. totalViews)  -- Exibe o canal e o total de views
    end
end

-- Função para listar os vídeos de um canal específico
function listarCanal()
    io.write("Nome do canal que deseja listar: ")
    local nomeProcurando = io.read()  -- Lê o nome do canal que o usuário quer listar

    -- Verifica se o canal existe
    for _, canal in ipairs(canais) do
        if canal.nome == nomeProcurando then
            print("Canal: " .. canal.nome)
            if #canal.videos == 0 then
                print("Nenhum video enviado.")  -- Se o canal não tiver vídeos
            else
                print("Videos:")
                -- Exibe os vídeos do canal
                for _, video in ipairs(canal.videos) do
                    print(" - " .. video.titulo .. " | Views: " .. video.views .. " | Curtidas: " .. video.curtidas)
                end
            end
            return
        end
    end
    print("Canal nao encontrado.")  -- Se o canal não for encontrado, exibe a mensagem
end

-- Função para visualizar um vídeo de um canal
function visualizarVideo()
    io.write("Nome do canal: ")
    local nomeCanal = io.read()  -- Lê o nome do canal

    -- Verifica se o canal existe
    for _, canal in ipairs(canais) do
        if canal.nome == nomeCanal then
            -- Verifica se o canal tem vídeos
            if #canal.videos == 0 then
                print("Este canal ainda nao tem videos.")
                return
            end

            print("Videos disponiveis:")
            -- Exibe a lista de vídeos disponíveis
            for i, video in ipairs(canal.videos) do
                print(i .. ". " .. video.titulo .. " | Views: " .. video.views)
            end

            io.write("Digite o titulo exato do video que deseja assistir: ")
            local tituloEscolhido = io.read()  -- Lê o título do vídeo que o usuário deseja assistir

            -- Verifica se o vídeo existe e atualiza o número de views
            for _, video in ipairs(canal.videos) do
                if video.titulo == tituloEscolhido then
                    video.views = video.views + 1
                    print("Voce assistiu: " .. video.titulo .. " | Total de views: " .. video.views)
                    return
                end
            end

            print("Video nao encontrado.")  -- Se o vídeo não for encontrado, exibe a mensagem
            return
        end
    end

    print("Canal nao encontrado.")  -- Se o canal não for encontrado, exibe a mensagem
end

-- Função para curtir um vídeo de um canal
function curtirVideo()
    io.write("Nome do canal: ")
    local nomeCanal = io.read()  -- Lê o nome do canal

    -- Verifica se o canal existe
    for _, canal in ipairs(canais) do
        if canal.nome == nomeCanal then
            -- Verifica se o canal tem vídeos
            if #canal.videos == 0 then
                print("Este canal ainda nao tem videos.")
                return
            end

            print("Videos disponiveis:")
            -- Exibe a lista de vídeos disponíveis
            for i, video in ipairs(canal.videos) do
                print(i .. ". " .. video.titulo .. " | Curtidas: " .. video.curtidas)
            end

            io.write("Digite o titulo exato do video que deseja curtir: ")
            local tituloEscolhido = io.read()  -- Lê o título do vídeo que o usuário deseja curtir

            -- Verifica se o vídeo existe e atualiza o número de curtidas
            for _, video in ipairs(canal.videos) do
                if video.titulo == tituloEscolhido then
                    video.curtidas = video.curtidas + 1
                    print("Voce curtiu: " .. video.titulo .. " | Total de curtidas: " .. video.curtidas)
                    return
                end
            end

            print("Video nao encontrado.")  -- Se o vídeo não for encontrado, exibe a mensagem
            return
        end
    end

    print("Canal nao encontrado.")  -- Se o canal não for encontrado, exibe a mensagem
end

-- Função para mostrar o menu de opções
function mostrarMenu()
    print("\nEscolha uma opcao:")
    print("1 - Criar canal")
    print("2 - Fazer upload de video")
    print("3 - Listar canais")
    print("4 - Listar um canal")
    print("5 - Visualizar video")
    print("6 - Curtir video")
    print("0 - Sair")
end

-- Tabela simulando o switch/case para as ações do menu
local menuAcao = {
    [1] = criarCanal,
    [2] = uploadVideo,
    [3] = listarCanais,
    [4] = listarCanal,
    [5] = visualizarVideo,
    [6] = curtirVideo,
    [0] = function () print("Saindo...") os.exit() end -- Função para sair do programa
}

-- Loop principal do menu
while true do
    mostrarMenu()  -- Exibe o menu
    io.write("Escolha uma opcao: ")
    local opcao = tonumber(io.read())  -- Lê a opção escolhida

    local acao = menuAcao[opcao]  -- Obtém a função correspondente à opção

    if acao then
        acao()  -- Chama a função correspondente
    else
        print("Opcao invalida, tente novamente.")  -- Se a opção for inválida, exibe a mensagem
    end
end