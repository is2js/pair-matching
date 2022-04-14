package pairmatching.domain;

public enum ProgramSwitch {
    ON,
    OFF,
    NONE,
    ;

    public static ProgramSwitch off() {
        return OFF;
    }
}
