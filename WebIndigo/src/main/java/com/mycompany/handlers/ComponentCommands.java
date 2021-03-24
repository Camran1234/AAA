/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.handlers;

import com.mycompany.formats.Component;
import java.util.ArrayList;

/**
 *
 * @author camran1234
 */
public class ComponentCommands {
    ArrayList<Component> createList = new ArrayList<>();
    ArrayList<Component> modifyList = new ArrayList<>();
    ArrayList<String> deleteList = new ArrayList<>();
    Component component;
    
    /**
     * Check for semantic errors of the inserted parameters
     */
    public void checkForErrors(){
        for(Component component1:createList){
            component1.checkForSemanticErrors();
            component1.checkForClassErros();
        }
        for(Component component2:modifyList){
            component2.checkForSemanticErrors();
            component2.checkForClassErros();
        }
    }
    
    public ArrayList<Component> getNewComponents(){
        return createList;
    }
    
    public void delete(String id){
        deleteList.add(id);
    }
    public void openModify(String token, int line, int column){
        component = new Component(token,line,column,"modify");
    }
    public void closeModify(){
        createList.add(component);
        component.close();
    }
    public void start(String token, int line, int column){
        component = new Component(token,line,column,"new");
    }
    public void close(){
        modifyList.add(component);
        component.close();
    }
    public void addId(String id){
        component.setId(id);
    }
    public void addCampName(String camp){
        component.setCampName(camp);
    }
    public void addFormName(String name){
        component.setFormName(name);
    }
    public void addClassName(String className){
        component.setClassName(className);
    }
    public void addVisibleText(String visible){
        component.setVisibleText(visible);
    }
    public void addAlign(String align){
        component.setAlign(align);
    }
    public void addRequired(String required){
        component.setRequired(required);
    }
    public void addOptions(String options){
        component.setOptions(options);
    }
    public void addRows(String rows){
        component.setRows(rows);
    }
    public void addCols(String cols){
        component.setCols(cols);
    }
    public void addUrl(String url){
        component.setUrl(url);
    }
    
    
}
    
