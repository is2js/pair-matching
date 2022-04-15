package pairmatching.domain;

import java.util.Arrays;
import java.util.function.Supplier;
import pairmatching.domain.commandmenu.CommandMenu;
import pairmatching.domain.commandmenu.PairExit;
import pairmatching.domain.commandmenu.PairInit;
import pairmatching.domain.commandmenu.PairMatch;
import pairmatching.domain.commandmenu.PairSelect;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public enum Menu {
    MENU_1("페어 매칭", "1", PairMatch::new),
    MENU_2("페어 조회", "2", PairSelect::new),
    MENU_3("페어 초기화", "3", PairInit::new),
    MENU_Q("종료", "Q", PairExit::new),
    ;

    private final String name;
    private final String command;
    private final Supplier<CommandMenu> commandMenuGenerator;

    Menu(final String name,
         final String command,
         final Supplier<CommandMenu> commandMenuGenerator) {
        this.name = name;
        this.command = command;
        this.commandMenuGenerator = commandMenuGenerator;
    }

    public static Menu from(final String command) {
        return Arrays.stream(Menu.values())
            .filter(it -> it.command.equalsIgnoreCase(command))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당하는 메뉴가 없습니다."));
    }

    public void execute(final InputView inputView, final OutputView outputView, final PairProgram pairProgram) {
        final Supplier<CommandMenu> commandMenuGenerator = getCommandMenuGenerator();
        final CommandMenu commandMenu = commandMenuGenerator.get();
        commandMenu.execute(inputView, outputView, pairProgram);
    }

    public Supplier<CommandMenu> getCommandMenuGenerator() {
        return commandMenuGenerator;
    }
}
