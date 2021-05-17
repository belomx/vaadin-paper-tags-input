package org.vaadin.addons.belomx.papertaginput.ui;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.vaadin.addons.belomx.papertaginput.PaperTagInput;

@Route("")
@JsModule("./styles/shared-styles.js")
public class DemoView extends VerticalLayout
{

    public DemoView()
    {
        FlexLayout div = new FlexLayout();
        div.getStyle().set("flex-direction", "column");
        div.setWidth("40em");
        div.add(new Label("Paper tag input"));
        
        PaperTagInput inputTags = new PaperTagInput();
        inputTags.addClassName("tag");
        inputTags.setWidth("100%");
        inputTags.setText("Tags test");
        inputTags.setPlaceholder("Add tag");

        final Label selectedValueLabel = new Label("tags:");
        div.add(inputTags, selectedValueLabel);
        
        inputTags.addTagsChangedEventListener(e -> {        
            selectedValueLabel.setText("tags: New value "+e.getValue().asString()+" - Old value "+e.getOldValue().asString());            
        });
        
        add(div);
    }
}
