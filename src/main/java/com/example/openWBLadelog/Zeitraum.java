package com.example.openWBLadelog;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;

import java.util.ArrayList;
import java.util.List;

public class Zeitraum extends VerticalLayout {

    private ComboBox<String> startMonthComboBox;
    private ComboBox<String> endMonthComboBox;
    private IntegerField startYearField;
    private IntegerField endYearField;
    private List<OpenWBLademonat> openWBLademonatList = new ArrayList<>();
    private Grid<OpenWBLademonat> grid;
    private Double gesamteGeladeneKWH = 0.0;
    private Label gesamteGeladeneKWHLabel;

    public Zeitraum() {
        startMonthComboBox = new ComboBox<>("Startmonat");
        startMonthComboBox.setItems(
                "Januar", "Februar", "März", "April", "Mai", "Juni",
                "Juli", "August", "September", "Oktober", "November", "Dezember");
        startMonthComboBox.setPlaceholder("Wähle einen Startmonat");

        endMonthComboBox = new ComboBox<>("Endmonat");
        endMonthComboBox.setItems(
                "Januar", "Februar", "März", "April", "Mai", "Juni",
                "Juli", "August", "September", "Oktober", "November", "Dezember");
        endMonthComboBox.setPlaceholder("Wähle einen Endmonat");

        startYearField = new IntegerField("Startjahr");
        startYearField.setMin(2000);

        endYearField = new IntegerField("Endjahr");
        endYearField.setMin(2000);

        HorizontalLayout startLayout = new HorizontalLayout(startMonthComboBox, startYearField);
        HorizontalLayout endLayout = new HorizontalLayout(endMonthComboBox, endYearField);

        grid = new Grid<>();
        grid.addColumn(OpenWBLademonat::getMonat).setHeader("Monat");
        grid.addColumn(OpenWBLademonat::getJahr).setHeader("Jahr");
        grid.addColumn(OpenWBLademonat::getGeladeneKWHimMonat).setHeader("Geladene kWh");

        gesamteGeladeneKWHLabel = new Label("Gesamte geladene kWh: " + gesamteGeladeneKWH);

        Button submitButton = new Button("Monate ermitteln", event -> {
            String startMonth = startMonthComboBox.getValue();
            String endMonth = endMonthComboBox.getValue();
            Integer startYear = startYearField.getValue();
            Integer endYear = endYearField.getValue();

            if (startMonth != null && endMonth != null && startYear != null && endYear != null) {
                ermittleOpenWBLademonatListe(startMonth, endMonth, startYear, endYear);
                grid.setItems(openWBLademonatList);
                gesamteGeladeneKWH = berechneGesamteGeladeneKWH();
                gesamteGeladeneKWHLabel.setText("Gesamte geladene kWh: " + gesamteGeladeneKWH);
            } else {
                Notification.show("Bitte wähle sowohl einen Start- als auch einen Endmonat sowie die Jahre.");
            }
        });

        add(startLayout, endLayout, submitButton, grid, gesamteGeladeneKWHLabel);
    }

    private double berechneGesamteGeladeneKWH() {
        return openWBLademonatList.stream()
                .mapToDouble(OpenWBLademonat::getGeladeneKWHimMonat)
                .sum();
    }

    private void ermittleOpenWBLademonatListe(String startMonth, String endMonth, int startYear, int endYear) {
        openWBLademonatList.clear();

        int startIndex = getMonatIndex(startMonth);
        int endIndex = getMonatIndex(endMonth);

        if (startYear == endYear) {
            for (int i = startIndex; i <= endIndex; i++) {
                openWBLademonatList.add(new OpenWBLademonat(i, startYear));
            }
        } else {
            for (int i = startIndex; i <= 12; i++) {
                openWBLademonatList.add(new OpenWBLademonat(i, startYear));
            }
            for (int i = 1; i <= endIndex; i++) {
                openWBLademonatList.add(new OpenWBLademonat(i, endYear));
            }
        }
    }

    private int getMonatIndex(String month) {
        switch (month) {
            case "Januar": return 1;
            case "Februar": return 2;
            case "März": return 3;
            case "April": return 4;
            case "Mai": return 5;
            case "Juni": return 6;
            case "Juli": return 7;
            case "August": return 8;
            case "September": return 9;
            case "Oktober": return 10;
            case "November": return 11;
            case "Dezember": return 12;
            default: throw new IllegalArgumentException("Ungültiger Monat: " + month);
        }
    }
}
