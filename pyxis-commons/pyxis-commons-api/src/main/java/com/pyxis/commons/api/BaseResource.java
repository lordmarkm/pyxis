package com.pyxis.commons.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pyxis.commons.model.BaseEntity;
import com.pyxis.commons.service.PyxisJpaServiceCustom;
import com.pyxis.core.dto.BaseInfo;
import com.pyxis.core.dto.PageInfo;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

public class BaseResource<D extends BaseInfo, S extends PyxisJpaServiceCustom<? extends BaseEntity, D>> {

    @Autowired
    protected S service;

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<D>> rqlSearch(@RequestParam(required = false) String term, Pageable page) {
        return new ResponseEntity<>(service.rqlSearch(term, service.getFieldMapping(), page), OK);
    }

    //TODO doesn't work
    //http://stackoverflow.com/questions/27170298/spring-reponsebody-requestbody-with-abstract-class
//    @RequestMapping(method = POST)
//    public ResponseEntity<D> save(@RequestBody D toSave) {
//        return new ResponseEntity<>(service.saveInfo(toSave), OK);
//    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<D> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteInfo(id), OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<D> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(service.findOneInfo(id), OK);
    }

}
