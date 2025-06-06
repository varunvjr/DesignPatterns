public class Guest {
    private final String guestId;
    private final String name;
    private final String email;
    private final String phoneNumber;
    public Guest(String guestId,String name,String email,String phoneNumber){
        this.guestId = guestId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getGuestId(){
        return guestId;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
