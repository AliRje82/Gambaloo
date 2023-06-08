package ir.gambaloo.module;


import ir.gambaloo.Main;
import ir.gambaloo.controller.RestaurantController;
import ir.gambaloo.controller.RestaurantPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.io.Serializable;

public class Restaurant implements Serializable {
    protected int startHour,endHour;
    protected Menu menu=new Menu();
    protected String address;
    protected Country country;
    protected String name;
    protected RestaurantType type;
    protected FXMLLoader page;
    protected RestaurantController controller;

    public FXMLLoader getPage() {
        return page;
    }

    public void setPage(FXMLLoader page) {
        this.page = page;
    }

    public RestaurantController getController() {
        return controller;
    }

    public void setController(RestaurantController controller) {
        this.controller = controller;
    }

    public String getCountry() {
        return String.valueOf ( country );
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return String.valueOf ( type );
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public Menu getMenu() {
        return menu;
    }

    public String getAddress() {
        return address;
    }

    public Restaurant( int startHour, int endHour, String address, Country country, String name) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.address = address;
        this.country=country;
        this.name=name;
        page=new FXMLLoader(Main.class.getResource("view/RestaurantPage.fxml"));
        try {
            page.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         controller =page.getController();
        controller.getName().setText(name);
    }
    public String workHour(){
        return "From "+startHour+"To "+endHour;
    }

}
