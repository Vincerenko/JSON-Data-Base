package server;

import java.util.Objects;

public class ReceiverGet {
    private String type;
    private String key;

    public ReceiverGet(String type, String key) {
        this.type = type;
        this.key = key;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiverGet that = (ReceiverGet) o;
        return Objects.equals(type, that.type) && Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, key);
    }

    @Override
    public String toString() {
        return "ReceiverGet{" +
                "type='" + type + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
