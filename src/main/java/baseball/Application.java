package baseball;

public class Application {
    public static void main(String[] args) {

        while (true) {
            BaseBall baseBall = new BaseBall();
            baseBall.run();

            if (baseBall.isTerminate()) {
                break;
            }
        }
    }
}
