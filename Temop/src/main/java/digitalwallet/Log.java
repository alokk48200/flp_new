package digitalwallet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Log {
    private String id;
    private LocalDateTime createdAt;
    private User fromUser;
    private User toUser;
    private TransactionEnum event;
    private Double amount;

    public Log(User fromUser, User toUser, Double amount, TransactionEnum event) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
        this.event = event;
        this.createdAt = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", fromUser=" + fromUser +
                ", toUser=" + toUser +
                ", event=" + event +
                ", amount=" + amount +
                '}';
    }
}
