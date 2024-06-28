package com.synapsecode.redistutorial.repository;

import com.synapsecode.redistutorial.model.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<Token, String> {
}
