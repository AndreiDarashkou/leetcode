package algorithms1;

/**
 * https://leetcode.com/problems/first-bad-version/
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class VersionControl {

    private final int badVersion;

    public VersionControl(int badVersion) {
        this.badVersion = badVersion;
    }

    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public int findBadVersion(int n) {
        long min = 1;
        long max = n;

        while (max - min > 1) {
            long pivot = (min + max) / 2;
            if (isBadVersion((int) pivot)) {
                max = pivot;
            } else {
                min = pivot;
            }
        }
        return (int) ((isBadVersion((int) min)) ? min : max);
    }
}
