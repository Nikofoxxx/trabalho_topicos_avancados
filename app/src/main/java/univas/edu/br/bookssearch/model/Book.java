package univas.edu.br.bookssearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by nicolas on 02/12/15.
 */
public class Book implements Parcelable{

    private String title;
    private String pageCount;
    private String publisher;
    private String infoLink;


    public Book (Parcel in)
    {
        title = in.readString();
        pageCount = in.readString();
        publisher= in.readString();
        infoLink = in.readString();
    }

    public Book(){ }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
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

    public static final Parcelable.Creator<Book> CREATOR
            = new Parcelable.Creator<Book>()
    {
        public Book createFromParcel(Parcel in)
        {
            return new Book(in);
        }

        public Book[] newArray (int size)
        {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString (title);
        dest.writeString(pageCount);
        dest.writeString (publisher);
        dest.writeString (infoLink);
    }
}
