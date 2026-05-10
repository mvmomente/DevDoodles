package com.mvmomente.naopago.repository;

import com.mvmomente.naopago.entity.Conta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContaRepository {
    public List<Conta> contas = new ArrayList();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarContaId(String id) {
        for(Conta conta : contas) {
            if(conta.getId().equals(id)) {
                return conta;
            }
        }
        return null;
    }

    public List<Conta> mostrarContas() {
        return contas;
    }
}
