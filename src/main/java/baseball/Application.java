package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            BaseBall baseBall = new BaseBall();
            baseBall.run();

            if (baseBall.isTerminate()) {
                break;
            }
        }
    }
}
