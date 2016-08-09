package com.example.vaadin.indyvidual;

import com.example.database.model.Clients;
import com.example.util.SessionUtil;
import com.example.vaadin.ViewNames;
import com.example.vaadin.client.ClientsPresenter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by Błażej on 05.06.2016.
 */
@SpringView(name = ViewNames.INDIVIDUAL_ACCOUNT)
@Scope("prototype")
public class IndividualAccountView extends HorizontalLayout implements View{
    @Autowired
    private ClientsPresenter clientsPresenter;

    private Button out;
    private Button withdraw;
    private Button ante;
    private TextField ballanceText;
    private TextField nameText;
    private TextField changeMoney;
    private TextField lastLoginTimeAndDate;
    private Clients client;
    private VerticalLayout verticalLayout;
    private HorizontalLayout horizontalLayout;
    private LocalDateTime lastLogin;
    private DateTimeFormatter dateTimeFormatter;
    private Double ballance;

    public IndividualAccountView() {
        setMargin(true);
        setSpacing(true);
        setSizeFull();
    }
    @PostConstruct
    public void loadClient(){

        client = new Clients();
        lastLogin = LocalDateTime.now();
        verticalLayout = new VerticalLayout();
        horizontalLayout = new HorizontalLayout();
        dateTimeFormatter=DateTimeFormatter.RFC_1123_DATE_TIME;

        out = new Button("Cofnij");
        out.setWidth("125");
        out.setHeight("30");
        out.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                client.setLastLogin(String.valueOf(dateTimeFormatter));
               // clientsPresenter.updateClients(client);
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });

        nameText = new TextField();
        nameText.setWidth("200");
        nameText.setHeight("30");

        lastLoginTimeAndDate = new TextField();
        lastLoginTimeAndDate.setWidth("350");
        lastLoginTimeAndDate.setHeight("30");

        ballanceText = new TextField();
        ballanceText.setWidth("200");
        ballanceText.setHeight("30");

        changeMoney = new TextField("Ile chcesz wpłacić/wypłacić?");
        changeMoney.setWidth("200");
        changeMoney.setHeight("30");

        withdraw = new Button("Wypłać");
        withdraw.setWidth("100");
        withdraw.setHeight("30");
        withdraw.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                calculateBallance(true);
            }
        });

        ante = new Button("Wpłać");
        ante.setWidth("100");
        ante.setHeight("30");
        ante.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                calculateBallance(false);
            }
        });

        addComponent(out);
        addComponent(verticalLayout);
        addComponent(lastLoginTimeAndDate);

        verticalLayout.addComponent(nameText);
        verticalLayout.addComponent(ballanceText);
        verticalLayout.addComponent(changeMoney);
        verticalLayout.addComponent(horizontalLayout);

        horizontalLayout.addComponent(ante);
        horizontalLayout.addComponent(withdraw);

        setComponentAlignment(out,Alignment.TOP_LEFT);
        setComponentAlignment(verticalLayout,Alignment.MIDDLE_CENTER);
        setComponentAlignment(lastLoginTimeAndDate,Alignment.BOTTOM_LEFT);

        verticalLayout.setComponentAlignment(nameText,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(ballanceText,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(changeMoney,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(horizontalLayout,Alignment.MIDDLE_CENTER);

        horizontalLayout.setComponentAlignment(ante,Alignment.MIDDLE_CENTER);
        horizontalLayout.setComponentAlignment(withdraw,Alignment.MIDDLE_CENTER);
    }
    private void calculateBallance(boolean flag){
        if(flag == true){
            try {
                ballance=client.getBallance();
                if((ballance-Float.parseFloat(changeMoney.getValue())>=0)) {
                    client.setBallance(client.getBallance() - Float.parseFloat(changeMoney.getValue()));
                    ballanceText.setValue("Saldo: " + ballance + "zł");
                }
                else{
                    ballanceText.setValue("Brak środków na koncie!");
                }
            } catch(NumberFormatException e){
                ballanceText.setValue("Podałeś złą wartość!");
            } catch(Exception e) {
                changeMoney.setValue("Error!");
            }
        }
        else{
            try {
                ballance=client.getBallance();
                client.setBallance(client.getBallance() + Float.parseFloat(changeMoney.getValue()));
                ballanceText.setValue("Saldo: "+client.getBallance()+"zł");
            } catch(NumberFormatException e){
                changeMoney.setValue("Podałeś złą wartość!");
            }catch(Exception e){
                changeMoney.setValue("Error!");
            }
        }
    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        client = clientsPresenter.searchByIdAndName(SessionUtil.getLoggedUserId(),SessionUtil.getLoggedUserName());

        nameText.setValue("Witaj "+client.getName()+" "+client.getSurname());
        ballanceText.setValue("Saldo: " + client.getBallance());
        if(client.getLastLogin()!=null) {
            lastLoginTimeAndDate.setValue("LAST LOGIN: " + client.getLastLogin());
        }
        else{
            lastLoginTimeAndDate.setValue("FIRST LOGIN");
        }
    }
}
