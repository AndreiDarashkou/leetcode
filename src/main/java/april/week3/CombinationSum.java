package april.week3;

public class CombinationSum {

    public int combinationSum4(int[] nums, int target) {
        int count = 0;

        for (int first : nums) {
            System.out.println("first: " + first);
            for (int dup = 1; dup < target; dup++) { //usage of the same value in sum
                System.out.println("dup: " + dup);

                for (int i : nums) {
                    if (i == 1 && first == 1) {
                        System.out.println("i:" + i + "  count:1");
                        count++;
                        break;
                    }
                    if (i > target) {
                        break;
                    }
                    System.out.println("i:" + i + "  count:" + (target - i * dup));
                    if (target - i * dup < 1) {
                        break;
                    }
                    count += (target - i * dup);
                }
            }
        }

        return count;
    }

}
