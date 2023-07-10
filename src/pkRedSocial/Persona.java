package pkRedSocial;

public class Persona extends Integrante implements IActividad{
    
    private int apID;
    private String apNick;
    private int apEdad;
    private char apSexo;
    public Persona(int apID, String apNick, int apEdad, char apSexo){
        this.apID   = apID;
        this.apNick = apNick;
        this.apEdad = apEdad;
        this.apSexo = apSexo;
    }

    public void newPersona (Persona p){
    }
    
    @Override
    public void integrante(int id, String nombre) {
        // TODO Auto-generated method stub
        super.integrante(id, nombre);
    }

    @Override
    public void addAmigo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAmigo'");
    }

    @Override
    public void addAmigoDe() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAmigoDe'");
    }

    @Override
    public void showAmigos() {
        
    }
}
