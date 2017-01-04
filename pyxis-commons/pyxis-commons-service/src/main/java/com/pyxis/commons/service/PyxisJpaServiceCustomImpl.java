package com.pyxis.commons.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Path;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import com.pyxis.commons.model.BaseEntity;
import com.pyxis.commons.service.rql.RsqlParserVisitor;
import com.pyxis.core.dto.BaseInfo;
import com.pyxis.core.dto.PageInfo;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLOperators;

@Transactional
public abstract class PyxisJpaServiceCustomImpl<E extends BaseEntity, D extends BaseInfo, R extends PyxisJpaService<E>>
    extends MappingService<E, D> implements PyxisJpaServiceCustom<E, D> {

    private static final Logger LOG = LoggerFactory.getLogger(PyxisJpaServiceCustomImpl.class);

    @Autowired
    protected R repo;

    @Autowired
    protected TaskExecutor taskExecutor;

    public D findOneInfo(Long id) {
        return toDto(repo.findOne(id));
    }

    public D saveInfo(D dto) {
        return toDto(repo.save(toEntity(dto)));
    }

    public E saveInfoAndGetEntity(D dto) {
        return repo.save(toEntity(dto));
    }

    public List<D> saveInfo(Iterable<D> dtos) {
        return toDto(repo.save(toEntity(dtos)));
    }

    public List<E> saveInfoAndGetEntity(Iterable<D> dtos) {
        return repo.save(toEntity(dtos));
    }

    public PageInfo<D> pageInfo(Pageable page) {
        Page<E> results = repo.findAll(page);
        return toPageInfo(results);
    }

    public PageInfo<D> pageInfo(Predicate predicate, Pageable page) {
        Page<E> results = repo.findAll(predicate, page);
        return toPageInfo(results);
    }

    public PageInfo<D> toPageInfo(Page<E> page) {
        List<D> infos = toDto(page);

        PageInfo<D> pageResponse = new PageInfo<>();
        pageResponse.setData(infos);
        pageResponse.setHasNext(page.hasNext());
        pageResponse.setTotal(page.getTotalElements());
        return pageResponse;
    }

    @Override
    public D deleteInfo(Long id) {
        E entity = repo.findOne(id);
        entity.setDeleted(true);
        return toDto(entity);
    }

    @Override
    public PageInfo<D> rqlSearch(String term, ImmutableMap<String, Path<?>> fieldMapping, Pageable page) {
        Predicate predicate = composePredicate(term, fieldMapping);
        if (null == predicate) {
            return PageInfo.blank();
        }
        return pageInfo(predicate, page);
    }

    @Override
    public List<D> rqlSearch(String term, ImmutableMap<String, Path<?>> fieldMapping, OrderSpecifier<?>... sort) {
        Predicate predicate = composePredicate(term, fieldMapping);
        return toDto(repo.findAll(predicate, sort));
    }

    protected BooleanExpression composePredicate(String term, ImmutableMap<String, Path<?>> fieldMapping) {
        BooleanExpression predicate = null;

        Set<ComparisonOperator> operators = RSQLOperators.defaultOperators();
        operators.add(new ComparisonOperator("=like=", true));

        if (!StringUtils.isBlank(term)) {
            try {
                Node rootNode = new RSQLParser(operators).parse(term);
                RsqlParserVisitor visitor = new RsqlParserVisitor();
                predicate = rootNode.accept(visitor, fieldMapping);
            } catch (Exception e) {
                LOG.error("Error parsing or interpreting rql term. term={}, error={}", term, e.getMessage(), e);
                return null;
            }
        }

        return predicate;
    }

}
