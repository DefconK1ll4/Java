public class Main {
    public static void main(String[] args) {
        /*
        BankAccount account1 = new BankAccount();

        account1.setAccountNumber("2422545647");
        account1.setCustomerName("Pookey");
        account1.setEmailAddress("Pookey@CodeChef");
        account1.setPhoneNumber("911");
        account1.setBalance(300000000.345);

        String getAccount = account1.getAccountNumber();
        String getCustomerName = account1.getCustomerName();
        String getEmail = account1.getEmailAddress();
        String getNumber = account1.getPhoneNumber();
        Double getBalance = account1.getBalance();

        System.out.println(getCustomerName);
        System.out.println(getAccount);
        System.out.println(getEmail);
        System.out.println(getNumber);
        System.out.println(getBalance);

        account1.whitdraw(1000);
        account1.deposit(999999);
        account1.whitdraw(-1);
        account1.whitdraw(999999999);

        BankAccount Pookey = new BankAccount("763524136361",3623151,"PookeyWhoElse", "Sickan@Penetration.you","555-231 222");
        System.out.println(Pookey.getAccountNumber());
        System.out.println(Pookey.getBalance());
        System.out.println(Pookey.getCustomerName());
        System.out.println(Pookey.getEmailAddress());
        System.out.println(Pookey.getPhoneNumber());
        */
        VipClass PookeyVIP = new VipClass();
        System.out.println(PookeyVIP.getName());
        System.out.println(PookeyVIP.getCreditLimit());
        System.out.println(PookeyVIP.getEmailAddress());
        VipClass PookeyAll = new VipClass("PookeyOkay", 300.0);
        System.out.println(PookeyAll.getName());
        System.out.println(PookeyAll.getCreditLimit());
        System.out.println(PookeyAll.getEmailAddress());
        VipClass vip = new VipClass("Hooker", 100032.0, "vip@vip.com");
        System.out.println(vip.getName());
        System.out.println(vip.getCreditLimit());
        System.out.println(vip.getEmailAddress());

    }

}
