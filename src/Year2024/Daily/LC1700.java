package Year2024.Daily;

public class LC1700 {

    public static void main(String[] args) {

    }

    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for(int i=0;i<students.length;i++){
            count[students[i]]++;
        }
        int remaining = sandwiches.length;
        for(int i=0;i<sandwiches.length;i++){
            if(count[sandwiches[i]]==0) break;
            count[sandwiches[i]]--;
            remaining--;
        }

        return remaining;
    }
}
