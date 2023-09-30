package fr.esgi.al.tps.oop.tp24.middleware;

final class SimpleMessage implements Message {

    private String id;
    private String value;

    public SimpleMessage(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
