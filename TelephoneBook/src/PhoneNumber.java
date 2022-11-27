public class PhoneNumber {
    private String mobileNumber;
    private String homeNumber;
    private String workNumber;

    public PhoneNumber(String mobileNumber, String homeNumber, String workNumber) {
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.workNumber = workNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    @Override
    public String toString() {
        return " Mobile: " + getMobileNumber() +
                " Home: " + getHomeNumber() +
                " Work: " + getWorkNumber();
    }
}
