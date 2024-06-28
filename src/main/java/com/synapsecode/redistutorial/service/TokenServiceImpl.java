package com.synapsecode.redistutorial.service;

import com.synapsecode.redistutorial.config.RedisConfig;
import com.synapsecode.redistutorial.model.Token;
import com.synapsecode.redistutorial.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenRepository tokenRepository;
    private final RedisConfig redisConfig;

    @Override
    public Token save (Token token){
        return tokenRepository.save(token.setExpiration(redisConfig.getTtl()));
    }

    @Override
    public void deleteById(UUID tokenId){
        tokenRepository.deleteById(tokenId.toString());
    }

    @Override
    public List<Token> findAll(){
        return (List<Token>) tokenRepository.findAll();
    }

    @Override
    public Token findById(UUID tokenId){
        return tokenRepository.findById(tokenId.toString()).orElseThrow();
    }

}
