public class Main {
    public static void main(String[] args){

        Event C1 = new Event("C1",100,8,10);
        Event C2 = new Event("C2",100,10,12);
        Event L1 = new Event("L1",30,8,10);
        Event L2 = new Event("L2",30,8,10);
        Event L3 = new Event("L3",30,10,12);

        Room room401 = new ComputerLabs("401",30, "Windows");
        Room room403 = new ComputerLabs("403",30, "macOS");
        Room room405 = new ComputerLabs("405",30, "Linux");
        Room room309 = new LectureHall("309",100, true);

        Problem problem = new Problem();

        problem.addEvent(C1);
        problem.addEvent(C2);
        problem.addEvent(L1);
        problem.addEvent(L2);
        problem.addEvent(L3);

        problem.addRoom(room401);
        problem.addRoom(room403);
        problem.addRoom(room405);
        problem.addRoom(room309);

        problem.printEvents();
        problem.printRooms();

        Solution result = new Solution(problem);

        result.algorithm();

    }

}
