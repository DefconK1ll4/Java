public class Application {

        void bubblesort(int[] arr) {
            int n = arr.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    int index = arr[j];
                    int nextIndex = arr[j + 1];
                    int temp;
                    if (arr[j] > arr[j + 1]) {
                        temp = index;
                        index = nextIndex;
                        nextIndex = temp;
                    }
                }
            }
        }

    public static void main(String[] args) {
        Application ob = new Application();

        int[] bubbleArr = {4,6,10,3,5,11,1};

        ob.bubblesort(bubbleArr);
        System.out.println("Unsorted arr");
        for(int i = 0; i < bubbleArr.length; i++)
            System.out.print(bubbleArr[i] + " ");

    }

    }
