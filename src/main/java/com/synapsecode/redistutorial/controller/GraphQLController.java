package com.synapsecode.redistutorial.controller;

import com.synapsecode.redistutorial.model.Token;
import com.synapsecode.redistutorial.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/tokens")
@RequiredArgsConstructor
public class GraphQLController {
    private final TokenService tokenService;

    @QueryMapping
    public List<Token> getAllToken(){
        return tokenService.findAll();
    }

    @MutationMapping
    public Token createToken (@Argument Token token){
        return tokenService.save(token);
    }

    @QueryMapping
    public Token getTokenById(@Argument String tokenId) {
        return tokenService.findById(UUID.fromString(tokenId));
    }

    @MutationMapping
    public void deleteToken (@Argument String tokenId){
        tokenService.deleteById(UUID.fromString(tokenId));
    }
}
