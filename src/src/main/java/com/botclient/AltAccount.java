package neo.deobf;

public class AltAccount {
    private String username;
    private String password;
    private String mask;
    private AltStatus status;

    public AltAccount(String username, String password) {
        this(username, password, username, AltStatus.Unchecked);
    }

    public AltAccount(String username, String password, String mask, AltStatus status) {
        this.username = username;
        this.password = password;
        this.mask     = mask;
        this.status   = status;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getMask()     { return mask; }
    public AltStatus getStatus() { return status; }
    public void setStatus(AltStatus status) { this.status = status; }
    public void setMask(String mask)        { this.mask = mask; }
}
