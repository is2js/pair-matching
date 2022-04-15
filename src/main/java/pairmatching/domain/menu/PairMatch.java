package pairmatching.domain.menu;

import pairmatching.domain.AnswerMenu;
import pairmatching.domain.PairMission;
import pairmatching.domain.PairProgram;
import pairmatching.domain.Pairs;
import pairmatching.dto.PairsDto;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatch implements CommandMenu {

    @Override
    public void execute(final InputView inputView, final OutputView outputView, final PairProgram pairProgram) {
        final PairMission pairMission = new PairMission(inputView.inputPairMission());
        final AnswerMenu answer = AnswerMenu.from(inputView.inputRematch());
        if (pairProgram.isExistedMatching(pairMission) && answer.isNo()) {
            return;
        }
        final Pairs currentMissionPairs = pairProgram.pairMatch(pairMission);
        outputView.printCurrentMissionPairs((PairsDto.from(currentMissionPairs)));
    }
}
