package pairmatching.domain.menu;

import pairmatching.domain.PairProgram;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public interface CommandMenu {
    void execute(InputView inputView, OutputView outputView, PairProgram pairProgram);
}
