package com.franciscohansen.dellhangman.persistence.services;

import com.franciscohansen.dellhangman.model.AbstractModel;
import com.franciscohansen.dellhangman.persistence.repositories.IRepository;

public abstract class AbstractService<T extends AbstractModel, U extends IRepository<T>> {

    abstract U repository();

}
