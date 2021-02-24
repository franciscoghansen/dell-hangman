package com.franciscohansen.dellhangman.controller;

import com.franciscohansen.dellhangman.model.AbstractModel;
import com.franciscohansen.dellhangman.persistence.repositories.IRepository;
import com.franciscohansen.dellhangman.persistence.services.AbstractService;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class AbstractController<T extends AbstractModel, U extends IRepository<T>, V extends AbstractService<T, U>> {

    protected abstract U repository();

    protected abstract V service();

    protected abstract T newRecord();

    @GetMapping("/new")
    public T getNewRecord() {
        return newRecord();
    }

}
