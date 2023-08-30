import java.util.List;

public class Author {
    private long id;
    private String firstName;
    private String lastName;
    private List<Quote> quotes;
    public Author(){}

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName, List<Quote> quotes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.quotes = quotes;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
    public void addQuote(Quote quote){
        this.quotes.add(quote);
    }
}
