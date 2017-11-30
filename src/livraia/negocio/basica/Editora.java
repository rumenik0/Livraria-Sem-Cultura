/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraia.negocio.basica;

/**
 *
 * @author aluno
 */
public class Editora {
    
    public Editora(){}
    
    public Editora(String razaoSocial, String telefone){
            this.razaoSocial = razaoSocial;
            this.telefone = telefone;
    }
    public Editora(Integer codigo,String razaoSocial, String telefone){
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
    }
        
    private Integer codigo;
    private String razaoSocial;
    private String telefone;

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
}
