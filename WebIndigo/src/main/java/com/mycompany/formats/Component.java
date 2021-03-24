/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formats;

import com.mycompany.handlers.ErrorCommands;

/**
 *
 * @author camran1234
 */
public class Component implements ErrorHandler{
    private String type;
    private String id;
    private String campName;
    //formName==idName
    private String formName;
    private String className;
    private String visibleText;
    private String align;
    private String required="NO";
    private String options;
    private int rows;
    private int cols;
    private String url;
    private boolean activated=false;
    private String token;
    private int line;
    private int column;
    
    
    
    public Component(String token, int line, int column, String type){
        this.token = token;
        this.line = line;
        this.column = column;
        this.type = type;
        this.activated=true;
    }
    
    public void close(){
        activated=false;
    }
    
    public String getFormName(){
        return this.formName;
    }
    
    public void checkForClassErros(){
        String errorMessage="";
        if(className.equalsIgnoreCase("CAMPO_TEXTO")){
            if( url!=null || options!=null||rows!=0||cols!=0){
                if(url!=null){
                    errorMessage+=" se agrego una url cuando es la clase CAMPO_TEXTO";
                }
                if(options!=null){
                    errorMessage+=" se agrego opciones cuando la clase es CAMPO_TEXTO";
                }
                if(rows!=0){
                    errorMessage+=" se agrego filas cuando la clase es CAMPO_TEXTO";
                }
                if(cols!=0){
                    errorMessage+=" se agrego columnas cuando la clase es CAMPO_TEXTO";
                }
                this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
            }
        }else if(className.equalsIgnoreCase("AREA_TEXTO")){
            if(rows==0||cols==0 || url!=null || options!=null){
                if(rows==0){
                    errorMessage+=" no se agregaron filas al AREA_TEXTO, agrega un numero superior a 0";
                }
                if(cols==0){
                    errorMessage+=" no se agregaron columnas al AREA_TEXTO, agrega un numero superior a 0";
                }
                if(url!=null){
                    errorMessage+=" se agrego una URL cuando la clase es AREA_TEXTO";
                }
                if(options!=null){
                    errorMessage+=" se agregaron opciones cuando la clase es AREA_TEXTO";
                }
                
                this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
            }
        }else if(className.equalsIgnoreCase("CHECKBOX")){
            if(url!=null|| rows!=0 || cols!=0|| options==null){
                if(url!=null){
                    errorMessage+=" se agrego una URL cuando la clase es CHECKBOX, favor de quitarla";
                }
                if(rows!=0){
                    errorMessage+=" se agrego FILAS cuando la clase es CHECKBOX, retirar FILAS";
                }
                if(cols!=0){
                    errorMessage+=" se agrego COLUMNAS cuando la clase es CHECKBOX, retirar COLUMNAS";
                }
                if(options==null){
                    errorMessage+=" no se agregaron las opciones para el CHECKBOX, favor de agregar opciones";
                }
                this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
            }
        }else if(className.equalsIgnoreCase("RADIO")){
            if(options==null||rows!=0||cols!=0||url!=null){
                if(options==null){
                    errorMessage+=" no se agregaron opciones para la clase RADIO, agregar OPCIONES";
                }
                if(rows!=0){
                    errorMessage+=" se agregaron FILAS cuando la clase es RADIO, quitar las FILAS";
                }
                if(cols!=0){
                    errorMessage+=" se agregaron COLUMNAS cuando la clase es RADIO, quitar las COLUMNAS";
                }
                if(url!=null){
                    errorMessage+=" se agrego una URL cuando la clase es RADIO, quitar la URL";
                }
                this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
            }
            
        }else if(className.equalsIgnoreCase("FICHERO")){
            if( url!=null || options!=null||rows!=0||cols!=0){
                if(url!=null){
                    errorMessage+=" se agrego una url cuando la clase es FICHERO";
                }
                if(options!=null){
                    errorMessage+=" se agrego opciones cuando la clase es FICHERO";
                }
                if(rows!=0){
                    errorMessage+=" se agregaron filas cuando la clase es FICHERO";
                }
                if(cols!=0){
                    errorMessage+=" se agregaron columnas cuando la clase es FICHERO";
                }
                
                this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
            }
        }else if(className.equalsIgnoreCase("IMAGEN")){
            if( url==null || options!=null||rows!=0||cols!=0){
                if(url==null){
                    errorMessage+=" no se agrego una url para colocar la IMAGEN";
                }
                if(options!=null){
                    errorMessage+=" se agregaron OPCIONES a la clase IMAGEN";
                }
                if(rows!=0){
                    errorMessage+=" se agregaron filas cuando la clase es IMAGEN";
                }
                if(cols!=0){
                    errorMessage+=" se agregaron columnas cuando la clase es IMAGEN";
                }
                this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
            }
        }else if(className.equalsIgnoreCase("COMBO")){
            if(options==null||rows!=0||cols!=0||url!=null){
                if(options==null){
                    errorMessage+=" no se agrego OPCIONES a la clase COMBO";
                }
                if(rows!=0){
                    errorMessage+=" se agrego filas cuando la clase  es COMBO";
                }
                if(cols!=0){
                    errorMessage+=" se agrego columnas cuando la clase es COMBO";
                }
                if(url!=null){
                    errorMessage+=" se agrego una url cuando la clase es COMBO";
                }
                this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
            }            
        }else if(className.equalsIgnoreCase("BOTON")){
            if( url!=null || options!=null||rows!=0||cols!=0){
                if(url!=null){
                    errorMessage+=" se agrego una url cuando es la clase BOTON";
                }
                if(options!=null){
                    errorMessage+=" se agrego opciones cuando la clase es BOTON";
                }
                if(rows!=0){
                    errorMessage+=" se agrego filas cuando la clase es BOTON";
                }
                if(cols!=0){
                    errorMessage+=" se agrego columnas cuando la clase es BOTON";
                }
                this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
            }
        }
    }
    
