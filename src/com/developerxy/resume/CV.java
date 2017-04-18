package com.developerxy.resume;

import com.developerxy.resume.sections.acc.Account;
import com.developerxy.resume.sections.acc.Accounts;
import com.developerxy.resume.sections.exp.Experience;
import com.developerxy.resume.sections.exp.Experiences;
import com.developerxy.resume.sections.formation.Formation;
import com.developerxy.resume.sections.formation.Formations;
import com.developerxy.resume.sections.personal.*;
import com.developerxy.resume.sections.proj.Project;
import com.developerxy.resume.sections.proj.Projects;
import com.developerxy.resume.sections.skill.Skills;
import com.developerxy.resume.sections.skill.Tech;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
@PersonalInfo(
        ownerName = @OwnerName("Mohammed Aouf ZOUAG"),
        ownerDescription = @OwnerDescription("Java/Android developer."),
        email = @Email("mohammedaoufzouag@outlook.com"),
        website = @Website("www.developerxy.io"),
        phoneNumber = @PhoneNumber("+212694363053")
)
@Experiences({
        @Experience(title = "Stage de fin d'études (LP) à OctaGen ",
                when = "Avril - Juin 2016 ",
                description = "La création & la mise en place d'une plateforme pour la gestion & la commercialisation des articles.\n" +
                        "Technologies utilisées: Android, Java, Gradle, PHP, MySQL"),
        @Experience(title = "Stage de fin d'études (DUT) à la FMPF ",
                when = "Avril - Juin 2015",
                description = "La réalisation d'une application de gestion des préinscriptions.\n" +
                        "Technologies utilisées: JavaEE, Struts2, jQuery, Java, Swing, MySQL"),
        @Experience(title = "Stage d'initiation ", when = "Août 2014 ",
                description = "Le développement d'une application de gestion d'un stock virtuel.\n" +
                        "Technologies utilisées: C++, Qt, QtCreator, MySQL")
})
@Formations({
        @Formation(when = "2016-2018", description = "Master spécialisé Qualité du Logiciel à la Faculté des Sciences Dhar el Mahraz."),
        @Formation(when = "2015-2016", description = "Licence professionnelle, filière Systèmes d'Information & Génie Logiciel mention Bien, à la Faculté des Sciences Dhar el Mahraz."),
        @Formation(when = "2013-2015", description = "DUT informatique, option Administration des Bases de Données mention AB, à l'Ecole Supérieure de Technologie de Fès."),
        @Formation(when = "2013", description = "Baccalauréat Sciences Mathématiques B, mention Assez Bien.")
})
@Projects({
        @Project(name = "Topik", description = "une application Android de messagerie instantanée réalisée avec Node.js, socket.io, OkHttp3, Picasso & MySQL"),
        @Project(name = "World Weather", description = "une application Android de météo géo-localisée avec l'API Google Maps V2 & Forecast.io"),
        @Project(name = "Spicasso", description = "une application Android de visualisation, téléchargement & upload des photos avec PHP, Retrofit2 & Picasso.")
})
@Skills({
        @Tech(name = "Java", related = {"Java8", "Swing", "JavaFX8", "JavaEE", "Struts2", "JSF", "Spring"}),
        @Tech(name = "Android", related = {"Picasso", "Retrofit2", "OkHttp3", "Google Play Services", "Material Design"}),
        @Tech(name = "Python", related = {"Python 2.x/3.x", "TKinter", "Flask", "Kivy", "SQLAlchemy"})
})
@Accounts({
        @Account(icon = "images/stackoverflow.png", nickname = "MohammedAoufZouag"),
        @Account(icon = "images/github.png", nickname = "DeveloperXY"),
        @Account(icon = "images/google%20play.png", nickname = "MohammedAoufZouag")
})
public class CV {
}
