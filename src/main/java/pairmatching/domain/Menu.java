package pairmatching.domain;

import java.util.Arrays;

public enum Menu {
    MENU_1("페어 매칭", "1"),
    MENU_2("페어 조회", "2"),
    MENU_3("페어 초기화", "3"),
    MENU_Q("종료", "Q"),
    ;

    private final String name;
    private final String command;

    Menu(final String name, final String command) {
        this.name = name;
        this.command = command;
    }

    public static Menu from(final String command) {
        return Arrays.stream(Menu.values())
            .filter(it -> it.command.equalsIgnoreCase(command))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당하는 메뉴가 없습니다."));
    }
}
