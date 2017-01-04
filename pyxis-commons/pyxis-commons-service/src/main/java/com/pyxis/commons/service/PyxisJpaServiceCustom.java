package com.pyxis.commons.service;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Path;
import com.pyxis.commons.model.BaseEntity;
import com.pyxis.core.dto.BaseInfo;
import com.pyxis.core.dto.PageInfo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface PyxisJpaServiceCustom<E extends BaseEntity, D extends BaseInfo> {

    D findOneInfo(Long id);

    D deleteInfo(Long id);

    D saveInfo(D dto);

    List<D> saveInfo(Iterable<D> dtos);

    E saveInfoAndGetEntity(D dto);

    List<E> saveInfoAndGetEntity(Iterable<D> dtos);

    PageInfo<D> pageInfo(Pageable page);

    PageInfo<D> rqlSearch(String term, ImmutableMap<String, Path<?>> fieldMapping, Pageable page);

    List<D> rqlSearch(String term, ImmutableMap<String, Path<?>> fieldMapping, OrderSpecifier<?>... sort);

    ImmutableMap<String, Path<?>> getFieldMapping();

}
