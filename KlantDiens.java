// Libraries
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class KlantDiens {
    public static void main(String[] args) {
        // Variables
        Random rand = new Random();
        int randTime;
        // Queue of Clients
        Queue<Klant> kliente = new ConcurrentLinkedQueue<Klant>();
        

        // Main
        // Populate klients
        randTime = rand.nextInt(100, 700);
        Klant klient1 = new Klant(randTime, "Daniel");
        randTime = rand.nextInt(100, 700);
        Klant klient2 = new Klant(randTime, "Jaco");
        randTime = rand.nextInt(100, 700);
        Klant klient3 = new Klant(randTime, "Minnie");
        randTime = rand.nextInt(100, 700);
        Klant klient4 = new Klant(randTime, "Helgardt");
        randTime = rand.nextInt(100, 700);
        Klant klient5 = new Klant(randTime, "Renier");
        randTime = rand.nextInt(100, 700);
        Klant klient6 = new Klant(randTime, "Gerhardt");

        // Populate queue
        kliente.add(klient1);
        kliente.add(klient2);
        kliente.add(klient3);
        kliente.add(klient4);
        kliente.add(klient5);
        kliente.add(klient6);
        

        for (Klant klant : kliente) {
            System.out.println("Helping client " + klant.getNaam());
            try {
                Thread.sleep(klant.getDiensTyd()*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Service time for " + klant.getNaam() + ": " + klant.getDiensTyd()/100 + " seconds!");
            kliente.remove(klant);
        }

        System.out.println("All clients have been helped!");
    }
}
