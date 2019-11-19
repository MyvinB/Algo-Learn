import java.util.*;

public class ArrayOverlap {



    public static class Interval implements Comparator<Interval> {
      int start;
      int end;
        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
        Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
        @Override
        public int compare(Interval o1, Interval o2) {
           return o1.start-o2.start;
        }
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals=new ArrayList<Interval>();
        String pe="[ (47, 76), (51, 99), (28, 78), (54, 94), (12, 72), (31, 72), (12, 55), (24, 40), (59, 79), (41, 100), (46, 99), (5, 27), (13, 23), (9, 69), (39, 75), (51, 53), (81, 98), (14, 14), (27, 89), (73, 78), (28, 35), (19, 30), (39, 87), (60, 94), (71, 90), (9, 44), (56, 79), (58, 70), (25, 76), (18, 46), (14, 96), (43, 95), (70, 77), (13, 59), (52, 91), (47, 56), (63, 67), (28, 39), (51, 92), (30, 66), (4, 4), (29, 92), (58, 90), (6, 20), (31, 93), (52, 75), (41, 41), (64, 89), (64, 66), (24, 90), (25, 46), (39, 49), (15, 99), (50, 99), (9, 34), (58, 96), (85, 86), (13, 68), (45, 57), (55, 56), (60, 74), (89, 98), (23, 79), (16, 59), (56, 57), (54, 85), (16, 29), (72, 86), (10, 45), (6, 25), (19, 55), (21, 21), (17, 83), (49, 86), (67, 84), (8, 48), (63, 85), (5, 31), (43, 48), (57, 62), (22, 68), (48, 92), (36, 77), (27, 63), (39, 83), (38, 54), (31, 69), (36, 65), (52, 68) ]";
        String jack="myvin&cool";

        String ar[]=pe.split("\\), \\(");

        for (int i = 1; i <ar.length-1 ; i++) {
            String []are=ar[i].split(", ");
            intervals.add(new Interval(Integer.valueOf(are[0]),Integer.valueOf(are[1])));
        }
//        for(int i=0;i<intervals.size();i++){
//            System.out.println(intervals.get(i).toString());
//        }
        intervals.add(new Interval(47,46));
        intervals.add(new Interval(52,68));


        //intervals.add(new Interval(5,31));
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start){
                    return o1.end-o2.end;
                }
                return o1.start-o2.start;
            }
        });
        Stack<Interval> s=new Stack<Interval>();



        s.push(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval top=s.peek();
            if(top.end<intervals.get(i).start){
                s.push(intervals.get(i));
            }
            else if(top.end<intervals.get(i).end){
                top.end=intervals.get(i).end;
                s.pop();
                s.push(top);
            }
        }





        intervals.clear();
        for(Interval a:s){
            intervals.add(a);
        }

        System.out.println("sldnskndlsndlns");
        for(Interval a:intervals){
            System.out.println(a.toString());
        }


        }

    }
