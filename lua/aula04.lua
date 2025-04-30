nome="Marcos"
curso='Curso de Lua'
outro="Programação"
aux=nil

print(nome)
print(curso)
print(outro)
print(aux)

-- para fazer a concatenação correta se utiliza operador ".." e não ","
print(nome .. curso)

print("--------------------")

--gsub() parametro para fazer substituição dentro de uma string
aux=string.gsub(curso, "Lua", outro)

print(aux)

--operador para mostrar tamanho string "#"
print("Tamanho de aux: " .. #aux)

--caracter de escape
--[[
    \a Campainha
    \b Backspace
    \f Alinhamento de Formulário
    \n Quebra de Linha
    \r Retorno de Carro
    \t Tabulação Horizontal
    \v Tabulação Vertical
    \\ Barra Invertida
    \' Apstrofo
    \" Aspas
]]

--print(curso .. "\t" .. nome .. "\a")

site = [[
<html>
    <head>
        <title>Marcos<title>
    <head>
    <body>
        <h1>Curso de Lua<h1>
    <body>
<html>
]]

--print(site)
io.write(site)

print("15" + 5)
print(20 .. 22)

print("Digite um Numero: ")
ler=io.read()
print(tonumber(ler) * 20)