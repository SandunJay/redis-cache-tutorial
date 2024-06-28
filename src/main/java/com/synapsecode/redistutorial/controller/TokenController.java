package com.synapsecode.redistutorial.controller;


import com.synapsecode.redistutorial.model.Token;
import com.synapsecode.redistutorial.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tokens")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @GetMapping
    public Iterable<Token> findAll(){
        return tokenService.findAll();
    }

    @GetMapping("/{tokenId}")
    public Token findById(@PathVariable UUID tokenId){
        return tokenService.findById(tokenId);
    }

    @PostMapping
    public Token createOrUpdateToken(@RequestBody Token token){
        return tokenService.save(token);
    }

    @DeleteMapping("/{tokenId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID tokenId){
        tokenService.deleteById(tokenId);
    }
}
