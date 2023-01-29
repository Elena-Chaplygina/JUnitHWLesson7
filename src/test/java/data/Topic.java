package data;
public enum Topic {

    INVEST("Инвестиции"),
    BUSINESS("Бизнес"),
    SO_WHAT("Разборы законов");


    private final String topic;

    Topic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return  topic;
    }
}
