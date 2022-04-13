package pairmatching.domain;

public class Crew {
    private Course course;
    private String name;

    public Crew(final Course course, final String name) {
        this.course = course;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Crew{" +
            "course=" + course +
            ", name='" + name + '\'' +
            '}';
    }
}


