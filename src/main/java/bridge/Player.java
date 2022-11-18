package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Bridge bridge;
    private List<List<String>> stepsInTotalRound = new ArrayList<>();
    private int round = 0;

    public Player(Bridge bridge) {
        this.bridge = bridge;
    }

    public int getLocation() {
        if (isNewRound()) {
            stepsInTotalRound.add(new ArrayList<>());
            round++;
        }
        return stepsInTotalRound.get(round - 1).size();
    }

    private boolean isNewRound() {
        if (stepsInTotalRound.size() == round) {
            return true;
        }
        return false;
    }
}
