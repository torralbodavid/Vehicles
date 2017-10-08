package cat.torralbo.poo;

import java.util.ArrayList;
import java.util.Random;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

/**
 * Creat per davidtorralbo el 8/10/17.
 */
class Carrera {

    private static ArrayList<Cotxe> participants = new ArrayList<>();
    private static ArrayList<Cotxe> posicions = new ArrayList<>();

    Carrera() {
        //Genera els participants
        for (int i = 0; i < 5; i++) {
            Cotxe nouParticipant = new Cotxe(nombreAleatori());
            participants.add(nouParticipant);
        }

        //Afegeix el número distintiu a cada vehicle, ex: Turisme2
        for (Cotxe x : participants) {
            x.setTipus(x.getTipus()+nombreTipus(x.getId(), participants.indexOf(x)));
        }
    }

    /*
    Crea la carrera
     */
    void crearCarrera(){
        System.out.println("Preparats per la carrera!\n");
        llistaParticipants();

        System.out.println("\nIniciant carrera\n");
        iniciaCarrera();

        System.out.println("\nFINAL");
        posicionsFinals();
    }

    /*
    Genera un nombre aleatori entre l'1 i el 5
     */
    private static int nombreAleatori(){
        Random rand = new Random();

        return rand.nextInt(5) + 1;
    }

    /*
    Mostra el nombre de tipus de vehicles que hi ha en els participants fins un límit
     */
    private static int nombreTipus(int tipus, int limit){
        int nombreTipus = 0, i = 0;

            for (Cotxe x : participants) {
                if(x.getId() == tipus && limit >= i){
                    nombreTipus++;
                }

                i++;
            }
        return nombreTipus;
    }

    /*
    Genera una llista dels participants
     */
    private static void llistaParticipants(){
        for (Cotxe x : participants) {
            System.out.println("Vehicle "+(participants.indexOf(x)+1)+": "+x.getTipus()+" ("+x.getPassos()+")");
        }
    }

    /*
    Genera una llista dels participants en ordre de més passos a menys
     */
    private static void posicionsOrdre(){
        participants.sort(comparing(Cotxe::getPassos, reverseOrder()));

        for (Cotxe x : participants) {
            System.out.print(x.getTipus()+"("+x.getPassos()+") ");
        }
        System.out.println("\n");
    }

    /*
    Comprova que tots els participants hagin arribat a la meta
     */
    private static boolean participantsMeta(){
        boolean fi;

        int i = 0;
        for (Cotxe ignored : posicions) {
            i++;
        }

        fi = i == 5;

        return fi;
    }

    /*
    Comprova si un participant ja ha arribat a la meta
     */
    private static boolean participantsMeta(String nom){
        boolean comprovant = false;

        for (Cotxe x : posicions) {
            if(x.getTipus().equals(nom)){
                comprovant = true;
                break;
            }
        }

        return comprovant;

    }

    private static void iniciaCarrera(){

        while(!participantsMeta()){
            Cotxe vehicle = participants.get(nombreAleatori()-1);

            //Si els passos+la velocitat del vehicle són  més petits o iguals a 30...
            if(vehicle.getPassos()+vehicle.getVelocitat() <= 30) {
                vehicle.avanca();
                System.out.println(vehicle.getTipus() + " avança " + vehicle.getVelocitat());
                posicionsOrdre();

            } else {
                //si el participant no ha arribat a la meta
                if(!participantsMeta(vehicle.getTipus())) {
                    posicions.add(vehicle);
                }
            }


        }

    }

    private static void posicionsFinals(){
        System.out.println("1r "+posicions.get(0).getTipus());
        System.out.println("2n "+posicions.get(1).getTipus());
        System.out.println("3r "+posicions.get(2).getTipus());
        System.out.println("4t "+posicions.get(3).getTipus());
        System.out.println("5è "+posicions.get(4).getTipus());
    }

}
