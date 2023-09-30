package fr.esgi.al.tps.oop.tp7;

import java.util.Objects;

final class QueryBuilder {

    private String select;
    private String from;
    private String where;
    private String orderBy;

    public static QueryBuilder create() {
        return new QueryBuilder();
    }

    public QueryBuilder select(String select) {
        QueryBuilder queryBuilder1 = new QueryBuilder();
        queryBuilder1.select = Objects.requireNonNull(select);
        queryBuilder1.from = from;
        queryBuilder1.where = where;
        queryBuilder1.orderBy = orderBy;
        return queryBuilder1;
    }

    public QueryBuilder from(String from) {
        QueryBuilder queryBuilder1 = new QueryBuilder();
        queryBuilder1.select = select;
        queryBuilder1.from = Objects.requireNonNull(from);
        queryBuilder1.where = where;
        queryBuilder1.orderBy = orderBy;
        return queryBuilder1;
    }

    public QueryBuilder where(String where) {
        QueryBuilder queryBuilder1 = new QueryBuilder();
        queryBuilder1.select = select;
        queryBuilder1.from = from;
        queryBuilder1.where = Objects.requireNonNull(where);
        queryBuilder1.orderBy = orderBy;
        return queryBuilder1;
    }

    public QueryBuilder orderBy(String orderBy) {
        QueryBuilder queryBuilder1 = new QueryBuilder();
        queryBuilder1.select = select;
        queryBuilder1.from = from;
        queryBuilder1.where = where;
        queryBuilder1.orderBy = Objects.requireNonNull(orderBy);
        return queryBuilder1;
    }

    public Query build() {
        return new Query(select, from, where, orderBy);
    }
}
