package pairmatching.domain.commandmenu;

import pairmatching.domain.PairProgram;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairExit implements CommandMenu {

    @Override
    public void execute(final InputView inputView, final OutputView outputView, final PairProgram pairProgram) {
        pairProgram.switchOff();
    }
}