    @Override
    public void checkForSemanticErrors(){
        String errorMessage="";
        if(!activated){
            if(type.equalsIgnoreCase("new")){
                if(id==null||campName==null||formName==null||className==null||visibleText==null){
                    if(id==null){
                        errorMessage+=" no se agrego un id para el componente formulario";
                    }
                    if(campName==null){
                        errorMessage+=" no se agrego un nombre de campo para el componente";
                    }
                    if(formName==null){
                        errorMessage+=" no se agrego el nombre de formulario perteneciente";
                    }
                    if(className==null){
                        errorMessage+=" no se agrego una clase de componenete especificada";
                    }
                    if(visibleText==null){
                        errorMessage+=" no se agrego un texto visible para el componente";
                    }
                    this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
                }
            }else{
                if(id==null||formName==null){
                    if(id==null){
                        errorMessage+=" no se agrego un id para el componente para modificar";
                    }
                    if(formName==null){
                        errorMessage+=" no se agrego un nombre del formulario perteneciente para modificar";
                    }
                    this.addSemanticError(new ErrorIndigo(errorMessage, token, line, column));
                }
            }
        }else{
            errorMessage = "Error Fatal no se cerro correctamente el formulario";
            addSemanticError(new ErrorIndigo(errorMessage,token,line,column));
        }
    }
    
    private void addSemanticError(ErrorIndigo newError){
        ErrorCommands.errors.add(newError);
    }
    
    public void setId(String id) {
        if(activated){
            this.id = id;
        }
    }

    public void setCampName(String campName) {
        if(activated){
            this.campName = campName;
        }
    }

    public void setFormName(String formName) {
        if(activated){
            this.formName = formName;
        }
    }

    public void setClassName(String className) {
        if(activated){
            this.className = className;
        }
    }

    public void setVisibleText(String visibleText) {
        if(activated){
            this.visibleText = visibleText;
        }
    }

    public void setAlign(String align) {
        if(activated){
            this.align = align;
        }        
    }

    public void setRequired(String required) {
        if(activated){
            this.required = required;
        }
    }

    public void setOptions(String options) {
        if(activated){
            this.options = options;
        }
    }

    public void setRows(String rows) {
        if(activated){
            try {
                this.rows = Integer.parseInt(rows);
            } catch (Exception e) {
                ErrorIndigo error = new ErrorIndigo(e.getMessage(),token, line, column);
                this.addSemanticError(error);
            }
        }        
    }

    public void setCols(String cols) {
        if(activated){
            try {
                this.cols = Integer.parseInt(cols);
            } catch (Exception e) {
                ErrorIndigo error = new ErrorIndigo(e.getMessage(),token, line, column);
                this.addSemanticError(error);
            }
        }
    }

    public void setUrl(String url) {
        if(activated){
            this.url = url;
        }
    }
    
    
    
    
}
