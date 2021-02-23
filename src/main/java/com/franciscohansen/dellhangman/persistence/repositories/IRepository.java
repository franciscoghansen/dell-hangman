package com.franciscohansen.dellhangman.persistence.repositories;

import com.franciscohansen.dellhangman.model.AbstractModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository<T extends AbstractModel> extends JpaRepository<T, Long> {
}
