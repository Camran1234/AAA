/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formats;

/**
 *
 * @author camran1234
 */
public class Login {
    private boolean activated=false;
    private String user;
    private String password;
    private String token;
    private int line;
    private int column;
    
    public Login(String token, int line, int column){
        activated = true;
        this.token = token;
        this.line = line;
        this.column = column;
    }
    
    
    
    public void closeLogin(){
        activated=false;
    }
    public boolean getUser(String user){
        if(activated=true){
            this.user = user;
            return true;
        }
        return false;
    }
    public boolean getPassword(String password){
        if(activated=true){
            this.password = password;
            return true;
        }
        return false;
    }
    
}
