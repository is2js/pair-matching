package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {
    private final List<Crew> value;

    public Crews(final List<Crew> value) {
        this.value = value;
    }

    public static Crews from(final Course course, final List<String> crewNames) {
        final List<Crew> crews = crewNames.stream()
            .map(crewName -> new Crew(course, crewName))
            .collect(Collectors.toList());
        return new Crews(crews);
    }

    public int size() {
        return value.size();
    }

    public List<Pair> matchPairs() {
        final List<Pair> pairs = new ArrayList<>();
        if (isEven()) {
            return addEvenPairs(pairs);
        }
        return addOddPairs(pairs);
    }

    private List<Pair> addEvenPairs(final List<Pair> pairs) {
        for (int i = 0; i < value.size(); i += 2) {
            final Crew firstCrew = value.get(i);
            final Crew secondCrew = value.get(i + 1);
            pairs.add(new Pair(firstCrew, secondCrew));
        }
        return pairs;
    }

    private List<Pair> addOddPairs(final List<Pair> pairs) {
        // 돌아가는 i를 보존하고 싶다면, 선언부를 바깥으로 빼서 for (; )로 시작해도 된다
        int i = 0;
        for (; i < value.size() - 3; i += 2) {
            final Crew firstCrew = value.get(i);
            final Crew secondCrew = value.get(i + 1);
            pairs.add(new Pair(firstCrew, secondCrew));
        }
        final Crew firstCrew = value.get(i);
        final Crew secondCrew = value.get(i + 1);
        final Crew thirdCrew = value.get(i + 2);
        pairs.add(new Pair(firstCrew, secondCrew, thirdCrew));
        return pairs;
    }

    public boolean isEven() {
        return value.size() % 2 == 0;
    }
}
