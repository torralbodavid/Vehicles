package cat.torralbo.poo;

/**
 * Creat per davidtorralbo el 8/10/17.
 */

class Cotxe {

    private String tipus;
    private int id, velocitat, passos;

    Cotxe(int tipus) {

        switch (tipus){
            case 1:
                this.tipus = "Esportiu";
                this.id = 1;
                this.velocitat = 5;
                this.passos = 0;
                break;
            case 2:
                this.tipus = "Turisme";
                this.id = 2;
                this.velocitat = 4;
                this.passos = 0;
                break;
            case 3:
                this.tipus = "Moto";
                this.id = 3;
                this.velocitat = 3;
                this.passos = 0;
                break;
            case 4:
                this.tipus = "Furgoneta";
                this.id = 4;
                this.velocitat = 2;
                this.passos = 0;
                break;
            case 5:
                this.tipus = "Camió";
                this.id = 5;
                this.velocitat = 1;
                this.passos = 0;
                break;
        }
    }

    String getTipus() {
        return tipus;
    }

    void setTipus(String tipus) {
        this.tipus = tipus;
    }

    int getId() {
        return id;
    }

    int getVelocitat() {
        return velocitat;
    }

    int getPassos() {
        return passos;
    }

    private void setPassos(int passos) {
        this.passos = passos;
    }

    /*
    Aquest mètode permetrà al vehicle avançar segons li permeti la seva velocitat.
     */
    void avanca(){

            try {
                setPassos(getPassos() + getVelocitat());
            } catch (Exception e){
                System.err.println(e.getMessage());
            }

    }
}
