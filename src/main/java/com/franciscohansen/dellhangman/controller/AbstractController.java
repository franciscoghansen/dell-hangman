package com.franciscohansen.dellhangman.controller;

import com.franciscohansen.dellhangman.model.AbstractModel;
import com.franciscohansen.dellhangman.persistence.repositories.IRepository;
import com.franciscohansen.dellhangman.persistence.services.AbstractService;

public abstract class AbstractController<T extends AbstractModel, U extends IRepository<T>, V extends AbstractService<T, U>> {

    abstract U repository();

    abstract V service();

}
