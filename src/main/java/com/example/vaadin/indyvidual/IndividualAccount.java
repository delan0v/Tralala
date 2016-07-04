package com.example.vaadin.indyvidual;

import com.example.database.model.Clients;
import com.example.database.service.impl.ClientsServiceImpl;
import com.example.util.Session;
import com.example.vaadin.ViewNames;
import com.example.vaadin.client.ClientsPresenter;
import com.sun.security.ntlm.Client;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;


/**
 * Created by Błażej on 05.06.2016.
 */
@SpringView(name = ViewNames.INDIVIDUAL_ACCOUNT)
@Scope("prototype")
public class IndividualAccount extends VerticalLayout implements View{
    @Autowired
    private ClientsPresenter clientsPresenter;
    private Button out;
    private TextField mainText;
    private Button withdraw;
    private Button ante;
    private TextArea changeMoney;
    private Clients client;

    public IndividualAccount() {
        setMargin(true);
        setSpacing(true);
        initView();
        client= new Clients();
    }
    @PostConstruct
    public void loadClient(){

        client=clientsPresenter.searchByIdAndName(Session.getLoggedUserId(),Session.getLoggedUserName());
        mainText=new TextField("Witaj "+client.getName()+", twoje saldo wynosi: " + client.getBallance());
        out=new Button("Cofnij");
        withdraw=new Button("Wypłać");
        changeMoney=new TextArea("Podaj wartość");

        ante=new Button("Wpłać");
        out.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
        withdraw.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                try {
                    client.setBallance(client.getBallance() - Integer.parseInt(changeMoney.getValue()));
                    mainText.setValue("Witaj "+client.getName()+", twoje saldo wynosi: "+client.getBallance()+"zł");
                }
                catch(Exception e){
                    changeMoney.setValue("Podałeś złą wartość!");
                }
            }
        });
        ante.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                try {
                    client.setBallance(client.getBallance() + Integer.parseInt(changeMoney.getValue()));
                    mainText.setValue("Witaj "+client.getName()+", twoje saldo wynosi: "+client.getBallance()+"zł");
                }
                catch(Exception e){
                    changeMoney.setValue("Podałeś złą wartość!");
                }
            }
        });
        addComponent(out);
        addComponent(mainText);
        addComponent(ante);
        addComponent(withdraw);
        addComponent(changeMoney);

    }
    public void initView() {
        mainText = new TextField();
    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj na swoim koncie bankowym");
    }
}
