package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class BaseBall {
    private final int LENGTH = 3;

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
        computer.createComputerNumber(LENGTH);

        while (true) {
            int strike = 0;
            int ball = 0;
            String number = inputNumber();

            for (int i = 0; i < LENGTH; i++) {
                int cur = number.charAt(i) - '0';
                if (computer.get(i) == cur) {
                    strike++;
                } else if (computer.contains(cur)) {
                    ball++;
                }
            }

            if (strike == LENGTH) {
                System.out.println(strike + "스트라이크");
                System.out.println(LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }

            if (strike == 0) {
                if (ball == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(ball + "볼");
                }
            } else {
                if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }
        }
    }

    private String inputNumber() {
        String number = Console.readLine();
        validateInputNumber(number);
        return number;
    }

    private void validateInputNumber(String number) {
        Map<String, Integer> map = new HashMap<>();

        if (number == null) {
            throw new IllegalArgumentException();
        }

        if (number.length() != LENGTH) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < LENGTH; i++) {
            char cur = number.charAt(i);
            if (cur < '1' || cur > '9') {
                throw new IllegalArgumentException();
            } else {
                if (map.containsKey(String.valueOf(cur))) {
                    throw new IllegalArgumentException();
                } else {
                    map.put(String.valueOf(cur), 1);
                }
            }
        }
    }
}
