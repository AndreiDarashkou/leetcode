package medium;

public class AngleBetweenHandsOfAClock {

    public static double angle(int hour, int minutes) {
        double hourDegree = (hour + (minutes / 60.0)) * 30.0;
        double minuteDegree = minutes * 6;

        double degree = Math.abs(minuteDegree - hourDegree);
        if (degree > 180) {
            degree = 360 - degree;
        }
        return degree;
    }
}
