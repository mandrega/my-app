package com.example.vaadin.views.cashpoints;

import com.example.vaadin.data.SamplePerson;
import com.example.vaadin.services.SamplePersonService;
import com.example.vaadin.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Cashpoints")
@Route(value = "my-view", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class CashpointsView extends Composite<VerticalLayout> {

    public CashpointsView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Grid basicGrid = new Grid(SamplePerson.class);
        FormLayout formLayout3Col = new FormLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        TextField textField5 = new TextField();
        TextField textField6 = new TextField();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        basicGrid.setWidth("100%");
        basicGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(basicGrid);
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, formLayout3Col);
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        textField.setLabel("id");
        textField.setWidth("min-content");
        textField2.setLabel("Name");
        textField2.setWidth("min-content");
        textField3.setLabel("Descripcion");
        textField3.setWidth("min-content");
        textField4.setLabel("Opti Id");
        textField4.setWidth("min-content");
        textField5.setLabel("Type");
        textField5.setWidth("min-content");
        textField6.setLabel("Address");
        textField6.setWidth("min-content");
        getContent().add(layoutColumn2);
        layoutColumn2.add(basicGrid);
        layoutColumn2.add(formLayout3Col);
        formLayout3Col.add(textField);
        formLayout3Col.add(textField2);
        formLayout3Col.add(textField3);
        formLayout3Col.add(textField4);
        formLayout3Col.add(textField5);
        formLayout3Col.add(textField6);
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
