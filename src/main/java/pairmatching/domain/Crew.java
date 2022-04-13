package pairmatching.domain;

public class Crew {
    private Course course;
    private String name;

    public Crew(final Course course, final String name) {
        this.course = course;
        this.name = name;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Crew crew = (Crew) object;

        if (course != crew.course) {
            return false;
        }
        return getName() != null ? getName().equals(crew.getName()) : crew.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = course != null ? course.hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Crew{" +
            "course=" + course +
            ", name='" + name + '\'' +
            '}';
    }

    public String getName() {
        return name;
    }
}


