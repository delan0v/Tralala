package com.example.vaadin.client;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Scope;

/**
 * Created by Błażej on 05.06.2016.
 */
@SpringView(name = ViewNames.INDIVIDUAL_ACCOUNT)
@Scope("prototype")
public class IndividualAccount  extends VerticalLayout implements View{
    private TextField mainText;
    private Button withdraw;
    private Button ante;
    private TextArea withdrawMoney;
    private TextArea anteMoney;
    public IndividualAccount() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    //TODO : musisz tutaj dorobić wyświetlanie informacji z bazy danych : Tabelkę możesz przenieść z ClientsView :)
    // ale musi być widoczne tylko dane jednego zalogowanego użykownika
    public void initView(){
        mainText=new TextField();
    }
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj na swoim koncie bankowym");
    }
}
