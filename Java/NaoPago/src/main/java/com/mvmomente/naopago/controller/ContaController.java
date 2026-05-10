package com.mvmomente.naopago.controller;

import com.mvmomente.naopago.dto.LoginDto;
import com.mvmomente.naopago.dto.RegisterDto;
import com.mvmomente.naopago.service.ContaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @GetMapping
    public String mostrarContas() {
        return service.mostrarContas();
    }

    @PostMapping("/register")
    public String criarConta(@RequestBody RegisterDto dto) {
        return service.criarConta(dto);
    }

    @PostMapping("/login")
    public String logarConta(@RequestBody LoginDto dto) {
        return service.acessarConta(dto);
    }

    @PostMapping("/deposito")
    public String depositarConta(@RequestParam double valor){
        return service.depositar(valor);
    }

    @PostMapping("/saque")
    public String sacarConta(@RequestParam double valor){
        return service.sacar(valor);
    }

    @PostMapping("/transferir")
    public String transfererirConta(@RequestParam double valor, String id){
        return service.transferir(valor, id);
    }
}
