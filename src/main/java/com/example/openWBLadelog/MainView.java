package com.example.openWBLadelog;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
@PageTitle("OpenWB Ladelog")
@Route("")
// @CssImport("Pictures/styles.css")
public class MainView extends VerticalLayout {



    public MainView() {

        Component header = new Text("OpenWB Ladelog");
        add(header);

        Zeitraum zeitraum = new Zeitraum();
        add(zeitraum);


    }

}
