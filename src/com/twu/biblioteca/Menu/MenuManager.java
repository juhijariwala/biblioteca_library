package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Menu.MenuItem.MenuItem;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by juhijariwala on 03/03/15.
 */
public class MenuManager {

    private HashMap<Integer, Menu> mainMenuList = new HashMap<Integer, Menu>();

    public void addMainMenuList(Integer choice, Menu menu) {
        mainMenuList.put(choice, menu);
    }


    public void execute(IODevice ioDevice) throws IOException {
        Integer choice = -1;
        do {
            try {

                ioDevice.writeln(printMainMenu());
                choice = Integer.parseInt(ioDevice.read());
                mainMenuList.get(choice).executeCommand(0);
            } catch (NumberFormatException e) {
                ioDevice.writeln("Invalid Option!\n");
            }

        } while (choice != 0);


    }

    public String printMainMenu() {
        String menuStatement = "Welcome to Bibliotica App!!\n";
        menuStatement += "**************** Menu ****************\n";
        for (Map.Entry<Integer, Menu> menuPair : mainMenuList.entrySet()) {

            MenuItem mainMenuItem = (MenuItem) menuPair.getValue().getLibraryCommands().get(0);
            if (mainMenuItem.shouldShowMenu()) {
                menuStatement += "|\t" + mainMenuItem.printMenu() + " " + menuPair.getValue().getMenuTitle() + " : Press " + menuPair.getKey() + "\n";
            }
        }
        menuStatement += "*****************************************************\n";
        menuStatement += "Enter your choice:";
        return menuStatement;
    }
}
