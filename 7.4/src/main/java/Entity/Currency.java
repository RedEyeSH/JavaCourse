package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 10)
    private String abbreviation;

    @Column(nullable = false)
    private String name;

    @Column(name = "exchange_rate", nullable = false)
    private double exchangeRate;

    public Currency() {}

    public Currency(String abbreviation, String name, double exchangeRate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getExchangeRate() { return exchangeRate; }
    public void setExchangeRate(double exchangeRate) { this.exchangeRate = exchangeRate; }
}
