package fr.esgi.al.tps.oop.classe1.tp9;

public class Main {
    public static void main(String[] args) {

        var queryBuilder = Query.create();

        var query1 = queryBuilder
                .select("select ID, USERNAME")
                .from("T_USER")
                .where("ID=3")
                .orderBy("ID").build();

        var query2 = queryBuilder
                .select("select ID, USERNAME")
                .from("T_CUSTOMER")
                .orderBy("ID").build();

        System.out.println(query1);
        System.out.println(query2);
    }
}
