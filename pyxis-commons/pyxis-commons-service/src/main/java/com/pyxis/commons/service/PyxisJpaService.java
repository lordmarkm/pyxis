package com.pyxis.commons.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.pyxis.commons.model.BaseEntity;

@NoRepositoryBean
public interface PyxisJpaService<E extends BaseEntity>
    extends JpaRepository<E, Long>, QueryDslPredicateExecutor<E> {

}
