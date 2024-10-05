package com.example.openWBLadelog;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class OpenWBLademonat extends VerticalLayout {

    private int geladeneKWHimMonat = 0;
    private int monat;
    private int jahr;
    public String verzeichnis = new DirectoryHelper().getDownloadDirectory();

    public OpenWBLademonat(int monat, int jahr) {
        this.monat = monat;
        this.jahr = jahr;
    }



    public String getDateifile(String verzeichnis, int monat, int jahr) {
        return String.format("%s%d%02d.csv", verzeichnis, jahr, monat);
    }


    public int getMonat() {
        return monat;
    }

    public int getJahr() {
        return jahr;
    }

    public double getGeladeneKWHimMonat() {
        String dateipfad = getDateifile(verzeichnis, monat, jahr);
        ArrayList<Double> kwhLadevorgang = new ArrayList<>();
        double kwhGesamtImMonat = 0;
        String line = "";
        final String delimiter = ",";
        try {
            FileReader fileReader = new FileReader(dateipfad);
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                String[] token = line.split(delimiter);
                if (token.length >= 4) {
                    kwhLadevorgang.add(Double.parseDouble(token[3]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            String message = "Monat " + monat +"/" + jahr + " wurde noch nicht runtergeladen oder befindet sich nicht im Zielordner.";
            Notification.show(message, 5000, Notification.Position.MIDDLE);

        }

        for (double kwh : kwhLadevorgang) {
            kwhGesamtImMonat += kwh;
        }

        // Rundet den Wert auf 3 Nachkommastellen
        BigDecimal bd = new BigDecimal(kwhGesamtImMonat);
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        double roundedKwhGesamtImMonat = bd.doubleValue();

        System.out.println(roundedKwhGesamtImMonat);

        return roundedKwhGesamtImMonat;
    }
}
