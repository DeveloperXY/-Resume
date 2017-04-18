package com.developerxy.resume;

import com.developerxy.resume.models.ExperienceModel;
import com.developerxy.resume.models.FormationModel;
import com.developerxy.resume.models.PersonalInfoModel;
import com.developerxy.resume.sections.exp.Experience;
import com.developerxy.resume.sections.exp.Experiences;
import com.developerxy.resume.sections.formation.Formation;
import com.developerxy.resume.sections.formation.Formations;
import com.developerxy.resume.sections.personal.PersonalInfo;
import com.developerxy.resume.util.HTMLWriter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
public abstract class CV {

    private HTMLWriter htmlWriter;

    public void build() {
        Class<?> cls = getClass();
        try (HTMLWriter htmlWriter = new HTMLWriter("resources/index.html")) {
            this.htmlWriter = htmlWriter;
            htmlWriter.setDoctype()
                    .writeOpeningTag("html")
                    .writeContent(getHeadRawText())
                    .writeOpeningTag("body")
                    .writeOpeningTagWithClass("div", "wrapper");

            writePersonalInfo(cls);
            htmlWriter.writeOpeningTagWithClass("div", "main");
            writeSections(cls);

            htmlWriter.writeClosingTag("div")
                    .writeClosingTag("div")
                    .writeClosingTag("body")
                    .writeClosingTag("html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writePersonalInfo(Class<?> cls) {
        htmlWriter.writeContent(getFormattedHeader(
                new PersonalInfoModel(cls.getAnnotation(PersonalInfo.class))));
    }

    private void writeSections(Class<?> cls) {
        writeExperiences(cls);
        writeFormations(cls);
    }

    private void writeSectionHeader(String label) {
        htmlWriter.writeOpeningTagWithClass("div", "section")
                .writeOpeningTagWithClass("div", "label")
                .writeContent(label)
                .writeClosingTag("div")
                .writeOpeningTagWithClass("div", "content-wrapper");
    }

    private void writeExperiences(Class<?> cls) {
        writeSectionHeader("Expérience");

        Experience[] experiences = cls.getAnnotation(Experiences.class).value();
        Arrays.asList(experiences).forEach(this::writeExperience);

        htmlWriter.writeClosingTag("div")
                .writeClosingTag("div");
    }

    private void writeExperience(Experience experience) {
        htmlWriter.writeContent(getFormattedExperienceText(
                new ExperienceModel(experience)));
    }

    private void writeFormations(Class<?> cls) {
        writeSectionHeader("Formation");

        Formation[] formations = cls.getAnnotation(Formations.class).value();
        Arrays.asList(formations).forEach(this::writeFormation);

        htmlWriter.writeClosingTag("div")
                .writeClosingTag("div");
    }

    private void writeFormation(Formation formation) {
        htmlWriter.writeContent(getFormattedFormationText(
                new FormationModel(formation)));
    }

    private String getFormattedExperienceText(ExperienceModel model) {
        return String.format("<div class=\"content row\">\n" +
                "                            <span class=\"title\">\n" +
                "                                %s\n" +
                "                            </span>\n" +
                "                            <br/>\n" +
                "                            <span class=\"date\">\n" +
                "                                %s\n" +
                "                            </span>\n" +
                "                            <br/>\n" +
                "                            <span class=\"text\">\n" +
                "                                %s\n" +
                "                            </span>\n" +
                "                        </div>",
                model.getTitle(), model.getWhen(), model.getDescription());
    }
    private String getFormattedFormationText(FormationModel model) {
        return String.format("<div class=\"content row\">\n" +
                        "                            <span class=\"title keyword\">\n" +
                        "                                %s\n" +
                        "                            </span>\n" +
                        "                            <br/>\n" +
                        "                            <span class=\"text\">\n" +
                        "                                %s\n" +
                        "                            </span>\n" +
                        "                        </div>",
                model.getWhen(), model.getDescription());
    }

    private String getHeadRawText() {
        return "<head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "        <link href='http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel='stylesheet'\n" +
                "              type='text/css'>\n" +
                "        <link rel=\"stylesheet\" href=\"./style.css\">\n" +
                "    </head>";
    }

    private String getFormattedHeader(PersonalInfoModel model) {
        return String.format("<div class=\"header\">\n" +
                        "                <div class=\"profile_image\"></div>\n" +
                        "                <div class=\"name\">\n" +
                        "                    <span>%s</span>\n" +
                        "                    <span>%s</span>\n" +
                        "                </div>\n" +
                        "                <div class=\"details\">\n" +
                        "                    <span>e: %s</span>\n" +
                        "                    <span>w: %s</span>\n" +
                        "                    <span>m: %s</span>\n" +
                        "                </div>\n" +
                        "            </div>",
                model.getOwnerName(), model.getOwnerDescription(), model.getEmail(),
                model.getWebsite(), model.getPhoneNumber());
    }
}
