/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acme.spring.jsr330.service.impl;

import com.acme.spring.jsr330.domain.Stock;
import com.acme.spring.jsr330.repository.StockRepository;
import com.acme.spring.jsr330.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

/**
 * <p>A default implementation of {@link com.acme.spring.jsr330.service.StockService}, it simply delegates all
 * operations to underlying {@link com.acme.spring.jsr330.repository.StockRepository}.</p>
 *
 * @author <a href="mailto:jmnarloch@gmail.com">Jakub Narloch</a>
 */
@Service
public class DefaultStockService implements StockService {

    /**
     * <p>Represents the instance of {@link com.acme.spring.jsr330.repository.StockRepository} </p>
     */
    @Inject
    private StockRepository stockRepository;

    /**
     * <p>Creates new instance of {@link DefaultStockService} instance.</p>
     */
    public DefaultStockService() {
        // empty constructor
    }

    /**
     * <p>Initializes this service.</p>
     *
     * @throws IllegalStateException if not all dependencies has been provided
     */
    @PostConstruct
    protected void init() {

        if (stockRepository == null) {

            throw new IllegalStateException("The stock repository hasn't been provided.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long save(Stock stock) {

        return stockRepository.save(stock);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Stock stock) {

        stockRepository.update(stock);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stock get(long id) {

        return stockRepository.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stock getBySymbol(String symbol) {

        return stockRepository.getBySymbol(symbol);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Stock> getAll() {

        return stockRepository.getAll();
    }
}
