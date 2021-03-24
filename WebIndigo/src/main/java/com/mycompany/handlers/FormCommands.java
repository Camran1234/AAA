/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.handlers;

import com.mycompany.formats.Component;
import com.mycompany.formats.ErrorIndigo;
import com.mycompany.formats.Form;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author camran1234
 */
public class FormCommands {
    ArrayList<Form> createList = new ArrayList<>();
    ArrayList<Form> modifyList = new ArrayList<>();
    ArrayList<String> deleteList = new ArrayList<>();
    Form form;
    
    /**
     * To add the components to the form
     * @param components 
     */
    public void addComponentsForms(ArrayList<Component> components){
        for(Component component:components){
            for(Form form:createList){
                form.addComponent(component);
            }
        }
    }
    
    public void checkForErrors(){
        for(Form form2:createList){
            form2.checkForSemanticErrors();
        }
        for(Form form1:modifyList){
            form1.checkForSemanticErrors();
        }
    }
    
    public void delete(String id){
        deleteList.add(id);
    }
    public void openModify(String token, int line, int column){
        form = new Form(token, line, column,"modify");
    }
    public void closeModify(){
        modifyList.add(form);
        form.close();
    }
    public void start(String token, int line, int column){
        form = new Form(token, line, column,"new");
    }
    public void close(){
        createList.add(form);
        form.close();
    }
    public void addId(String id){
        form.setId(id);
    }
    public void addTittle(String tittle){
        form.setTittle(tittle);
    }
    public void addName(String name){
        form.setName(name);
    }
    public void addTopic(String topic){
        form.setTopic(topic);
    }
    public void addUser(String user){
        form.setUser(user);
    }
    public void addDate(String date){
        try{
            Date actualDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            form.setDate(actualDate);
        }catch(Exception ex){
            String error = ex.getMessage();
            ErrorCommands.errors.add(new ErrorIndigo(error, form.getToken(), form.getLine(), form.getColumn()));
	}
    }
}
