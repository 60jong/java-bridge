package bridge.view;

import bridge.Player;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        printBlank();
    }

    public void printAskForBridgeSize() {
        System.out.println("다리 길이를 입력해주세요.");
    }

    public void printAskForStep() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printAskForRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        System.out.println(String.format("[ %s ]", String.join(" | ", player.getUpperFootPrint())));
        System.out.println(String.format("[ %s ]", String.join(" | ", player.getLowerFootPrint())));
        printBlank();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printResult(Player player) {
        System.out.println("최종 게임 결과");
        printMap(player);
        printGameSuccess(player);
        printTrials(player);
    }

    private void printBlank() {
        System.out.println();
    }

    private void printGameSuccess(Player player) {
        System.out.printf("게임 성공 여부: %s\n",isGameSuccess(player));
    }

    private void printTrials(Player player) {
        System.out.printf("총 시도한 횟수: %d\n", player.showTrials());
    }

    private String isGameSuccess(Player player) {
        if (player.isSuccess()) {
            return "성공";
        }
        return "실패";
    }
}
