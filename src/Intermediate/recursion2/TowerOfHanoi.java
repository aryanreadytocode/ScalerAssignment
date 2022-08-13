package Intermediate.recursion2;

public class TowerOfHanoi {

    public static void main(String[] args) throws IllegalAccessException {
        String source = "Tower A";
        String auxi = "Tower B";
        String dest = "Tower C";
        int diskSize = 3;
        toh(diskSize, source, auxi, dest);
    }

    public static void toh(int diskSize, String source, String auxiliary, String destination) throws IllegalAccessException {

        if(diskSize<0)
            throw new IllegalAccessException("disk size: "+diskSize +"is not legal argument");
        if (diskSize == 0)
            return;

        toh(diskSize-1, source, destination, auxiliary);
        System.out.println("Move Disk "+diskSize+" form "+source+" to "+destination);
        toh(diskSize-1, auxiliary, source, destination);


    }
}
