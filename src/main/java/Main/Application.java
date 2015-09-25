package Main;

import java.awt.EventQueue;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import Controller.Controller;

public class Application {
  // Dit moet eigenlijk deel zijn van de View.
  // Dit kan zonder Thread en alles mag in een try catch block als je toch
  // alleen e.printStackTrace(); doet
  // Als je iets anders wilt doen voor een specifieke exception, een try met
  // multiple catch blocks.

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        try {
          Controller controller = new Controller();
        } catch (UnsupportedAudioFileException | IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
  }
}
