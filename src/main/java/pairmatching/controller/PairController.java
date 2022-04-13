package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Crews;
import pairmatching.domain.Menu;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMission;
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

        final Menu menu = Menu.from(inputView.inputMenu());

        if (menu == Menu.MENU_1) {
            final String mission = inputView.inputPairMatch();
            final PairMission pairMission = new PairMission(mission);

            //TODO [매칭전] pairMission을 가지고 매칭정보 잇는지 확인해야함 -> 이것들을 모아놓는 DB역할의 컬력션이 있고, 중복검사도 해야함.
            // -> pairMission별 매칭이력 존재하면 map에 value True?
            
            Crews crews = pairProgram.generateCrews(pairMission);
            final List<Pair> pairs = pairProgram.match(crews);

            System.out.println("pairs = " + pairs);
            // TODO [매칭후] pairMission별, 매칭된 pairs를 가지고 있고, 같은 레벨을 다 골라내서, 매칭이력이 있는지 확인한다.
            // -> 이미 같은 페어를 해봤다면, 다시 시도한다.

        }
    }
}
