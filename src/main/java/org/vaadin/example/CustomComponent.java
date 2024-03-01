package org.vaadin.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.dom.Element;

@Tag("custom-component")
@JsModule("./custom-component.ts")
public class CustomComponent extends Component implements HasComponents,HasSize{

	public CustomComponent() {
		this.getElement().addEventListener("content-overflow", event-> {
			System.out.println("content overflowed");
		});
	}
	
	public void addToButtonsBar(Component... components) {
		for(Component component : components) {
			Element elem = component.getElement();
			elem.setAttribute("slot", "buttonSlot");
			getElement().appendChild(elem);
		}
	    
	}
	
	public void addToMenuBar(Component... components) {
		for(Component component : components) {
			Element elem = component.getElement();
			elem.setAttribute("slot", "menuSlot");
			getElement().appendChild(elem);
		}
	}
}
