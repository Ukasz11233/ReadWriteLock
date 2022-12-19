package random;
import java.security.SecureRandom;
public class Random {

    private Random() {}
    private static final SecureRandom rand = new SecureRandom();
    public static int getRandomInt(int min, int max) {
        return (rand.nextInt(max - min + 1) + min);
    }
}
