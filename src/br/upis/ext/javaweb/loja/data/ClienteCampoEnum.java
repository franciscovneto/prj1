package br.upis.ext.javaweb.loja.data;

/**
 * Created by franciscovneto on 10/09/16.
 */
public enum ClienteCampoEnum {

    CPF("cpf"),
    NOME("nome");

    String campo;

    ClienteCampoEnum(String campo) {
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}
