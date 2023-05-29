package teste.aular.response;

public class CommentResponse {
    private String author;
    private String comment;

    public CommentResponse(String author, String comment) {
        this.author = author;
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
