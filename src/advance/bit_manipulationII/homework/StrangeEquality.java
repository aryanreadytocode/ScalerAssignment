package advance.bit_manipulationII.homework;

public class StrangeEquality {

    public static void main(String[] args) {
        System.out.println(solve(5));
    }

    public static int solve(int A) {
        int smallest = 0;
        int largest = A+1;

        int count = 0;

        while(smallest<A){
            if(((A>>count) & 1) == 0)
            smallest += 1<<count;

            if(smallest>=A){
                smallest -= 1<<count;
                break;
            }

            count++;

        }
        count = 31;
        while(largest>A){
            if(((1<<count) & A) > 0){
                largest = 1<<(count+1);
                break;
            }
            count--;
        }

        return smallest^largest;
    }
}
