package kata6.model;


public class Mail {
    private final int Id;
    private final String mail;

    public Mail(int Id, String mail) {
        this.mail = mail;
        this.Id = Id;
    }

    public String getMail() {
        return mail;
    }
    
    public int getId(){
        return Id;
    }
    
    /*public String getDomain(){
        return mail.split("@")[1];
    }*/
}