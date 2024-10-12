# OpenWBLadelog

OpenWBLadelog zeigt die in einem Monat geladenen KWh summiert an und berechnet die Summe von mehreren Monaten. Dafür müssen die Ladelogs der openWB heruntergeladen werden und sich im standardmäßigen Downloadordner befinden.
Die Benutzeroberfläche ist unter **localhost:8080** erreichbar. 


## Inhaltsverzeichnis
- [Systemanforderungen](#systemanforderungen)
- [Installation](#installation)
- [Verwendung](#verwendung)


## Systemanforderungen

- **Java Development Kit (JDK)**: Version 17
- **Betriebssystem**: Windows, macOS oder Linux (Getestet ist es unter Windows und macOS)

## Installation

1. Lade die neueste Version der .jar-Datei von der [Public Release-Seite](LINK_ZUR_PUBLIC_RELEASE_SEITE) herunter.
2. Stelle sicher, dass du das JDK 17 installiert hast. Du kannst das JDK von der [offiziellen Oracle-Website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) oder einer anderen Quelle herunterladen.
3. Überprüfe, ob die `JAVA_HOME`-Umgebungsvariable korrekt auf das JDK-Verzeichnis gesetzt ist und die `bin`-Verzeichnisse im `PATH` enthalten sind.

## Verwendung

1. Stelle sicher, dass du die .jar-Datei in einem Verzeichnis gespeichert hast.
2. Starte die Anwendung über die Kommandozeile mit folgendem Befehl:

   ```bash
   openWBLadelog-0.0.1-SNAPSHOT.jar

### Hinweise 

Als Grundlage nimmt das Programm immer die zuerst heruntergeladene Excel-Datei eines Monats. Daher muss der Benutzer sicherstellen, dass die Dateien den Stand haben, der zur Auswertung verwendet werden soll.
Das Programm kann nur einmal zur Zeit ausgeführt werden. 
