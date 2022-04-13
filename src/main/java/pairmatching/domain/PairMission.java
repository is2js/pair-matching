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

    public boolean isBackend() {
        return course == Course.BACKEND;
    }

    @Override
    public String toString() {
        return "PairMission{" +
            "course=" + course +
            ", level=" + level +
            ", mission=" + mission +
            '}';
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final PairMission that = (PairMission) object;

        if (course != that.course) {
            return false;
        }
        if (level != that.level) {
            return false;
        }
        return mission == that.mission;
    }

    @Override
    public int hashCode() {
        int result = course != null ? course.hashCode() : 0;
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (mission != null ? mission.hashCode() : 0);
        return result;
    }

    public boolean isSameEndAndLevel(final PairMission pairMission) {
        if (!isSameEnd(pairMission)) {
            return false;
        }
        return isSameLevel(pairMission);
    }

    private boolean isSameLevel(final PairMission pairMission) {
        return level == pairMission.level;
    }

    private boolean isSameEnd(final PairMission pairMission) {
        return course == pairMission.course;
    }
}
