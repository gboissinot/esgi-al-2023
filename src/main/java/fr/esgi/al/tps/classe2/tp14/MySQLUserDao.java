package fr.esgi.al.tps.classe2.tp14;

final class MySQLUserDao implements UserDao {
    @Override
    public void create(User user) {
        System.out.println("MYSQL Creation with " + user);
    }
}
