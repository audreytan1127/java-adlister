public class Quote {

    private long id;
    private String content;
    private Author author;

    public Quote(){
    }

    public Quote(String content) {
        this.content = content;
    }

    public Quote(String content, Author author) {
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
