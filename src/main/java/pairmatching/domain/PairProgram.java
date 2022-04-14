package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.utils.FileReader;

public class PairProgram {

    private final Map<PairMission, Pairs> pairsPerMission;

    public PairProgram() {
        this.pairsPerMission = new HashMap<>();
    }

    public Crews generateShuffledCrews(final PairMission pairMission) {
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

    public Pairs match(final Crews crews) {
        return new Pairs(crews.matchPairs());
    }

    public boolean isExistedMatching(final PairMission pairMission) {
//        return pairsPerMission.get(pairMission) != null;
        return pairsPerMission.containsKey(pairMission);
    }

    public boolean hasSamePairInSameLevel(final PairMission pairMission, final Pairs pairs) {
        // 1. 들어온 미션과 같은 end && 같은 레벨이  level들을 가져와야한다.
        final List<PairMission> sameLevelMissions = pairsPerMission.keySet()
            .stream()
            .filter(pairedMission -> pairedMission.isSameEndAndLevel(pairMission))
            .filter(sameLevelMission -> pairMission != sameLevelMission)
            .collect(Collectors.toList());

//        final List<Pairs> sameLevelPairs = sameLevelMissions.stream()
//            .map(pairsPerMission::get)
//            .collect(Collectors.toList());

        return sameLevelMissions.stream()
            .map(pairsPerMission::get)
            .anyMatch(sameLevelPairs -> sameLevelPairs.hasSamePair(
                pairs)); // stream안에서도 단순컬렉션이 아니였으면 메세지를 보낼 수 있엇다. -> 단순컬렉션은 메세지를 못보내니 일급으로 만들 것

//        for (final List<Pair> sameLevelPairs : sameLevelPairsList) {
//            for (final Pair sameLevelPair : sameLevelPairs) {
//                for (final Pair pair : pairs) {
//                    sameLevelPair.isSame(pair);
//                }
//            }
//            for (final Pair pair : pairs) {
//                if (sameLevelPairs.contains(pair)) {
//                    return true;
//                }
//            }
//        }

//        return false;
    }

    public void register(final PairMission pairMission, final Pairs pairs) {
        pairsPerMission.put(pairMission, pairs);
    }

    public Pairs checkValidPairs(final PairMission pairMission,
                                 final Crews crews,
                                 Pairs currentPairs) {
        if (hasSamePairInSameLevel(pairMission, currentPairs)) {
            for (int i = 1; i < 3; i++) {
                System.err.println("같은 레벨에서 같은 페어가 발견되었습니다."); //TODO
                currentPairs = match(crews);
                if (!hasSamePairInSameLevel(pairMission, currentPairs)) {
                    return currentPairs;
                }
            }
            throw new IllegalArgumentException("[ERROR] 3번 이상 Matching 이 실패했습니다.");
        }
        return currentPairs;
    }

    public Pairs getCurrentMissionPairs(final PairMission pairMission) {
        return pairsPerMission.get(pairMission);
    }
}
