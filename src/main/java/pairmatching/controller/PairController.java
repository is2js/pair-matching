package pairmatching.controller;

import java.util.List;
import pairmatching.domain.AnswerMenu;
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

        while (true) {

            final Menu menu = Menu.from(inputView.inputMenu());

            if (menu == Menu.MENU_1) {
                final String mission = inputView.inputPairMatch();
                final PairMission pairMission = new PairMission(mission);

                //TODO [매칭전] pairMission을 가지고 매칭정보 잇는지 확인해야함 -> 이것들을 모아놓는 DB역할의 컬력션이 있고, 중복검사도 해야함.
                // -> pairMission별 매칭이력 존재하면 map에 value True?
                if (pairProgram.isExistedMatching(pairMission)) {
                    final AnswerMenu answer = AnswerMenu.from(inputView.inputRematch());
                    if (answer == AnswerMenu.NO) {
                        break; // flag변수, 스위치enum이 필요한 순간.
                    }
                }

                Crews crews = pairProgram.generateCrews(pairMission);
                List<Pair> pairs = pairProgram.match(crews);

                System.out.println("pairs = " + pairs);
                // TODO [매칭후 검증으로서] pairMission별, 매칭된 pairs를 가지고 있고, 같은 레벨을 다 골라내서, 매칭이력이 있는지 확인한다.
                // -> 이미 같은 페어를 해봤다면, 최대 3번까지 다시 시도한다. (index가 아니라 count면 포함시키도록 for문 상수를 짠다)
                if (pairProgram.isExistedSamePairInSameLevel(pairMission, pairs)) {
                    for (int i = 1; i < 3; i++) {
                        System.err.println("같은 레벨에서 같은 페어가 발견되었습니다.");
                        pairs = pairProgram.match(crews);
                        if (!pairProgram.isExistedSamePairInSameLevel(pairMission, pairs)) {
                            break;
                        }
                    }
                    throw new IllegalArgumentException("[ERROR] 3번 이상 Matching 이 실패했습니다.");
                }

                // TODO [매칭후 검증까지 성공]했다면, [프로그램 상태값으로 가진 db인 PairsPerMission에 pais를 등록]해준다.
                pairProgram.register(pairMission, pairs);

            }


        }
    }
}
