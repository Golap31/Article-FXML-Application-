package cse213projects.spring2024.midterm_2110075_sec6;

import java.time.LocalDate;
import java.util.ArrayList;


public class Article {
    private String title;
    private String author;
    private String type;
    private LocalDate publicationDate;
    private String status;
    private int noofAuthors;


    public Article(String title, String type, String author, LocalDate publicationDate, String status, int noofAuthors) {
        this.title = title;
        this.type = type;
        this.author = author;
        this.publicationDate = publicationDate;
        this.status = status;
        this.noofAuthors = noofAuthors;
    }

    public int getPublicationYear(){
        return publicationDate.getYear();
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNoofAuthors() {
        return noofAuthors;
    }

    public void setNoofAuthors(int noofAuthors) {
        this.noofAuthors = noofAuthors;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", publicationDate=" + publicationDate +
                ", status='" + status + '\'' +
                ", noofAuthors=" + noofAuthors +
                '}';
    }


}
