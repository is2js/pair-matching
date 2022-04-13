package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import pairmatching.utils.FileReader;

public class PairProgram {

    public Crews generateCrews(final PairMission pairMission) {
        if (pairMission.isBackend()) {
            return generateShuffledCrews(Course.BACKEND);
        }
        return generateShuffledCrews(Course.FRONTEND);
    }

    public Crews generateShuffledCrews(final Course course) {
        final List<String> crewNames = FileReader.readFrom(course.getResourcePath());
        final List<String> shuffledCrew = Randoms.shuffle(crewNames);
        return Crews.from(course, shuffledCrew);
    }

    public List<Pair> match(final Crews crews) {
        return crews.matchPairs();
    }
}
