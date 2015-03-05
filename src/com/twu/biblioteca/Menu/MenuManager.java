package com.twu.biblioteca.Menu;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by juhijariwala on 03/03/15.
 */
public class MenuManager {

    private HashMap<Integer,Menu> mainMenuList=new HashMap<Integer, Menu>();

    public void addMainMenuList(Integer choice,Menu menu){
        mainMenuList.put(choice, menu);
    }
    public void navigate(Integer choice) throws IOException {
        mainMenuList.get(choice).executeCommand(0);
    }

}
