package pairmatching.domain;

import java.util.Arrays;

public enum AnswerMenu {
    YES("네"),
    NO("아니오"),
    ;

    private final String answer;

    AnswerMenu(final String answer) {
        this.answer = answer;
    }

    public static AnswerMenu from(final String answer) {
        return Arrays.stream(AnswerMenu.values())
            .filter(it -> it.answer.equals(answer))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("정상적인 답변이 아닙니다. 네 | 아니오 중 하나로 대답해주세요"));
    }
}
