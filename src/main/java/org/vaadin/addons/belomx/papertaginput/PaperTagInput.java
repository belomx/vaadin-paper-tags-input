package org.vaadin.addons.belomx.papertaginput;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

import elemental.json.JsonValue;

@Tag("paper-tags-input")
@NpmPackage(value = "@belomx/paper-tags-input", version = "^3.1.9")
@JsModule("@belomx/paper-tags-input/paper-tags-input.js")
@JsModule("./styles/shared-styles.js")
public class PaperTagInput extends AbstractSinglePropertyField<PaperTagInput, JsonValue> implements HasStyle, HasText, HasSize {    
    private static final JsonValue NOT_SET = null;
    private static final long serialVersionUID = 1L;
    
    public PaperTagInput() {
        super("tags", NOT_SET, true);
        addTagsChangedEventListener(e -> {});
    }

    public void setPlaceholder (String placeholder) {
        getElement().setProperty("placeholder", placeholder);
    }
    
    @Override
    public void setText(String text) {
        setLabel(text);
    }

    @Override
    public String getText() {
        return getElement().getProperty("label");
    }
        
    private void setLabel(String label) {
        getElement().setProperty("label", label);
    }   

    @DomEvent("tags-changed-complete")
    public static class TagsChangedEvent extends ComponentValueChangeEvent<PaperTagInput, JsonValue>
    {
        private JsonValue tags;

        public TagsChangedEvent(PaperTagInput source, boolean fromClient, @EventData("event.detail.oldValue") JsonValue oldTags, @EventData("event.detail.value") JsonValue tags)
        {
            super(source, source, oldTags, fromClient);
            source.setValue(tags);
            this.tags=tags;
        }        

        @Override
        public JsonValue getValue() {
            return tags;
        }

    }
    public Registration addTagsChangedEventListener(ComponentEventListener<TagsChangedEvent> listener)
    {
        return addListener(TagsChangedEvent.class, listener);
    }      

}
