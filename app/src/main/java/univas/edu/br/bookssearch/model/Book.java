package univas.edu.br.bookssearch.model;

import java.util.ArrayList;

/**
 * Created by nicolas on 02/12/15.
 */
public class Book {

    private String title;
    private Integer pageCount;
    private String publisher;
    private String infoLink;

    public Book(){ }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }
}
