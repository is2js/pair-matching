package pairmatching.controller;

import pairmatching.domain.AnswerMenu;
import pairmatching.domain.Menu;
import pairmatching.domain.PairMission;
import pairmatching.domain.PairProgram;
import pairmatching.domain.Pairs;
import pairmatching.dto.PairsDto;
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

//        while (true) {
        while (!pairProgram.isOff()) {

            final Menu menu = Menu.from(inputView.inputMenu());

            if (menu == Menu.MENU_1) {
                pairMatch(pairProgram);
            }
            if (menu == Menu.MENU_2) {
                pairSelect(pairProgram);
            }

            if (menu == Menu.MENU_3) {
                pairProgram.initPairs();
            }

            if (menu == Menu.MENU_Q) {
                pairExit(pairProgram);
            }
        }
    }

    private void pairMatch(final PairProgram pairProgram) {
        final PairMission pairMission = new PairMission(inputView.inputPairMission());
        if (pairProgram.isExistedMatching(pairMission) && AnswerMenu.from(inputView.inputRematch()).isNo()) {
            return; //continue; -> 메서드 추출후 아랫부분 실행안되게 early return;
        }
        final Pairs currentMissionPairs = pairProgram.pairMatch(pairMission);
        outputView.printCurrentMissionPairs((PairsDto.from(currentMissionPairs)));
    }

    private void pairSelect(final PairProgram pairProgram) {
        final String mission = inputView.inputPairMission();
        final PairMission pairMission = new PairMission(mission);
        if (pairProgram.isExistedMatching(pairMission)) {
            final Pairs currentMissionPairs = pairProgram.getCurrentMissionPairs(pairMission);
            outputView.printCurrentMissionPairs((PairsDto.from(currentMissionPairs)));
            return; // continue -> 반복문 속에서의 ealry return;으로 아랫부분 실행안되게
        }
        outputView.printNoMatchedPairs();
    }

    private void pairExit(final PairProgram pairProgram) {
        //break;
        // if안에 break는 메서드 추출로 해결못한다 -> 메서드 추출후 switch off ->
        pairProgram.switchOff();
    }
}
