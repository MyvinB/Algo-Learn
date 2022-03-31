package TopicWise2022.Design;

/**
 * @author mmichaelbarboza
 * on 2:33 PM 3/31/2022
 * Time Taken:
 */
public class LC1603 {

    public static void main(String[] args) {

    }
    int[] count;
    class ParkingSystem {

        int[] count;
        public ParkingSystem(int big, int medium, int small) {
            count = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            return count[carType - 1]-- > 0;
        }
    }

}
