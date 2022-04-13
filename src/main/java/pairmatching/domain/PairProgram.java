package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.utils.FileReader;

public class PairProgram {

    private final Map<PairMission, List<Pair>> pairsPerMission;

    public PairProgram() {
        this.pairsPerMission = new HashMap<>();
    }

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

    public boolean isExistedMatching(final PairMission pairMission) {
//        return pairsPerMission.get(pairMission) != null;
        return pairsPerMission.containsKey(pairMission);
    }

    public boolean isExistedSamePairInSameLevel(final PairMission pairMission, final List<Pair> pairs) {
        // 1. 들어온 미션과 같은 end && 같은 레벨이  level들을 가져와야한다.
        final List<PairMission> sameLevelMissions = pairsPerMission.keySet()
            .stream()
            .filter(pairedMission -> pairedMission.isSameEndAndLevel(pairMission))
            .filter(sameLevelMission -> pairMission != sameLevelMission)
            .collect(Collectors.toList());

        final List<List<Pair>> sameLevelPairsList = sameLevelMissions.stream()
            .map(pairsPerMission::get)
            .collect(Collectors.toList());

        for (final List<Pair> sameLevelPairs : sameLevelPairsList) {
            for (final Pair sameLevelPair : sameLevelPairs) {
                for (final Pair pair : pairs) {
                    sameLevelPair.isSame(pair);
                }
            }
            for (final Pair pair : pairs) {
                if (sameLevelPairs.contains(pair)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void register(final PairMission pairMission, final List<Pair> pairs) {
        pairsPerMission.put(pairMission, pairs);
    }
}
