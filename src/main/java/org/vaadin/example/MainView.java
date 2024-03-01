package org.vaadin.example;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean. Use the @PWA
 * annotation make the application installable on phones, tablets and some
 * desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 */
@Route
@PWA(name = "Vaadin Application", shortName = "Vaadin App", description = "This is an example Vaadin application.", enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

	public MainView() {
		CustomComponent cc = new CustomComponent();
		cc.addToButtonsBar(new Button("Button 1"), new Button("Button 2"), new Button("Button 3"),
				new Button("Button 4"), new Button("Button 5"), new Button("Button 6"), new Button("Button 7"),
				new Button("Button 8"));

		MenuBar menuBar = new MenuBar();
		MenuItem actions = menuBar.addItem("Actions");
		SubMenu shareSubMenu = actions.getSubMenu();
		shareSubMenu.add(new Button("Button 1"), new Button("Button 2"), new Button("Button 3"), new Button("Button 4"),
				new Button("Button 5"), new Button("Button 6"), new Button("Button 7"), new Button("Button 8"));
		cc.addToMenuBar(menuBar);
		cc.setWidthFull();

		add(cc);
		setWidthFull();
		setSizeFull();

	}

}
