package baseball.domain;

import baseball.util.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 9;
    private static final Integer COUNT_NUMBER = 3;

    public void start() {
        while (true) {
            List<Integer> baseballNumbers = this.generateBaseballNumbers();
            List<Integer> playerNumbers = this.pickThreeNumbers();
            int[] hits = this.checkHitsResult(baseballNumbers, playerNumbers);
        }
    }

    public List<Integer> generateBaseballNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < COUNT_NUMBER) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    private List<Integer> pickThreeNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        Set<Integer> inputNumbers = new HashSet<>();
        for (String number : input.split("")) {
            int numberInteger = Integer.parseInt(number);
            inputNumbers.add(numberInteger);
        }

        if (inputNumbers.size() != 3) {
            throw new IllegalArgumentException();
        }

        return inputNumbers.stream().toList();
    }

    private int[] checkHitsResult(List<Integer> baseballNumbers, List<Integer> playerNumbers) {
        int[] hits = new int[2];

        for (int i = 0; i < baseballNumbers.size(); i++) {
            if (baseballNumbers.get(i).equals(playerNumbers.get(i))) {
                hits[1] += 1;
            }
            if (baseballNumbers.contains(playerNumbers.get(i))) {
                hits[0] += 1;
            }
        }
        return hits;
    }
}
