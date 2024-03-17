package videogames.domain;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {
    private final List<String> messages = new ArrayList<>();
    private T payload; // payload
    private ResultType resultType = ResultType.SUCCESS;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public void addMessage(ResultType resultType, String message) {
        this.resultType = resultType;
        messages.add(message);
    }

    public void addMessage(ResultType resultType, String message, Object... args) {
        this.resultType = resultType;
        messages.add(String.format(message, args));
    }

    public List<String> getMessages() {
        return messages;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public boolean isSuccess() {
        return resultType == ResultType.SUCCESS;
    }
}
