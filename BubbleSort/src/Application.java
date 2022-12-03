public class Application {

    public static void main(String[] args) {

        int[] bubbleArr = {4,6,10,3,5,11,1};

        for(int i = 0; i < bubbleArr.length-1; i++) {
            int temp = 0;
            int nextIndex = bubbleArr[i+1];
            if(bubbleArr[i] > nextIndex) {
                temp = bubbleArr[i];
                bubbleArr[i]=nextIndex;
                nextIndex=temp;
            }
                    
            }
        System.out.println("Unsorted arr");
        for(int i = 0; i < bubbleArr.length; i++)
            System.out.print(bubbleArr[i] + " ");
    }
}
