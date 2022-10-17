package fr.esgi.al.tps.classe2.tp7;

public class Main {

    public static void main(String[] args) {
        final QueryBuilder queryBuilder = QueryBuilder.create();

        var query1 = queryBuilder
                .select("SELECT ID, NAME")
                .from("T_USERS")
                .where("ID=4")
                .build();

        var query2 = queryBuilder
                .select("SELECT ID, NAME")
                .from("T_USERS")
                .build();

        System.out.println(query1);
        System.out.println(query2);
    }
}
