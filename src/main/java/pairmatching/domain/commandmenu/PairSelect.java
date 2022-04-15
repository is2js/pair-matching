package pairmatching.domain.commandmenu;

import pairmatching.domain.PairMission;
import pairmatching.domain.PairProgram;
import pairmatching.domain.Pairs;
import pairmatching.dto.PairsDto;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairSelect implements CommandMenu {

    @Override
    public void execute(final InputView inputView, final OutputView outputView, final PairProgram pairProgram) {
        final PairMission pairMission = new PairMission(inputView.inputPairMission());
        if (pairProgram.isExistedMatching(pairMission)) {
            final Pairs currentMissionPairs = pairProgram.getCurrentMissionPairs(pairMission);
            outputView.printCurrentMissionPairs((PairsDto.from(currentMissionPairs)));
            return;
        }
        outputView.printNoMatchedPairs();
    }
}
