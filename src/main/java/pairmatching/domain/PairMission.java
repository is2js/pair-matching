package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairMission {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairMission(final String mission) {
        final List<String> missions = Arrays.stream(mission.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
        this.course = Course.from(missions.get(0));
        this.level = Level.from(missions.get(1));
        this.mission = Mission.from(missions.get(2));
    }

    @Override
    public String toString() {
        return "PairMission{" +
            "course=" + course +
            ", level=" + level +
            ", mission=" + mission +
            '}';
    }

    public boolean isBackend() {
        return course == Course.BACKEND;
    }
}
