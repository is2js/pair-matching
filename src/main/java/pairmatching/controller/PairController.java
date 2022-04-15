package pairmatching.controller;

import pairmatching.domain.Menu;
import pairmatching.domain.PairProgram;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final PairProgram pairProgram = new PairProgram();

        while (!pairProgram.isOff()) {
            final Menu menu = Menu.from(inputView.inputMenu());
            menu.execute(inputView, outputView, pairProgram);
        }
    }
}
