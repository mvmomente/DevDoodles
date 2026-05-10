package com.mvmomente.naopago.service;

import com.mvmomente.naopago.dto.LoginDto;
import com.mvmomente.naopago.dto.RegisterDto;
import com.mvmomente.naopago.entity.Conta;
import com.mvmomente.naopago.repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    private final ContaRepository repository;
    private Conta contaLogada;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public String criarConta(RegisterDto dto) {
        Conta conta = new Conta();
        conta.setNome(dto.nome());
        conta.setSenha(dto.senha());
        repository.adicionarConta(conta);
        return "Conta criado com sucesso! Bem-vindo " + conta.getNome();
    }

    public String acessarConta(LoginDto dto) {
        Conta conta = repository.buscarContaId(dto.id());
        if(conta == null) {
            return "Conta não encontrada!";
        }
        if(conta.getSenha().equals(dto.senha())) {
            contaLogada = conta;
            return "Logado com sucesso! Bem-vindo " + conta.getNome();
        } else {
            return "Senha ou usario incorretos";
        }
    }

    public String mostrarContas() {
        StringBuilder sb = new StringBuilder();
        for(Conta conta : repository.mostrarContas()) {
            sb.append("ID: ").append(conta.getId()).append(", Nome: ").append(conta.getNome()).append(", Senha: ").append(conta.getSenha()).append(", Saldo: ").append(conta.getSaldo()).append("\n");
        }

        return sb.toString();
    }

    public String depositar(double valor) {
        Conta conta = contaLogada;
        if(conta == null) {
            return "Você precisa estar logado!";
        }
        if (valor < 0) {
            return "Valor inválido!";
        }

        conta.setSaldo(conta.getSaldo() + valor);
        return "Depósito realizado com sucesso! Seu saldo, é: R$ " + conta.getSaldo();
    }

    public String sacar(double valor) {
        Conta conta = contaLogada;

        if(valor > conta.getSaldo()) {
            return "Saldo insuficiente!";
        }

        conta.setSaldo(conta.getSaldo() - valor);
        return "Saque realizado com sucesso! Seu saldo, é: R$ " + conta.getSaldo();
    }

    public String transferir(double valor, String idDestino) {
        Conta conta = contaLogada;
        Conta contaDestino = repository.buscarContaId(idDestino);

        if(conta == null){
            return "Você precisa estar logado!";
        }
        if(contaDestino == null) {
            return "Conta não encontrada!";
        }
        if(conta.getId().equals(contaDestino.getId())) {
            return "Você não pode realizar transferencia para sua conta!";
        }
        if (valor < 1) {
            return "Valor minímo de R$ 1!";
        }
        if(valor > conta.getSaldo()) {
            return "Saldo insuficiente!";
        }

        conta.setSaldo(conta.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        return "Transferencia de R$ " + valor + " para " + contaDestino.getNome() + " realizada com sucesso";
    }
}
