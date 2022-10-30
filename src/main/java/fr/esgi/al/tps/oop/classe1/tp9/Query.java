package fr.esgi.al.tps.oop.classe1.tp9;

final class Query {

    private final String select;
    private final String from;
    private final String where;
    private final String orderBy;

    Query(String select, String from, String where, String orderBy) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.orderBy = orderBy;
    }

    public static QueryBuilder create() {
        return new QueryBuilder();
    }

    @Override
    public String toString() {
        return "Query{" +
                "select='" + select + '\'' +
                ", from='" + from + '\'' +
                ", where='" + where + '\'' +
                ", orderBy='" + orderBy + '\'' +
                '}';
    }
}
