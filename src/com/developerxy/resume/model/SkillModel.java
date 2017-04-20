package com.developerxy.resume.model;

import com.developerxy.resume.section.skill.Skill;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class SkillModel {
    private String name;
    private String[] related;

    public SkillModel(Skill skill) {
        name = skill.name();
        related = skill.related();
    }

    public String getName() {
        return name;
    }

    public String[] getRelated() {
        return related;
    }
}
