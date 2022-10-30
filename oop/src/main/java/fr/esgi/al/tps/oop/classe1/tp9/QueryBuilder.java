package fr.esgi.al.tps.oop.classe1.tp9;

import java.util.Objects;

final class QueryBuilder {

    private String select;
    private String from;
    private String where;
    private String orderBy;

    public QueryBuilder select(String select) {
        QueryBuilder builder = new QueryBuilder();
        builder.select = Objects.requireNonNull(select);
        builder.from = from;
        builder.where = where;
        builder.orderBy = orderBy;
        return builder;
    }

    public QueryBuilder from(String from) {
        QueryBuilder builder = new QueryBuilder();
        builder.select = select;
        builder.from = Objects.requireNonNull(from);
        builder.where = where;
        builder.orderBy = orderBy;
        return builder;
    }

    public QueryBuilder where(String where) {
        QueryBuilder builder = new QueryBuilder();
        builder.select = select;
        builder.from = from;
        builder.where = Objects.requireNonNull(where);
        builder.orderBy = orderBy;
        return builder;
    }

    public QueryBuilder orderBy(String orderBy) {
        QueryBuilder builder = new QueryBuilder();
        builder.select = select;
        builder.from = from;
        builder.where = where;
        builder.orderBy = Objects.requireNonNull(orderBy);
        return builder;
    }

    public Query build() {
        return new Query(select, from, where, orderBy);
    }
}
