public class TestCode {
//    public static void main(String[] arg) {
////        //String str = "";
////
////
////        //System.out.println(str);
////        long startTime = System.currentTimeMillis();
//////        int n = 1000;
//////        for (int i = 0; i < n; i++) {
//////            str += "hello";
//////        }
////        int n = 10000;
////        StringBuilder str = new StringBuilder();
////        for (int i = 0; i < n; i++) {
////            str.append("hello");
////        }
////        String s = str.toString();
////        long endTime = System.currentTimeMillis();
////        System.out.println(str);
////        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
////    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TestCode t = new TestCode();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        long startTime = System.currentTimeMillis();
        int c = t.search(nums, 4);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println(c);

    }

}
