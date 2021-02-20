package com.contactbook.controller;

import com.contactbook.view.ContactView;
import com.contactbook.model.ContactModel;

public class ContactController {
    private ContactModel model;
    private ContactView view;

    public void exec()
    {
        view = new ContactView();
        model = new ContactModel(20);
        while(true){
            //Main Cycle
        }
    }
}
