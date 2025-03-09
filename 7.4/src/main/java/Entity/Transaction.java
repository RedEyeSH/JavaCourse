package Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "source_currency_id", nullable = false)
    private Currency sourceCurrency;

    @ManyToOne
    @JoinColumn(name = "target_currency_id", nullable = false)
    private Currency targetCurrency;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "converted_amount", nullable = false)
    private double convertedAmount;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    public Transaction() {}

    public Transaction(Currency sourceCurrency, Currency targetCurrency, double amount, double convertedAmount) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.timestamp = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
