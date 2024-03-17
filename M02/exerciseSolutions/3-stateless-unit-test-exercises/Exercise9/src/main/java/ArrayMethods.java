public class ArrayMethods {

    public int[] removeZero(int[] ints){
        int nonZeroCount = 0;
        for(int i = 0; i<ints.length;i++){
            if(ints[i] != 0){
                nonZeroCount++;
            }
        }
        int[] nonZeroArray = new int[nonZeroCount];
        int nonZeroIndex = 0;

        for(int i = 0; i < ints.length; i++){
            if(ints[i] != 0){
                nonZeroArray[nonZeroIndex] = ints[i];
                nonZeroIndex++;
            }
        }
        return nonZeroArray;
    }
}
