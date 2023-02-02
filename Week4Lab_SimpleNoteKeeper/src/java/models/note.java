
package models;

import java.io.Serializable;

/**
 *
 * @author ravne
 */
public class note implements Serializable{
    private String title;
    private String contents;

    public note(){
        this.title="";
        this.contents="";
    }
    public note(String title,String contents){
        this.title=title;
        this.contents=contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    


}
