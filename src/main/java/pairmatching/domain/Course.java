package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드", "src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

    private String name;
    private final String resourcePath;

    Course(String name, final String resourcePath) {
        this.name = name;
        this.resourcePath = resourcePath;
    }

    public static Course from(final String course) {
        return Arrays.stream(Course.values())
            .filter(it -> it.name.equals(course))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 course입니다."));
    }

    public String getName() {
        return name;
    }

    public String getResourcePath() {
        return resourcePath;
    }
}
