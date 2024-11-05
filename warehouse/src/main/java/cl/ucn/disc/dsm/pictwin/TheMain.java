/*
 * Copyright (c) 2024. Departamento de Ingenieria de Sistemas y Computacion
 */

package cl.ucn.disc.dsm.pictwin;

import cl.ucn.disc.dsm.pictwin.model.Persona;
import cl.ucn.disc.dsm.pictwin.model.PicTwin;
import cl.ucn.disc.dsm.pictwin.services.Controller;

import io.ebean.DB;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Objects;

/** The Main. */
@Slf4j
public class TheMain {

    /** Get the File from the resources. */
    private static File getResourceFile(@NonNull String name) {
        return new File(
                Objects.requireNonNull(TheMain.class.getClassLoader().getResource(name)).getFile());
    }

    /** Starting point. */
    public static void main(String[] args) {

        log.debug("Starting TheMain ..");

        Controller c = new Controller(DB.getDefault());

        log.debug("Registering Persona ..");
        Persona p = c.register("durrutia@ucn.cl", "durrutia123");
        log.debug("Persona: {}", p);

        File file = getResourceFile("antofagasta.jpg");
        log.debug("File: {}", file);

        PicTwin pt = c.addPic(p.getUlid(), -23.6509, -70.3975, file);
        log.debug("PicTwin: {}", pt);

        Persona p2 = c.login("durrutia@ucn.cl", "durrutia123");
        log.debug("Persona: {}", p2);

        List<PicTwin> pts = c.getPicTwins(p.getUlid());
        for (PicTwin ptt: pts) {
            log.debug("PicTwin: {}", pt);
        }

        log.debug("Done.");
    }
}





