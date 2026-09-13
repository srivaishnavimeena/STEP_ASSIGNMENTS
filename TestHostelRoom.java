class HostelRoom {
    String roomNo;
    int occupied;
}

public class HostelRoom {
    public static void Main(String[] args) {
        HostelRoom roomA = new HostelRoom();
        HostelRoom roomB = new HostelRoom();

        roomA.roomNo = "C-101";
        roomB.roomNo = "C-102";

        roomA.occupied++;
        roomA.occupied++;
        roomA.occupied++;

        System.out.println(roomA.roomNo + " occupied: " + roomA.occupied);
        System.out.println(roomB.roomNo + " occupied: " + roomB.occupied);
    }
}