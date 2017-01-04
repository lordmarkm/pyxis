package com.pyxis.commons.service.rql;

import java.util.List;

import com.google.common.collect.Lists;
import com.mysema.query.types.Path;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.NumberPath;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;

/**
 * @author mbmartinez
 */
public class NumberPathExpressionEvaluator extends AbstractExpressionEvaluator {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BooleanExpression evaluate(Path<?> path, ComparisonOperator operator, List<String> arguments) {
        if (arguments.size() < 1) {
            throw new IllegalArgumentException("Fewer than expected arguements for NumberPath evaluation");
        }
        NumberPath e = (NumberPath) path;
        List<Object> argsOfExpectedType;
        if ("null".equals(arguments.get(0))) {
            argsOfExpectedType = Lists.newArrayList();
        } else {
            argsOfExpectedType = cast(e.getType(), arguments);
        }
        switch (operator.getSymbol()) {
        case "==":
            if (argsOfExpectedType.size() == 0) {
                //arg was "null"
                return e.isNull();
            } else {
                return e.eq(argsOfExpectedType.get(0));
            }
        case "!=":
            if (argsOfExpectedType.size() == 0) {
                //arg was "null"
                return e.isNotNull();
            } else {
                return e.ne(argsOfExpectedType.get(0));
            }
        case "=gt=":
            return e.gt((Number) argsOfExpectedType.get(0));
        case "=ge=":
            return e.goe((Number) argsOfExpectedType.get(0));
        case "=lt=":
            return e.lt((Number) argsOfExpectedType.get(0));
        case "=le=":
            return e.loe((Number) argsOfExpectedType.get(0));
        case "=in=":
            return e.in(argsOfExpectedType);
        default:
            throw new IllegalArgumentException("Operator not supported: " + operator);
        }
    }

}
