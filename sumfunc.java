

class sum {
    
        public int add(int... numbers){
            int sum = 0;
            for(int number:numbers){
                sum += number;
                  }
                  System.out.println(sum);
                  return sum;
            }
        }
    

public class sumfunc {
    public static void main(String[] args){
        sum sum = new sum();
        sum.add(3,4,5,6,3,4,6,7,8);
       
}
}