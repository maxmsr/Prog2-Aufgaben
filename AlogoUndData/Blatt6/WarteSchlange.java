package AlogoUndData.Blatt6;

public interface WarteSchlange {
  // Methode zur Aufnahme des Patienten p in die Warteliste
  public void anmelden(ZPatient p);

  // Methode zum Entfernen des Patienten aus der Warteliste
  public ZPatient derNaechsteBitte();
}
