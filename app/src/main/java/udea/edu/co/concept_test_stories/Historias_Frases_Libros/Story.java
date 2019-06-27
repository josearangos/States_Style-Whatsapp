package udea.edu.co.concept_test_stories.Historias_Frases_Libros;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Story implements Serializable {

    @SerializedName("Author")
    @Expose
    private String author;
    @SerializedName("Phrase")
    @Expose
    private String phrase;
    @SerializedName("Background_Color")
    @Expose
    private String backgroundColor;
    @SerializedName("Text_Color")
    @Expose
    private String textColor;
    @SerializedName("Duration")
    @Expose
    private int duration;
    @SerializedName("Size_Font_Author")
    @Expose
    private String sizeFontAuthor;
    @SerializedName("Size_Font_Phrase")
    @Expose
    private String sizeFontPhrase;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSizeFontAuthor() {
        return sizeFontAuthor;
    }

    public void setSizeFontAuthor(String sizeFontAuthor) {
        this.sizeFontAuthor = sizeFontAuthor;
    }

    public String getSizeFontPhrase() {
        return sizeFontPhrase;
    }

    public void setSizeFontPhrase(String sizeFontPhrase) {
        this.sizeFontPhrase = sizeFontPhrase;
    }


    public Story(String author, String phrase, String backgroundColor, String textColor, int duration, String sizeFontAuthor, String sizeFontPhrase) {
        this.author = author;
        this.phrase = phrase;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.duration = duration;
        this.sizeFontAuthor = sizeFontAuthor;
        this.sizeFontPhrase = sizeFontPhrase;
    }

   /* @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(duration);
        parcel.writeString(author);
        parcel.writeString(phrase);
        parcel.writeString(backgroundColor);
        parcel.writeString(textColor);
        parcel.writeString(sizeFontAuthor);
        parcel.writeString(sizeFontPhrase);

    }*/
}
