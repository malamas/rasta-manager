/*
 * Copyright (c) 2015 Apostolis Iakovakis & Malamas Malamidis.
 * All rights reserved.
 *
 * This file is part of Rastaman.
 *
 * Rastaman is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Rastaman is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Rastaman.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package eu.malamas.rastaman.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author Malamas Malamidis
 */
public final class DatabaseHandler {

    private static DatabaseHandler INSTANCE;
    private EntityManagerFactory emf;

    private DatabaseHandler() {
        initDatabase();
    }

    /**
     *
     * @return
     */
    public static DatabaseHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseHandler();
        }
        return INSTANCE;
    }

    /**
     * Αρχικοποιεί τη σύνδεση με τη ΒΔ. Σταματά την εκτέλεση αφού εμφανίσει
     * μήνυμα αποτυχίας σε περίπτωση που η σύνδεση δεν είναι εφικτή.
     */
    private void initDatabase() {
        emf = Persistence.createEntityManagerFactory("RastamanPU");
    }

    /**
     *
     * @return
     */
    public EntityManager getEm() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null,
                    "Η σύνδεση με τη βάση δεδομένων απέτυχε! Η εφαρμογή θα σταματήσει...",
                    "Rastaman",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(1);
        }
        return em;
    }

    /**
     *
     */
    public void close() {
        emf.close();
    }
}
