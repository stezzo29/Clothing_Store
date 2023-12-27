import java.util.ArrayList;

public class ClothingStore {
    private String storeName;

    private ArrayList<Clothing> availableClothing = new ArrayList();
    private ArrayList<Top> availableTops = new ArrayList();
    private ArrayList<Dress> availableDresses = new ArrayList();
    private ArrayList<Pant> availablePants = new ArrayList();
    private ArrayList<Member> memberList = new ArrayList();
    private static int nextMemberID = 10101;

    public ClothingStore(String storeName) {
        this.storeName = storeName;
        Top top1 = new Top("Short Sleeve", "Pink", "Blouse", 4, 14.99, 16);
        Top top2 = new Top("Sleeveless", "Brown", "Tank", 0, 12.99, 22);
        Top top3 = new Top("Long Sleeve", "White", "Bodysuit", 2, 20.99, 23);

        Dress dress1 = new Dress("Midi", "Casual", "Yellow", 6, 21.99, 12);
        Dress dress2 = new Dress("Mini", "Going Out", "Black", 6, 22.99, 16);
        Dress dress3 = new Dress("Maxi", "Casual", "Pink", 8, 15.99, 18);

        Pant pant1 = new Pant(31, "Black", "Mom Jeans", 27, 34.98, 19);
        Pant pant2 = new Pant(32, "Medium Wash", "Skinny Jeans", 25, 29.98, 22);
        Pant pant3 = new Pant(28, "White", "Linen Pants", 26, 19.98, 14);

        availableTops.add(top1);
        availableTops.add(top2);
        availableTops.add(top3);
        availableDresses.add(dress1);
        availableDresses.add(dress2);
        availableDresses.add(dress3);
        availablePants.add(pant1);
        availablePants.add(pant2);
        availablePants.add(pant3);

        Member member1 = new Member("Sarah Johnson", "sjohnson@gmail.com", "555-101-0155", getNextMemberID());
        memberList.add(member1);

        Member member2 = new Member("Amanda O'Conner", "amandaoc@gmail.com", "441-215-0005", getNextMemberID());
        memberList.add(member2);
    }

    public static int getNextMemberID() {
        nextMemberID++;
        return nextMemberID - 1;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public ArrayList<Clothing> getAvailableClothing() {
        return availableClothing;
    }

    public void setAvailableClothing(ArrayList<Clothing> availableClothing) {
        this.availableClothing = availableClothing;
    }

    public ArrayList<Top> getAvailableTops() {
        return availableTops;
    }

    public void setAvailableTops(ArrayList<Top> availableTops) {
        this.availableTops = availableTops;
    }

    public ArrayList<Dress> getAvailableDresses() {
        return availableDresses;
    }

    public void setAvailableDresses(ArrayList<Dress> availableDresses) {
        this.availableDresses = availableDresses;
    }

    public ArrayList<Pant> getAvailablePants() {
        return availablePants;
    }

    public void setAvailablePants(ArrayList<Pant> availablePants) {
        this.availablePants = availablePants;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public void removeClothing(String type, int index) {
        if (type.equals("dresses"))
            availableDresses.remove(index);
        else if (type.equals("tops"))
            availableTops.remove(index);
        else if (type.equals("pants"))
            availablePants.remove(index);

    }

    public void addNewMember(String name, String email, String phone) {
        memberList.add(new Member(name, email, phone, getNextMemberID()));
    }

}
