package com.developerxy.resume.models;

import com.developerxy.resume.sections.exp.Experience;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class ExperienceModel {
    private String title;
    private String when;
    private String description;

    public ExperienceModel(Experience experience) {
        title = experience.title();
        when = experience.when();
        description = experience.description();
    }

    public String getTitle() {
        return title;
    }

    public String getWhen() {
        return when;
    }

    public String getDescription() {
        return description;
    }
}
