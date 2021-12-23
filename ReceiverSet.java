package server;

import java.util.Objects;

public class ReceiverSet {
    private String type;
    private String key;
    private String value;

    public ReceiverSet(String type, String key, String value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiverSet receiverSet = (ReceiverSet) o;
        return Objects.equals(type, receiverSet.type) && Objects.equals(key, receiverSet.key) && Objects.equals(value, receiverSet.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, key, value);
    }

    @Override
    public String toString() {
        return "ClassSet{" +
                "type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
