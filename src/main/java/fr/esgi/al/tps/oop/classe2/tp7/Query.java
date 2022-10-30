package fr.esgi.al.tps.oop.classe2.tp7;

final class Query {

    private final String select;
    private final String from;
    private final String where;
    private final String orderBy;

    public Query(String select, String from, String where, String orderBy) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.orderBy = orderBy;
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
