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
import org.springframework.format.annotation.NumberFormat;

import javax.annotation.PostConstruct;


/**
 * Created by Błażej on 05.06.2016.
 */
@SpringView(name = ViewNames.INDIVIDUAL_ACCOUNT)
@Scope("prototype")
public class IndividualAccountView extends VerticalLayout implements View{
    @Autowired
    private ClientsPresenter clientsPresenter;
    private Button out;
    private TextField ballanceText;
    private TextField nameText;
    private Button withdraw;
    private Button ante;
    private TextArea changeMoney;
    private Clients client;
    @NumberFormat(pattern = "###.##")
    private Float ballance;

    public IndividualAccountView() {
        setMargin(true);
        setSpacing(true);
        client= new Clients();
    }
    @PostConstruct
    public void loadClient(){

        out=new Button("Cofnij");
        withdraw=new Button("Wypłać");
        changeMoney=new TextArea("Podaj wartość");
        ante=new Button("Wpłać");
        ballanceText=new TextField("");
        nameText=new TextField("");
        out.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
        withdraw.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                calculateBallance(true);
                }
        });
        ante.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                calculateBallance(false);
            }
        });
        addComponent(out);
        addComponent(nameText);
        addComponent(ballanceText);
        addComponent(ante);
        addComponent(withdraw);
        addComponent(changeMoney);

    }
    private void calculateBallance(boolean flag){
        if(flag==true){
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
                changeMoney.setValue("Podałeś złą wartość!");
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
        Notification.show("Witaj na swoim koncie bankowym "+client.getName());
        client=clientsPresenter.searchByIdAndName(SessionUtil.getLoggedUserId(),SessionUtil.getLoggedUserName());
        ballanceText.setValue("Saldo: " + client.getBallance());
        nameText.setValue("Witaj "+client.getName());
    }
}
