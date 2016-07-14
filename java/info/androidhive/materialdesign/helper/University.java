package info.androidhive.materialdesign.helper;

/**
 * Created by YIYA SERVER on 5/14/2016.
 */
public class University {
    private String idUniversity, name, contact,address, details, image;

    public University(String idUniversity, String name, String contact,String address, String details, String image) {
        this.idUniversity = idUniversity;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.details = details;
        this.image = image;
    }

    public String getidUniversity() {
        return idUniversity;
    }
    public void setidUniversity(String idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public String getcontact() {
        return contact;
    }
    public void setcontact(String contact) {
        this.contact = contact;
    }

    public String getaddress() {
        return address;
    }
    public void setaddress(String address) {
        this.address = address;
    }

    public String getdetails() {
        return details;
    }
    public void setdetails(String details) {
        this.details = details;
    }


    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
